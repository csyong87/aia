package com.techmahindra.aia.model;

import javax.persistence.*;
import java.io.Serializable;

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


}
