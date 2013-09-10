package com.techmahindra.aia.tools.external;

import com.techmahindra.aia.constants.Constants;
import com.techmahindra.aia.tools.exec.LogOutputStreamCollector;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.ExecuteResultHandler;
import org.apache.commons.exec.ExecuteStreamHandler;
import org.apache.commons.exec.Executor;

/**
 * Checks for the presence of PerlDetector in the system.
 * <p/>
 * Executes the command {@code perl -version} through {@link Runtime#exec(String)}}
 *
 * @author Christian
 */
public class PerlDetector extends AbstractToolDetector {

    /**
     * Pattern for getting perl version.
     * <p/>
     * v - Has to start with 'v' <br/>
     * (\d+\.*)+ - One or more group of digit followed by a dot '.'. The plus '+' after the \d indicates 1 or
     * more instances of a digit, the asterisk '*' after the \. indicates 0 or more instances of the dot '.' sign
     * 0 or more instances
     */
    private static final String PERL_VERSION_PATTERN = "v(\\d+\\.*)+";
    private String version;

    /**
     * Creates a {@link PerlDetector}
     *
     * @param output        The class where the execution output steam will be collected
     * @param executor      The command executor
     * @param streamHandler The class that will handle the output steam
     * @param resultHandler The result handler that will be called once the process is complete
     */
    public PerlDetector(final LogOutputStreamCollector output, final Executor executor,
            final ExecuteStreamHandler streamHandler, final ExecuteResultHandler resultHandler) {
        super(output, executor, streamHandler, resultHandler);
    }

    /**
     * The {@link org.apache.commons.exec.CommandLine command}  to be executed
     *
     * @return The {@link org.apache.commons.exec.CommandLine command}  to be executed
     */
    @Override
    protected CommandLine getCommand() {
        CommandLine cmdLine = CommandLine.parse("perl");
        cmdLine.addArgument("-version");
        return cmdLine;
    }

    /**
     * Returns the pattern for matching the version.
     *
     * @return The pattern for matching the version
     */
    @Override
    protected String getVersionPattern() {
        return PERL_VERSION_PATTERN;
    }

    /**
     * Checks if an external tool exist in the system.
     *
     * @return True if an external tool exist in the system. False, if otherwise.
     */
    @Override
    public boolean exist() {
        if (version == null) {
            execCommand();
        }

        return !version.equalsIgnoreCase(Constants.VERSION_NOT_AVAILABLE);
    }

    /**
     * Returns the version of the tool installed.
     * <p/>
     *
     * @return the version of the tool installed.
     */
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * Sets the {@code version} of the tool installed.
     *
     * @param version The version of the tool installed
     */
    @Override
    protected void setVersion(final String version) {
        this.version = version;
    }
}
