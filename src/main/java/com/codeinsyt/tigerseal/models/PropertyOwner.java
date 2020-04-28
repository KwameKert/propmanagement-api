package com.codeinsyt.tigerseal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="app_property_owner")
public class PropertyOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "property_owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Property> properties;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="collector_id", nullable= false)
    @JsonIgnore
    private User collector;

    public PropertyOwner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
