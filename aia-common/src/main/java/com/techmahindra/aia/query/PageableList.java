package com.techmahindra.aia.query;

import java.util.List;

/**
 * A container for paged objects
 * 
 * @author Christian
 * 
 * @param <T>
 *            The type of object in the list
 */
public class PageableList<T> {

    /**
     * The number of records per page
     */
    private Integer recordsPerPage;

    /**
     * The total number of records that matches the query criteria
     */
    private Integer recordCount;

    /**
     * The paginated list
     */
    private List<T> resultList;

    /**
     * @return the resultList
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * @param resultList
     *            the resultList to set
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    /**
     * @return the recordsPerPage
     */
    public Integer getRecordsPerPage() {
        return recordsPerPage;
    }

    /**
     * @param recordsPerPage
     *            the recordsPerPage to set
     */
    public void setRecordsPerPage(Integer recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    /**
     * @return the recordCount
     */
    public Integer getRecordCount() {
        return recordCount;
    }

    /**
     * @param recordCount
     *            the recordCount to set
     */
    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

}
