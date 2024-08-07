package com.ecommerce.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "sale_price")
    private Integer salePrice;

//    @Column(name = "supplier_price")
//    private Integer supplierPrice;

    @Column(name = "product_description")
    private String productDescription;

    private String dimensions;

//    Llaves foraneas

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "range_code")
//    @JsonBackReference
    private ProductRange rangeCode;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productIdOrder")
//    private List<ProductRange> productRanges;

    public Product() {
    }

    public Product(String name, Integer stockQuantity, Integer salePrice, String productDescription, String dimensions) {
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.salePrice = salePrice;
//        this.supplierPrice = supplierPrice;
        this.productDescription = productDescription;
        this.dimensions = dimensions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

//    public Integer getSupplierPrice() {
//        return supplierPrice;
//    }
//
//    public void setSupplierPrice(Integer supplierPrice) {
//        this.supplierPrice = supplierPrice;
//    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public ProductRange getRangeCode() {
        return rangeCode;
    }

    public void setRangeCode(ProductRange rangeCode) {
        this.rangeCode = rangeCode;
    }


//    public List<ProductRange> getProductRanges() {
//        return productRanges;
//    }
//
//    public void setProductRanges(List<ProductRange> productRanges) {
//        this.productRanges = productRanges;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", salePrice=" + salePrice +
//                ", supplierPrice=" + supplierPrice +
                ", productDescription='" + productDescription + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", rangeCode=" + rangeCode +
//                ", productRanges=" + productRanges +
                '}';
    }
}
