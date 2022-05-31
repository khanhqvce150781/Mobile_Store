package com.example.demo2;

import com.example.demo2.Data.Cart.CartService;
import com.example.demo2.Data.User.User;
import com.example.demo2.Data.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired private UserService service;
    @Autowired private CartService cartService;


    @GetMapping("")
    public String showHomePage(Model model) {
       model.addAttribute("formuser", new User());
        return "index";
    }
    @PostMapping("/login")
    public String Login(String user_Name, String password, Model model, User user, HttpSession httpSession, RedirectAttributes r) {
        List<User> u = service.ListAllUsers();
        System.out.println(user_Name);
        System.out.println(password);
        String link="redirect:/";
        for(int i=0; i<u.size(); i++){
            if(u.get(i).getUser_Name().trim().toLowerCase().equals(user_Name.trim().toLowerCase()))
            {

                if(u.get(i).getPassword().trim().toLowerCase().equals(password.trim().toLowerCase())){
                    int cartid = cartService.getCardID(user.getId());
                    boolean type = u.get(i).getUser_role();
                    String usern = user.getUser_Name().toLowerCase().trim();
                    httpSession.setAttribute("username", usern);
                    httpSession.setAttribute("cartid", cartid);
                    httpSession.setAttribute("type", type);
                    if(u.get(i).getUser_role()){
                        link = "redirect:/products/showw";

                    } else {
                        link = "redirect:/products/showAllpro";

                    }
                } else{
                    r.addFlashAttribute("messfalse","Login false !!! Please try again");

                }
            } else {
                r.addFlashAttribute("messfalse","Login false !!! Please try again");
            }
        }
        return ""+link;
    }
    @GetMapping("/logout")
    public String logOut(HttpSession httpSession, RedirectAttributes r){
        httpSession.removeAttribute("username");
        httpSession.removeAttribute("cartid");
        httpSession.removeAttribute("tou");
        r.addFlashAttribute("mess", "Logout Successfully!!!");
        return "redirect:/";
    }
}
