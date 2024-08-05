package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "n_order")
public class NOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "expected_date")
    private Date expectedDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    private String comment;

//    @ManyToOne
//    @JoinColumn(name = "customer_code_or")
//    private Customer customerCodeOr;

    @ManyToOne
    @JoinColumn(name = "status_code_or")
    private Status statusCodeOr;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderIdProduct")
    private List<OrderDetail> orderDetails;

    public NOrder() {
    }

    public NOrder(String comment, Date deliveryDate, Date expectedDate, Date orderDate) {
        this.comment = comment;
        this.deliveryDate = deliveryDate;
        this.expectedDate = expectedDate;
        this.orderDate = orderDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Status getStatusCodeOr() {
        return statusCodeOr;
    }

    public void setStatusCodeOr(Status statusCodeOr) {
        this.statusCodeOr = statusCodeOr;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "NOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", expectedDate=" + expectedDate +
                ", deliveryDate=" + deliveryDate +
                ", comment='" + comment + '\'' +
                ", statusCodeOr=" + statusCodeOr +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
