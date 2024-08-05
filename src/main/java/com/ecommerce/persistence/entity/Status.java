package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_name")
    private String statusName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusCodeOr")
    private List<NOrder> nOrders;

    public Status() {
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<NOrder> getnOrders() {
        return nOrders;
    }

    public void setnOrders(List<NOrder> nOrders) {
        this.nOrders = nOrders;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                ", nOrders=" + nOrders +
                '}';
    }
}
