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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor
@Entity
public class ProviderLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private Date created;
    private Long createdBy;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "provider_location_addresses", joinColumns = {@JoinColumn(name = "provider_location_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "address_id", referencedColumnName = "id")})
    private Set<Address> addresses = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Provider provider;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "providerLocation", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<ProviderLocationHour> providerLocationHours = new HashSet<>();

}
