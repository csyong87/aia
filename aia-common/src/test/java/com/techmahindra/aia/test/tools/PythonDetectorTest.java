package com.techmahindra.aia.test.tools;

import com.techmahindra.aia.tools.exec.LogOutputStreamCollector;
import com.techmahindra.aia.tools.external.PythonDetector;
import org.apache.commons.exec.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Christian
 */
public class PythonDetectorTest {

    private LogOutputStreamCollector output;
    private Executor executor;
    private PumpStreamHandler psh;
    private DefaultExecuteResultHandler erh;

    @Before
    public void setUp() {
        output = mock(LogOutputStreamCollector.class);
        executor = mock(Executor.class);
        psh = mock(PumpStreamHandler.class);
        erh = mock(DefaultExecuteResultHandler.class);

    }

    @Test
    public void itShouldReturnFalseIfNoPythonIsInstalled() throws IOException {
        List<String> list = new LinkedList<String>();
        list.add("'python' is not recognized as an internal or external command,operable program or batch file.");

        doAnswer(new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return "called with arguments: " + args;
            }
        }).when(executor).execute(any(CommandLine.class), any(ExecuteResultHandler.class));

        when(output.getLinkedList()).thenReturn(list);

        PythonDetector pd = new PythonDetector(output, executor, psh, erh);
        Assert.assertFalse(pd.exist());
    }

    @Test
    public void itShouldReturnTrueIfPythonIsInstalled() throws IOException {
        List<String> list = new LinkedList<String>();
        list.add("Python 3.3.2");

        doAnswer(new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return "called with arguments: " + args;
            }
        }).when(executor).execute(any(CommandLine.class), any(ExecuteResultHandler.class));

        when(output.getLinkedList()).thenReturn(list);

        PythonDetector pd = new PythonDetector(output, executor, psh, erh);
        Assert.assertTrue(pd.exist());
        Assert.assertTrue(pd.getVersion().equalsIgnoreCase("3.3.2"));
    }

    @Test(expected = RuntimeException.class)
    public void itMustThrowARuntimeExceptionWhenThereIsAnIOException() throws IOException {
        doThrow(new IOException()).when(executor).execute(any(CommandLine.class), any(ExecuteResultHandler.class));
        PythonDetector pd = new PythonDetector(output, executor, psh, erh);
        Assert.assertTrue(pd.exist());

    }
}
