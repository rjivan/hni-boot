package org.hni.data.domain;

import java.math.BigDecimal;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private Long userId;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar orderDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar readyDate;
    private Calendar pickupDate;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private Long createdBy;
    @ManyToOne
    @JoinColumn(name = "provider_location_id", referencedColumnName = "id")
    private ProviderLocation providerLocation;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();

    protected Order() {
    }

}
