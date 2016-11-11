package org.hni.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor
@Entity
public class ProviderLocationHour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    private String dow;
    private Long openHour;
    private Long closeHour;
    @ManyToOne
    @JoinColumn(name = "provider_location_id", referencedColumnName = "id")
    private ProviderLocation providerLocation;

    protected ProviderLocationHour() {
    }
}
