package com.techmahindra.aia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 8/17/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SETTINGS")
public class Settings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "settingsId")
    private Integer settingsId;

    @Column(name =  "name", length = 32, nullable =  false)
    private String name;

    @Column(name =  "description", length = 255, nullable =  false)
    private String description;

    @Column(name =  "value", length = 255, nullable =  false)
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
