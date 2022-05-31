package com.example.demo2.Data.Cart;

import com.example.demo2.Data.Product.Product;
import com.example.demo2.Data.Product.ProductReponsitpry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartDetailController {
    @Autowired private ProductReponsitpry Pro_repo;
    @Autowired private CartDetailService cartDetailService;
    @GetMapping("/products/addtocart/{id}")
    public String addToCart(@PathVariable("id") Long id, RedirectAttributes r, HttpSession httpSession){
        int cardid = (int) httpSession.getAttribute("cartid");
        if(cartDetailService.addCartDetail(id,cardid)){
            r.addFlashAttribute("mess", "you have successfully added!!!");
        } return "redirect:/showcart";
    }
    @GetMapping("/showcart")
    public String showCart(Model model, HttpSession httpSession, RedirectAttributes r){
        int cartid = (int) httpSession.getAttribute("cartid");
        int quality = 0;
        List<CartDetails> getCartDetailbbyID = cartDetailService.getCartDetail(cartid);
        model.addAttribute("getCartDetails", getCartDetailbbyID);
        List<Product> getProduct = new ArrayList<>();
        for(int i=0; i<getCartDetailbbyID.size();i++){
            Product p = Pro_repo.findById((getCartDetailbbyID.get(i).getIdpro())).get();


            getProduct.add(p);
        }
        for(int i=0;i<getCartDetailbbyID.size();i++){
            for(int j=0; j<getProduct.size();j++){
                if(getCartDetailbbyID.get(i).getIdpro()==getProduct.get(j).getIdpro()){
                    quality+=(getProduct.get(j).getPrice()*getCartDetailbbyID.get(i).getQuantity());
                }
            }
        }
        model.addAttribute("mess", quality);
        model.addAttribute("getProduct", getProduct);
        return "Cart_Detail";
    }
    @GetMapping("/cart/delete/{id}")
    public String DeletProCart(@PathVariable("id") int id,Model model, RedirectAttributes r,HttpSession httpSession){
        cartDetailService.deleteProDuctCard(id);
        r.addFlashAttribute("mess", "Delete Successfully!!!");
        return "redirect:/showcart";
    }
    @GetMapping("/cart/clear")
    public String clearCartDetail(Model model, RedirectAttributes r, HttpSession httpSession){
        int cartid =(int) httpSession.getAttribute("cartid");
        cartDetailService.clearAllCarDetail(cartid);
        r.addFlashAttribute("mess", "Clear Successfully!!!");
        return "redirect:/showcart";
    }
    @GetMapping("products/showpro/cart/addtocart/{id}")
    public String addToCart2(@PathVariable("id") Long id,HttpSession session,Model model) {

            return "redirect:/products/cart/addtocart/" + id;
    }
}


