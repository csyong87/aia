package com.techmahindra.aia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 8/17/13
 * Time: 8:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MAILING_LIST")
public class MailingList implements Serializable {

    /**
     * The primary key field
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mailinglistid")
    private Integer mailingListId;

    /**
     * The mailing list name
     */
    @Column(name = "name", length = 32, nullable = false)
    private String name;

    /**
     * The mailing list description
     */
    @Column(name = "description", length = 255, nullable = false)
    private String description;

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
     * @return the mailingListId
     */
    public Integer getMailingListId() {
        return mailingListId;
    }

    /**
     * @param mailingListId the mailingListId to set
     */
    public void setMailingListId(Integer mailingListId) {
        this.mailingListId = mailingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
