package com.techmahindra.aia.query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * The {@link QueryBuilder} class is an utility class used to construct hibernate based queries.
 *
 * @author Christian
 */
@Component("queryBuilder")
public class QueryBuilderImpl implements QueryBuilder {

    private static final Log logger = LogFactory.getLog(QueryBuilderImpl.class);

    private Properties queryProperties;

    public QueryBuilderImpl() {
        try {
            queryProperties = new Properties();
            queryProperties.load(QueryBuilderImpl.class.getResourceAsStream("/QueryBuilder.properties"));
            queryProperties.load(QueryBuilderImpl.class.getResourceAsStream("/NativeQueryBuilder.properties"));
        } catch (IOException ioe) {
            throw new RuntimeException("Unable to load QueryBuilder.properties", ioe);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key
     * @param params
     * @return
     */
    public Query buildQuery(SessionFactory sessionFactory, String key, Map<String, Object> params,
                            PageableListParameters plp) {
        Assert.notNull("Parameter key cannot be null", key);

        String queryString = queryProperties.getProperty(key);
        if (queryString == null) {
            throw new NullPointerException("Unable to find query for: " + key);
        }

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(queryString);
        if (params != null) {
            for (Entry<String, Object> entrySet : params.entrySet()) {
                query.setParameter(entrySet.getKey(), entrySet.getValue());
            }
        }

        if (plp != null) {
            query.setFirstResult((plp.getPageNo() - 1) * plp.getRecordsPerPage());
            query.setFetchSize(plp.getRecordsPerPage());
        }

        return query;
    }

    /**
     * {@inheritDoc}
     */
    public Query buildQuery(SessionFactory sessionFactory, String key) {
        return buildQuery(sessionFactory, key, null, null);
    }

    /**
     * {@inheritDoc}
     */
    public Query buildQuery(SessionFactory sessionFactory, String key, Map<String, Object> params) {
        return buildQuery(sessionFactory, key, params, null);
    }

    /**
     * Creates a hibernate query based on the hql referred to by the {@code key} and a dynamic criteria.
     *
     * @param sessionFactory The hibernate {@link SessionFactory}
     * @param key            The query key
     * @param queryFilter    The dynamic query filter
     * @param paramMap       The parameter
     * @return
     */
    public Query buildDynamicQuery(SessionFactory sessionFactory, String key, QueryFilterObject queryFilter,
                                   Map<String, Object> paramMap) {
        Query query = buildDynamicQuery(sessionFactory, key, queryFilter);
        if (paramMap != null) {
            for (Entry<String, Object> entry : paramMap.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query;
    }

    /**
     * {@inheritDoc}
     */
    public Query buildDynamicQuery(SessionFactory sessionFactory, String key, QueryFilterObject dynamicQueryBuilder) {
        boolean debugEnabled = logger.isDebugEnabled();

        Assert.notNull("Parameter key cannot be null", key);

        if (debugEnabled) {
            logger.trace(String.format("Retrieving query for: %s", key));
        }

        String queryString = queryProperties.getProperty(key);

        if (debugEnabled) {
            logger.trace(String.format("Query key: %s; Hql: %s", key, queryString));
        }

        if (queryString == null) {
            throw new NullPointerException("Unable to find query for: " + key);
        }

        if (dynamicQueryBuilder != null) {
            String whereClause = dynamicQueryBuilder.buildQuery();
            if (debugEnabled) {
                logger.trace(String.format("Appending WhereClause: %s", whereClause));
            }

            if (whereClause != null && whereClause.length() > 0) {
                if (queryString.toUpperCase().contains("WHERE")) {
                    queryString += " " + dynamicQueryBuilder.getQueryConnector().toString() + " " + whereClause;
                } else {
                    queryString += " WHERE " + whereClause;
                }
            }

            // append only order by clause when not counting
            if (!key.contains(".count")) {
                String groupBy = dynamicQueryBuilder.getGroupBy();
                if (groupBy != null && groupBy.length() > 0) {
                    queryString += " " + groupBy;
                }

                String orderBy = dynamicQueryBuilder.getOrderBy();
                if (orderBy != null && orderBy.length() > 0) {
                    queryString += " " + orderBy;
                }
            }
        }

        Session session = sessionFactory.getCurrentSession();
        if (debugEnabled) {
            logger.debug(String.format("Creating query for %s", queryString));
        }

        Query query = session.createQuery(queryString);
        if (dynamicQueryBuilder != null && dynamicQueryBuilder.getParamValues() != null) {
            for (Entry<String, Object> entrySet : dynamicQueryBuilder.getParamValues().entrySet()) {
                if (debugEnabled) {
                    logger.debug(String.format("Setting query param: %s", entrySet.getValue()));
                }
                query.setParameter(entrySet.getKey(), entrySet.getValue());
            }
        }

        return query;
    }

    public SQLQuery buildDynamicNativeQuery(SessionFactory sessionFactory, String key, String whereClause,
                                            Map<String, Object> params) {
        Assert.notNull("Parameter key cannot be null", key);

        String queryString = queryProperties.getProperty(key);
        if (queryString == null) {
            throw new NullPointerException("Unable to find query for: " + key);
        }

        if (whereClause != null && whereClause.length() > 0) {
            queryString += " " + whereClause;
        }

        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery(queryString);
        if (params != null) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sqlQuery.setParameter(entry.getKey(), entry.getValue());
            }
        }

        return sqlQuery;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SQLQuery buildNativeQuery(SessionFactory sessionFactory, String key, Map<String, Object> params) {
        return buildDynamicNativeQuery(sessionFactory, key, null, params);
    }

    /*
     * (non-Javadoc)
     * 
     * @see sg.gov.lta.bpms.util.query.QueryBuilder#applyFilter(org.hibernate. SessionFactory, java.util.List,
     * sg.gov.lta.bpms.util.query.QueryFilterObject, java.util.Map)
     */
    @Override
    public Query applyFilter(SessionFactory sessionFactory, List<?> collection, QueryFilterObject queryFilterObject,
                             Map<String, Object> parameterMap) {
        Session session = sessionFactory.getCurrentSession();

        String queryFilter = queryFilterObject.buildQuery();
        if (queryFilter.length() > 0) {
            queryFilter = "where " + queryFilter;
        }
        if (logger.isDebugEnabled()) {
            logger.debug(String.format("Applying query filter: %s", queryFilter));
        }

        Query query = session.createFilter(collection, queryFilter);

        if (parameterMap != null) {
            for (Entry<String, Object> map : parameterMap.entrySet()) {
                query.setParameter(map.getKey(), map.getValue());
            }
        }
        return query;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sg.gov.lta.bpms.util.query.QueryBuilder#createCriteria(org.hibernate. SessionFactory, java.lang.Class)
     */
    @Override
    public Criteria createCriteria(SessionFactory sessionFactory, Class<?> clazz) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(clazz);
    }
}
