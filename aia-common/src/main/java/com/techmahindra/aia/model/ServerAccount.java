package com.techmahindra.aia.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ServerAccount implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8227154732712526519L;

    private Integer serverAccountId;

    private Integer serverId;

    private String username;

    private String password;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_TYPE")
    private ServerAccountType accountType;

    public enum ServerAccountType {
        SSH_FTP, SSH, FTP, WEB_LOGIN, WINDOWS_RDC
    }
}
