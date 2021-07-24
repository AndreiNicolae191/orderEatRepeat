package com.app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private short price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Orders> order;

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

    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }

    public List<Orders> getOrder() {
        return order;
    }

    public void setOrder(List<Orders> order) {
        this.order = order;
    }

    public Products(String name, short price, List<Orders> order) {
        this.name = name;
        this.price = price;
        this.order = order;
    }

    public Products() {
    }
}
