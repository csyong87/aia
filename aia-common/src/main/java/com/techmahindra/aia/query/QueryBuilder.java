package com.techmahindra.aia.query;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

/**
 * The {@link QueryBuilder} interface class encapsulates the {@link Query} creation
 * 
 * @author Christian
 * 
 */
public interface QueryBuilder {

    /**
     * Creates a query object
     * 
     * @param sessionFactory
     * @param key
     * @param params
     * @return
     */
    Query buildQuery(SessionFactory sessionFactory, String key, Map<String, Object> params, PageableListParameters plp);

    /**
     * Creates a query object
     * 
     * @param key
     * @return
     */
    Query buildQuery(SessionFactory sessionFactory, String key);

    /**
     * Creates a query object
     * 
     * @param sessionFactory
     * @param key
     * @param params
     * @return
     */
    Query buildQuery(SessionFactory sessionFactory, String key, Map<String, Object> params);

    /**
     * Creates a hibernate {@link Query} where the query condition could not be determined until runtime
     * 
     * @param sessionFactory
     * @param key
     *            The key to the base query
     * @param queryFilterObject
     *            The dynamic query condition
     * @return
     */
    Query buildDynamicQuery(SessionFactory sessionFactory, String key, QueryFilterObject queryFilterObject);

    /**
     * Builds a dynamic query where a part of the query condition could not be determined until runtime
     * 
     * @param sessionFactory
     * @param key
     * @param dynamicQueryBuilder
     * @param paramMap
     * @return
     */
    Query buildDynamicQuery(SessionFactory sessionFactory, String key, QueryFilterObject dynamicQueryBuilder,
            Map<String, Object> paramMap);

    /**
     * Creates a native query where the condition clause can only be determined during runtime
     * 
     * @param sessionFactory
     * @param key
     * @param whereClause
     * @param params
     * @return
     */
    SQLQuery buildDynamicNativeQuery(SessionFactory sessionFactory, String key, String whereClause,
            Map<String, Object> params);

    /**
     * Creates a native query where the condition clause is known
     * 
     * @param sessionFactory
     * @param key
     * @param params
     * @return
     */
    SQLQuery buildNativeQuery(SessionFactory sessionFactory, String key, Map<String, Object> params);

    /**
     * Applies a filter to the <code>collection</code>
     * 
     * @param sessionFactory
     *            The hibernate {@link SessionFactory} object
     * @param collection
     *            The collection of records to apply filter to
     * @param queryFilterObject
     *            The filter builder object
     * @param parameterMap
     *            The parameter map containing the filter values
     * 
     * @return A {@link Query} object ready for execution
     */
    Query applyFilter(SessionFactory sessionFactory, List<?> collection, QueryFilterObject queryFilterObject,
            Map<String, Object> parameterMap);

    /**
     * Creates a basic {@link Criteria} based on the parameter <code>clazz</code>
     * <p>
     * The same as: <br/>
     * <code>
     * Session session = sessionFactory.getCurrentSession(); <br/>
     * Criteria criteria = session.createCriteria(clazz);
     * </code>
     * 
     * @param sessionFactory
     * @param clazz
     * @return
     */
    Criteria createCriteria(SessionFactory sessionFactory, Class<?> clazz);
}
