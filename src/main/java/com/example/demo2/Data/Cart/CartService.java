package com.example.demo2.Data.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
@Autowired private CartRepository repo;
public int getCardID(Integer id){
    List<Cart> listAllCart = (List<Cart>) repo.findAll();
    boolean checkCartId =false;
    int cartID=0;
    for (int i=0;i<listAllCart.size();i++){
        if(listAllCart.get(i).getId()==id){
            checkCartId =true;
            cartID=listAllCart.get(i).getIdcart();
            break;
        }
    }
    if(checkCartId){
        Cart newCart = new Cart();
        newCart.setId(id);
        repo.save(newCart);
        cartID= newCart.getIdcart();

    }
    return cartID;
}
}
