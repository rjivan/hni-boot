package org.hni.data.domain;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "organization_addresses", joinColumns = {@JoinColumn(name = "organization_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "address_id", referencedColumnName = "id")})
    protected Set<Address> addresses = new HashSet<>();
    private String name;
    private String phone;
    private String website;
    private String logo;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar created;
    private Long createdBy;

    protected Organization() {
    }

}
