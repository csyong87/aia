package com.techmahindra.aia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "INSTANT_ACTION")
public class InstantAction implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1093623141233479914L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instantactionid")
    private Integer instantActionId;

    /**
     * A SHA-256 token used to uniquely identify each individual instant action.
     */
    @Column(name = "token", length = 500, nullable = false)
    private String token;

    /**
     * <p>
     * An arbitrary field which has to be set by the client to identify the action to be performed.
     * </p>
     * 
     */
    @Column(name = "action", length = 128, nullable = false)
    private String action;

    /**
     * <p>
     * The fully qualified name of the class
     * </p>
     */
    @Column(name = "action", length = 255, nullable = false)
    private String executingClass;

    /**
     * <p>
     * A short description of what this instant action is about.
     * </p>
     * <p>
     * This is a required field
     * </p>
     */
    @Column(name = "description", length = 255, nullable = false)
    private String description;

    /**
     * <p>
     * The email address of the person performing the action
     * </p>
     * <p>
     * This is a required field
     * </p>
     */
    @Column(name = "requestoremailaddress", length = 128, nullable = false)
    private String requestorEmailAddress;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10, nullable = false)
    private Status status = Status.ACTIVE;

    public enum Status {
        ACTIVE, INACTIVE, DELETED, COMPLETED
    }

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

    public Integer getInstantActionId() {
        return instantActionId;
    }

    public void setInstantActionId(final Integer instantActionId) {
        this.instantActionId = instantActionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public String getExecutingClass() {
        return executingClass;
    }

    public void setExecutingClass(final String executingClass) {
        this.executingClass = executingClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getRequestorEmailAddress() {
        return requestorEmailAddress;
    }

    public void setRequestorEmailAddress(final String requestorEmailAddress) {
        this.requestorEmailAddress = requestorEmailAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
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
