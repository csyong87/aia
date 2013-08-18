package com.techmahindra.aia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * 
 * @author Christian
 * 
 */
@Entity
@Table(name = "SETTINGS")
public class Settings implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7850796082009891375L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "settingsId")
    private Integer settingsId;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "value", length = 255, nullable = false)
    private String value;

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

    public Integer getSettingsId() {
        return settingsId;
    }

    public void setSettingsId(final Integer settingsId) {
        this.settingsId = settingsId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(final Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
