package com.example.demo2.Data.Cart;

import javax.persistence.*;

@Entity
@Table(name ="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idcart;
    @Column(length = 10,nullable = false)
    private int id;

    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "idcart=" + idcart +
                ", id=" + id +
                '}';
    }
}
