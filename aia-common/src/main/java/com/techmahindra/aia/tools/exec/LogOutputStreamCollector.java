package com.techmahindra.aia.tools.exec;

import org.apache.commons.exec.LogOutputStream;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 9/8/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogOutputStreamCollector extends LogOutputStream {

    private List<String> linkedList = new LinkedList<String>();

    @Override
    protected void processLine(final String s, final int i) {
        linkedList.add(s);
    }

    public List<String> getLinkedList() {
        return linkedList;
    }
}
