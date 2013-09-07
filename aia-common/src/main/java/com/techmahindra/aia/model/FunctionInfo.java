package com.techmahindra.aia.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The entity class {@link FunctionInfo}
 */
@Entity
@Table(name = "FUNCTION_INFO")
public class FunctionInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7914526317470517609L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "functioninfoid")
    private Integer functionInfoId;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "url", length = 255, nullable = true)
    private String url;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "parentfunctioninfoid")
    private Integer parentFunctionInfoId;

    @ManyToOne
    @JoinColumn(name = "parentFunctionInfoId", insertable = false, updatable = false)
    private FunctionInfo functionInfo;

    @OneToMany(mappedBy = "functionInfo", fetch = FetchType.LAZY)
    private List<FunctionInfo> children;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @Column(name = "createdby", nullable = false)
    private String createdBy;

    @Column(name = "updatedby", nullable = true)
    private String updatedBy;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datecreated", nullable = false)
    private Date dateCreated;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateupdated", nullable = true)
    private Date dateUpdated;

    /**
     * @return the functionInfoId
     */
    public Integer getFunctionInfoId() {
        return functionInfoId;
    }

    /**
     * @param functionInfoId the functionInfoId to set
     */
    public void setFunctionInfoId(Integer functionInfoId) {
        this.functionInfoId = functionInfoId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the parentFunctionInfoId
     */
    public Integer getParentFunctionInfoId() {
        return parentFunctionInfoId;
    }

    /**
     * @param parentFunctionInfoId the parentFunctionInfoId to set
     */
    public void setParentFunctionInfoId(Integer parentFunctionInfoId) {
        this.parentFunctionInfoId = parentFunctionInfoId;
    }

    /**
     * @return the functionInfo
     */
    public FunctionInfo getFunctionInfo() {
        return functionInfo;
    }

    /**
     * @param functionInfo the functionInfo to set
     */
    public void setFunctionInfo(FunctionInfo functionInfo) {
        this.functionInfo = functionInfo;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the dateUpdated
     */
    public Date getDateUpdated() {
        return dateUpdated;
    }

    /**
     * @param dateUpdated the dateUpdated to set
     */
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return The sub functions
     */
    public List<FunctionInfo> getChildren() {
        return children;
    }

    /**
     * @param children The sub functions
     */
    public void setChildren(final List<FunctionInfo> children) {
        this.children = children;
    }
}
