package com.techmahindra.aia.tools.external;

import com.techmahindra.aia.constants.Constants;
import com.techmahindra.aia.tools.exec.LogOutputStreamCollector;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.ExecuteResultHandler;
import org.apache.commons.exec.ExecuteStreamHandler;
import org.apache.commons.exec.Executor;

/**
 * Checks for the presence of Python on the system.
 * <p/>
 * Executes {@code python --version} through {@link Runtime#exec(String)}.
 *
 * @author Christian
 */
public class PythonDetector extends AbstractExternalToolDetector {

    /**
     * Pattern for getting the python version.
     * <p/>
     * (\d+\.*)+ - One or more group of digit followed by a dot '.'. The asterisk '*' after the \d and \. indicates
     * 0 or more instances
     */
    private static final String PYTHON_VERSION_PATTERN = "(\\d+\\.*)+";
    private String version;

    /**
     * Creates a {@link PerlDetector}
     *
     * @param output        The class where the execution output steam will be collected
     * @param executor      The command executor
     * @param streamHandler The class that will handle the output steam
     * @param resultHandler The result handler that will be called once the process is complete
     */
    public PythonDetector(final LogOutputStreamCollector output, final Executor executor,
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
        CommandLine cmdLine = CommandLine.parse("python");
        cmdLine.addArgument("--version");
        return cmdLine;
    }

    /**
     * Returns the pattern for matching the version.
     *
     * @return The pattern for matching the version
     */
    @Override
    protected String getVersionPattern() {
        return PYTHON_VERSION_PATTERN;
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
