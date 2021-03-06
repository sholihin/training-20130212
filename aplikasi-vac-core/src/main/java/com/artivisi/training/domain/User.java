/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author endy
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotNull
    @NotEmpty
    @Size(min=4, max=20)
    @Column(nullable=false, unique=true)
    private String username;
    
    @NotNull
    @NotEmpty
    @Size(min=8, max=255)
    @Column(nullable=false)
    private String password;
    
    @ElementCollection
    @CollectionTable(
            name="t_user_email", 
            joinColumns=@JoinColumn(name="id_user", nullable=false)
    )
    @Column(name="email", nullable=false)
    private List<String> daftarEmail 
            = new ArrayList<String>();
    
    @ElementCollection
    @CollectionTable(
            name="t_user_phone", 
            joinColumns=@JoinColumn(name="id_user", nullable=false)
    )
    private List<Phone> daftarTelepon 
            = new ArrayList<Phone>();
    
    @ManyToOne
    @JoinColumn(name="id_role", nullable=false)
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<String> getDaftarEmail() {
        return daftarEmail;
    }

    public void setDaftarEmail(List<String> daftarEmail) {
        this.daftarEmail = daftarEmail;
    }

    public List<Phone> getDaftarTelepon() {
        return daftarTelepon;
    }

    public void setDaftarTelepon(List<Phone> daftarTelepon) {
        this.daftarTelepon = daftarTelepon;
    }
    
    
}
