package com.techmahindra.aia.tools.external;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 9/8/13
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class PythonDetector implements ExternalTool{
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
