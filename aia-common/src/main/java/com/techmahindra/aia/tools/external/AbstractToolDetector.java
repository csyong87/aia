package com.techmahindra.aia.tools.external;

import com.techmahindra.aia.constants.Constants;
import com.techmahindra.aia.tools.exec.LogOutputStreamCollector;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.ExecuteResultHandler;
import org.apache.commons.exec.ExecuteStreamHandler;
import org.apache.commons.exec.Executor;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Executes the {@link CommandLine getCommand} and parses the tool version using the pattern referred by {@code
 * getVersionPattern}
 *
 * @author Christian
 */
public abstract class AbstractToolDetector implements Tool {

    private LogOutputStreamCollector output;
    private ExecuteStreamHandler streamHandler;
    private Executor executor;
    private ExecuteResultHandler resultHandler;

    /**
     * @param output        The class where the execution output steam will be collected
     * @param executor      The command executor
     * @param streamHandler The class that will handle the output steam
     * @param resultHandler The result handler that will be called once the process is complete
     */
    protected AbstractToolDetector(final LogOutputStreamCollector output, final Executor executor,
            final ExecuteStreamHandler streamHandler, final ExecuteResultHandler resultHandler) {
        this.output = output;
        this.executor = executor;
        this.streamHandler = streamHandler;
        this.resultHandler = resultHandler;
    }

    /**
     * Executes the {@link CommandLine getCommand} asynchronously.
     */
    protected void execCommand() {
        try {
            executor.setStreamHandler(streamHandler);
            executor.execute(getCommand(), resultHandler);

            Pattern pattern = Pattern.compile(getVersionPattern());

            for (String lines : output.getLinkedList()) {
                Matcher matcher = pattern.matcher(lines);
                if (matcher.find()) {
                    setVersion(matcher.group());
                    return;
                }
            }

            setVersion(Constants.VERSION_NOT_AVAILABLE);
        } catch (Exception e) {
            StringBuilder msg = new StringBuilder(getCommand().getExecutable());
            for (String args : getCommand().getArguments()) {
                msg.append(StringUtils.leftPad(args, args.length() + 1));
            }
            throw new RuntimeException("Unable to execute " + msg, e);
        }
    }

    /**
     * The {@link CommandLine command}  to be executed
     *
     * @return The {@link CommandLine command}  to be executed
     */
    protected abstract CommandLine getCommand();

    /**
     * Returns the pattern for matching the version.
     *
     * @return The pattern for matching the version
     */
    protected abstract String getVersionPattern();

    /**
     * Sets the {@code version} of the tool installed.
     *
     * @param version The version of the tool installed
     */
    protected abstract void setVersion(String version);
}
