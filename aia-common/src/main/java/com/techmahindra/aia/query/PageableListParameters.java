package com.techmahindra.aia.query;

/**
 * 
 * @author Christian
 * 
 */
public class PageableListParameters {

    private Integer pageNo;
    private Integer rowIndex;

    private Integer recordsPerPage;

    /**
     * @return the pageNo
     */
    @Deprecated
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo
     *            the pageNo to set
     */
    @Deprecated
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
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
     * @return the current row index
     */
    public Integer getRowIndex() {
        return rowIndex;
    }

    /**
     * @param rowIndex
     *            set the current row index
     */
    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }
}
