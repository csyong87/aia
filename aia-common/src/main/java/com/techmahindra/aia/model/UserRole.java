package com.techmahindra.aia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER_ROLE")
public class UserRole implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9168450124238988577L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userroleid")
    private Integer userRoleId;

    @Column(name = "userinfoid", nullable = false)
    private Integer userInfoId;

    @ManyToOne
    @JoinColumn(name = "userinfoid", insertable = false, updatable = false)
    private UserInfo userInfo;

    @Column(name = "roleinfoid", nullable = false)
    private Integer roleInfoId;

    @ManyToOne
    @JoinColumn(name = "roleinfoid", insertable = false, updatable = false)
    private RoleInfo roleInfo;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 8, nullable = false)
    private Status status;

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

    public enum Status {
        ACTIVE, INACTIVE, DELETED
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(final Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(final Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(final UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getRoleInfoId() {
        return roleInfoId;
    }

    public void setRoleInfoId(final Integer roleInfoId) {
        this.roleInfoId = roleInfoId;
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(final RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
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
