package com.techmahindra.aia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * A Table Mapping which function a particular role can access
 * </p>
 *
 * @author Christian
 */
@Entity
@Table(name = "ROLE_FUNCTION_ACCESS")
public class RoleFunctionAccess implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2717469881243132592L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rolefunctionaccessid")
    private Integer roleFunctionAccessId;

    @Column(name = "roleinfoid", nullable = false)
    private Integer roleInfoId;

    @ManyToOne
    @JoinColumn(name = "roleinfoid", insertable = false, updatable = false)
    private RoleInfo roleInfo;

    @Column(name = "functioninfoid")
    private Integer functionInfoId;

    @ManyToOne
    @JoinColumn(name = "functioninfoid", insertable = false, updatable = false)
    private FunctionInfo functionInfo;

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

    public Integer getRoleFunctionAccessId() {
        return roleFunctionAccessId;
    }

    public void setRoleFunctionAccessId(final Integer roleFunctionAccessId) {
        this.roleFunctionAccessId = roleFunctionAccessId;
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

    public Integer getFunctionInfoId() {
        return functionInfoId;
    }

    public void setFunctionInfoId(final Integer functionInfoId) {
        this.functionInfoId = functionInfoId;
    }

    public FunctionInfo getFunctionInfo() {
        return functionInfo;
    }

    public void setFunctionInfo(final FunctionInfo functionInfo) {
        this.functionInfo = functionInfo;
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

    public enum Status {
        ACTIVE, DELETED
    }
}
