package com.example.demo2.Data.Cart;

import javax.persistence.*;

@Entity
@Table(name = "cartdetails")
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcartdetail;
    private int idcart;
    private long idpro;

    private int quantity;


    public int getIdcartdetail() {
        return idcartdetail;
    }

    public void setIdcartdetail(int idcartdetail) {
        this.idcartdetail = idcartdetail;
    }

    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }

    public long getIdpro() {
        return idpro;
    }

    public void setIdpro(long idpro) {
        this.idpro = idpro;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartDetails{" +
                "idcartdetail=" + idcartdetail +
                ", idcart=" + idcart +
                ", idpro=" + idpro +
                ", quantity=" + quantity +
                '}';
    }
}
