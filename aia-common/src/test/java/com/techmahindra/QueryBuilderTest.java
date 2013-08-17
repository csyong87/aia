package com.techmahindra;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QueryBuilderTest {

    private static final String SAMPLE_QUERY_1 = "select u from UserInfo u";

    private SessionFactory sessionFactory;

    @Before
    public void init() {
        sessionFactory = mock(SessionFactory.class);
    }

    @Test
    public void testBuildQuery() {
        Session session = mock(Session.class);
        Query query = mock(Query.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery(SAMPLE_QUERY_1)).thenReturn(query);
    }
}
