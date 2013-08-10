package com.techmahindra.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * The {@link QueryFilterObject} class is used to generate the dynamic condition clause for a given base query
 * </p>
 * Usage:
 * <p>
 * 
 * <tt>
 * QueryFilterObject qfo = new QueryFilterObject(); <br/>
 * qfo.equal("p.name", "foo");<br/>
 * qfo.equal("p.lastname", "bar");<br/>
 * <br/>
 * Person person = userInfoDao.getPerson(qfo);<br/>
 * 
 * </tt> <br/>
 * If the base query is <tt>SELECT p FROM Person p</tt>, the statement above will be equivalent to
 * <tt>SELECT p FROM Person p WHERE p.username = 'foo' AND p.lastname = 'bar'</tt>
 * </p>
 * 
 * @author Christian
 * 
 */
public class QueryFilterObject {

    public static final String RIGHT_PAREN = ")";
    public static final String LEFT_PAREN = "(";
    public static final String SPACE = " ";
    public static final String SINGLE_QOUTE = "'";
    public static final String WILDCARD_CHAR = "%";
    public static final String COMMA = ",";
    private QueryConnector queryConnector = QueryConnector.AND;

    private int paramCount = 0;
    private String orderBy;
    private String groupBy;
    private Map<String, Object> paramValues = new HashMap<String, Object>();

    private enum QueryOperator {
        EQUALS("="), LESS_THAN("<"), GREATER_THAN(">"), LESS_THAN_EQUALS("<="), GREATER_THAN_EQUALS(">="), NOT_EQUAL(
                "<>"), IN("IN"), NOT_IN("NOT IN"), LIKE("LIKE"), BETWEEN("BETWEEN");

        private String symbol;

        QueryOperator(String symbol) {
            this.symbol = symbol;
        }

        public String toString() {
            return this.symbol;
        }
    }

    public enum QueryConnector {

        AND("AND"), OR("OR");

        private String connector;

        QueryConnector(String connector) {
            this.connector = connector;
        }

        public String toString() {
            return this.connector;
        }
    }

    private StringBuffer query;

    public QueryFilterObject() {
        query = new StringBuffer();
    }

    public void lessThan(String fieldName, Object value) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        String paramKey = "param_" + paramCount++;

        query.append(fieldName).append(SPACE).append(QueryOperator.LESS_THAN.toString()).append(SPACE)
                .append(":" + paramKey);

        paramValues.put(paramKey, value);
    }

    public void lessThanEqual(String fieldName, Object value) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        String paramKey = "param_" + paramCount++;

        query.append(fieldName).append(SPACE).append(QueryOperator.LESS_THAN_EQUALS.toString()).append(SPACE)
                .append(":" + paramKey);

        paramValues.put(paramKey, value);
    }

    /**
     * Creates an HQL 'IN' condition
     * 
     * @param fieldName
     * @param objList
     */
    public void in(String fieldName, List<?> objList) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        query.append(fieldName).append(SPACE).append(QueryOperator.IN.toString()).append(SPACE).append(LEFT_PAREN);

        for (int i = 0; i < objList.size(); i++) {
            Object obj = objList.get(i);
            String val = "";
            if (!(obj instanceof String)) {
                val = obj.toString();
            } else {
                val = (String) obj;

            }

            query.append(SINGLE_QOUTE).append(val).append(SINGLE_QOUTE);

            if (i < objList.size() - 1) {
                query.append(COMMA);
            }

        }

        query.append(RIGHT_PAREN);
    }

    /**
     * Creates an HQL 'NOT IN' condition
     * 
     * @param fieldName
     * @param objList
     */
    public void notIn(String fieldName, List<?> objList) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        query.append(fieldName).append(SPACE).append(QueryOperator.NOT_IN.toString()).append(SPACE).append(LEFT_PAREN);

        for (int i = 0; i < objList.size(); i++) {
            Object obj = objList.get(i);
            String val = "";
            if (!(obj instanceof String)) {
                val = obj.toString();
            } else {
                val = (String) obj;
            }
            query.append(SINGLE_QOUTE).append(val).append(SINGLE_QOUTE);

            if (i < objList.size() - 1) {
                query.append(COMMA);
            }

        }

        query.append(RIGHT_PAREN);
    }

    public void equal(String fieldName, Object value) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        String paramKey = "param_" + paramCount++;

        query.append(fieldName).append(SPACE).append(QueryOperator.EQUALS.toString()).append(SPACE)
                .append(":" + paramKey);

        paramValues.put(paramKey, value);
    }

    public void notEqual(String fieldName, Object value) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        String paramKey = "param_" + paramCount++;

        query.append(fieldName).append(SPACE).append(QueryOperator.NOT_EQUAL.toString()).append(SPACE)
                .append(":" + paramKey);

        paramValues.put(paramKey, value);
    }

    public void like(String fieldName, Object value) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        String paramKey = "param_" + paramCount++;

        query.append(fieldName).append(SPACE).append(QueryOperator.LIKE.toString()).append(SPACE)
                .append(":" + paramKey);

        paramValues.put(paramKey, "%" + value + "%");
    }

    public void greaterThanEqual(String fieldName, Object value) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        String paramKey = "param_" + paramCount++;

        query.append(fieldName).append(SPACE).append(QueryOperator.GREATER_THAN_EQUALS.toString()).append(SPACE)
                .append(":" + paramKey);

        paramValues.put(paramKey, value);
    }

    public void greaterThan(String fieldName, Object value) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        String paramKey = "param_" + paramCount++;

        query.append(fieldName).append(SPACE).append(QueryOperator.GREATER_THAN.toString()).append(SPACE)
                .append(":" + paramKey);

        paramValues.put(paramKey, value);
    }

    /**
     * Creates a 'Between' condition. e.g. field BETWEEN (<tt>from</tt> AND <tt>to</tt>)
     * 
     * @param fieldName
     *            The name of the entity field
     * @param from
     *            The lower limit inclusive
     * @param to
     *            The upper limit inclusive
     */
    public void between(String fieldName, Object from, Object to) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        String paramKey1 = "param_" + paramCount++;
        String paramKey2 = "param_" + paramCount++;

        query.append(fieldName).append(SPACE).append(QueryOperator.BETWEEN.toString()).append(SPACE)
                .append(":" + paramKey1).append(SPACE).append(QueryConnector.AND.toString()).append(SPACE)
                .append(":" + paramKey2);

        paramValues.put(paramKey1, from);
        paramValues.put(paramKey2, to);
    }

    public void isNotNull(String fieldName) {
        if (query.length() > 0) {
            query.append(SPACE).append(queryConnector.toString()).append(SPACE);
        }

        query.append(fieldName).append(SPACE).append("IS NOT NULL");
    }

    public String buildQuery() {
        return query.toString();
    }

    /**
     * @return the queryConnector
     */
    public QueryConnector getQueryConnector() {
        return queryConnector;
    }

    /**
     * @param queryConnector
     *            the queryConnector to set
     */
    public void setQueryConnector(QueryConnector queryConnector) {
        this.queryConnector = queryConnector;
    }

    /**
     * @return the orderBy
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * @param orderBy
     *            the orderBy to set
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * @return the groupBy
     */
    public String getGroupBy() {
        return groupBy;
    }

    /**
     * @param groupBy
     *            the groupBy to set
     */
    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    /**
     * @return the paramValues
     */
    public Map<String, Object> getParamValues() {
        return paramValues;
    }

}
