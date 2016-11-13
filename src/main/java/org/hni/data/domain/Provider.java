package org.hni.data.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor
@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    private String name;
    private Date created;
    private Long createdBy;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "provider_address", joinColumns = {@JoinColumn(name = "provider_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "address_id", referencedColumnName = "id")})
    private Set<Address> addresses = new HashSet<>();

    protected Provider() {
    }

}
