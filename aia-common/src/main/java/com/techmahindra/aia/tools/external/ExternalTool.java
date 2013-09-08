package com.techmahindra.aia.tools.external;

/**
 * Defines the methods for interacting with external tools. e.g. Perl, Python, etc
 * <p/>
 *
 * @author Christian
 */
public interface ExternalTool {

    /**
     * Checks if an external tool exist in the system.
     *
     * @return True if an external tool exist in the system. False, if otherwise.
     */
    boolean exist();

    /**
     * Returns the version of the tool installed.
     * <p/>
     *
     * @return the version of the tool installed.
     */
    String getVersion();
}