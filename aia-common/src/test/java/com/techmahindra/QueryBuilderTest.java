package com.techmahindra;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class QueryBuilderTest {

    @Test
    public void testBuildQuery() {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);

    }
}
