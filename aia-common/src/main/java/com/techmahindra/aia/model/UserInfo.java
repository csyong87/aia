package com.techmahindra.aia.model;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jasypt.hibernate4.type.EncryptedStringType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * An entity that represents an instance of an AIA User
 * <p/>
 */
@Entity
@Table(name = "USER_INFO")
@TypeDefs({@TypeDef(name = "encryptedString", typeClass = EncryptedStringType.class,
        parameters = {@Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor")})})
public class UserInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6368253182251170568L;
    /**
     * The entity's unique identifier
     * <p/>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userinfoid")
    private Integer userInfoId;
    /**
     * The user's login id
     */
    @Column(name = "loginid", length = 24, nullable = false)
    private String loginId;
    @Column(name = "domain", length = 16, nullable = true)
    private String domain;
    @Column(name = "username", length = 32, nullable = false)
    private String username;
    @Column(name = "mobilenumber", length = 16, nullable = false)
    private String mobileNumber;
    /**
     * User's login password.
     */
    @Column(name = "password", length = 500, nullable = false)
    private String password;
    @Column(name = "email", length = 128, nullable = false)
    private String email;
    @Type(type = "encryptedString")
    @Column(name = "emailpassword", length = 255, nullable = false)
    private String emailPassword;

    /**
     * To avoid the outlook account from being locked. AIA will try to connect to the exchange server only once. If
     * unsuccessful, this field will be set to false until manually triggered to connect by the account's owner
     */
    @Basic
    @Column(name = "isemailvalid", length = 1, nullable = false)
    private Boolean isEmailValid;
    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 16, nullable = false)
    private Status status;
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
     * @return the userInfoId
     */
    public Integer getUserInfoId() {
        return userInfoId;
    }

    /**
     * @param userInfoId the userInfoId to set
     */
    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain the domain to set
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the emailPassword
     */
    public String getEmailPassword() {
        return emailPassword;
    }

    /**
     * @param emailPassword the emailPassword to set
     */
    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
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

    public enum Status {
        ACTIVE, INACTIVE, DELETED, PENDING_APPROVAL
    }

}
