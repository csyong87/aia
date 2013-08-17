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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>
 * By default, a person assigned to a certain role has access to functions mapped to role through the
 * {@link RoleFunctionAccess} table. This table serves to remove certain functions from a particular user role
 * </p>
 * 
 * @author Christian
 * 
 */
@Entity
@Table(name = "FUNCTION_BLACK_LIST")
public class UserRoleFunctionBlackList implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7505123396534597290L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userrolefunctionblacklistid")
    private Integer userRoleFunctionBlackListId;

    @Column(name = "userroleid", nullable = false)
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "userroleid", insertable = false, updatable = false)
    private UserRole userRole;

    @Column(name = "rolefunctionaccessid", nullable = false)
    private Integer roleFunctionAccessId;

    @ManyToOne
    @JoinColumn(name = "rolefunctionaccessid", insertable = false, updatable = false)
    private RoleFunctionAccess roleFunctionAccess;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 16, nullable = false)
    private Status status;

    public enum Status {
        ACTIVE, DELETED
    }

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
     * @return the userRoleFunctionBlackListId
     */
    public Integer getUserRoleFunctionBlackListId() {
        return userRoleFunctionBlackListId;
    }

    /**
     * @param userRoleFunctionBlackListId
     *            the userRoleFunctionBlackListId to set
     */
    public void setUserRoleFunctionBlackListId(Integer userRoleFunctionBlackListId) {
        this.userRoleFunctionBlackListId = userRoleFunctionBlackListId;
    }

    /**
     * @return the userRoleId
     */
    public Integer getUserRoleId() {
        return userRoleId;
    }

    /**
     * @param userRoleId
     *            the userRoleId to set
     */
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * @return the userRole
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * @param userRole
     *            the userRole to set
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the roleFunctionAccessId
     */
    public Integer getRoleFunctionAccessId() {
        return roleFunctionAccessId;
    }

    /**
     * @param roleFunctionAccessId
     *            the roleFunctionAccessId to set
     */
    public void setRoleFunctionAccessId(Integer roleFunctionAccessId) {
        this.roleFunctionAccessId = roleFunctionAccessId;
    }

    /**
     * @return the roleFunctionAccess
     */
    public RoleFunctionAccess getRoleFunctionAccess() {
        return roleFunctionAccess;
    }

    /**
     * @param roleFunctionAccess
     *            the roleFunctionAccess to set
     */
    public void setRoleFunctionAccess(RoleFunctionAccess roleFunctionAccess) {
        this.roleFunctionAccess = roleFunctionAccess;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     *            the createdBy to set
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
     * @param updatedBy
     *            the updatedBy to set
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
     * @param dateCreated
     *            the dateCreated to set
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
     * @param dateUpdated
     *            the dateUpdated to set
     */
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

}
