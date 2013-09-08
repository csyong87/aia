package com.techmahindra.aia.tools.external;

/**
 * Checks for the presence of PerlDetector in the system.
 * <p/>
 * Executes the command {@code perl -version} through {@link Runtime#exec(String)}}
 *
 * @author Christian
 */
public class PerlDetector implements ExternalTool {

    /**
     * Checks if an external tool exist in the system.
     *
     * @return True if an external tool exist in the system. False, if otherwise.
     */
    @Override
    public boolean exist() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Returns the version of the tool installed.
     * <p/>
     *
     * @return the version of the tool installed.
     */
    @Override
    public String getVersion() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
