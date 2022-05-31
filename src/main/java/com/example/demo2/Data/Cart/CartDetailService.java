package com.example.demo2.Data.Cart;

import com.example.demo2.Data.Product.Product;
import com.example.demo2.Data.Product.ProductReponsitpry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartDetailService {
@Autowired private CartDetailRepository cartDetailRepository;
@Autowired private ProductReponsitpry productReponsitpry;
public boolean addCartDetail(long proid, int cartid){
    List<CartDetails> listAllCartDetail = (List<CartDetails>) cartDetailRepository.findAll();
    List<CartDetails> userCartDetail = new ArrayList<>();
    Product p = productReponsitpry.findById(proid).get();
    boolean check= false;
    for (int i=0; i<listAllCartDetail.size();i++){
        if(listAllCartDetail.get(i).getIdcart()==cartid){
            userCartDetail.add(listAllCartDetail.get(i));
        }
    }
    if (userCartDetail.size()==0 && p.getStock()!=0){
        CartDetails cartDetails = new CartDetails();
        cartDetails.setIdpro(proid);
        cartDetails.setIdcart(cartid);
        cartDetails.setQuantity(1);
        p.setStock((p.getStock()-1));
        cartDetailRepository.save(cartDetails);
        productReponsitpry.save(p);

    } else {
        for(int i=0; i<userCartDetail.size();i++){
            if(userCartDetail.get(i).getIdpro()==proid&&p.getStock()!=0){
                userCartDetail.get(i).setQuantity(userCartDetail.get(i).getQuantity()+1);
                cartDetailRepository.save(userCartDetail.get(i));
                p.setStock(p.getStock()-1);
                productReponsitpry.save(p);
                check=true;
                break;
            }
        }
        if(check==false&&p.getStock()!=0){
            CartDetails cartDetails = new CartDetails();
            cartDetails.setIdpro(proid);
            cartDetails.setIdcart(cartid);
            cartDetails.setQuantity(1);
            cartDetailRepository.save(cartDetails);
            p.setStock(p.getStock()-1);
            productReponsitpry.save(p);
            check =true;

        }
    } return check;


}
public List<CartDetails> getCartDetail(int cardit){
    List<CartDetails> cartDetails = new ArrayList<>();
    List<CartDetails> getAllCartDetail = (List<CartDetails>) cartDetailRepository.findAll();
    for(int i=0; i<getAllCartDetail.size();i++){
        if (getAllCartDetail.get(i).getIdcart()==cardit){
            cartDetails.add((getAllCartDetail.get(i)));
        }
    } return cartDetails;
}
public void deleteProDuctCard(int cartDetailID){
    cartDetailRepository.deleteById(cartDetailID);
}
public void clearAllCarDetail(int carid){
    List<CartDetails>getAllCartDetail = (List<CartDetails>) cartDetailRepository.findAll();
    for (int i=0;i<getAllCartDetail.size();i++){
        if(getAllCartDetail.get(i).getIdcart()==carid){
            cartDetailRepository.deleteById((getAllCartDetail.get(i).getIdcartdetail()));
        }
    }
}
}
