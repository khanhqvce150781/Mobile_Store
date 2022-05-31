package com.example.demo2.Data.Product;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.example.demo2.Data.Product.ProductService;
import org.hibernate.boot.model.relational.QualifiedNameParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.server.PathParam;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@Controller
public class ProductController {
    @Autowired private ProductService service;

    @GetMapping("/products/showw")
    public String showFormProduct(Model model, Product product){
        model.addAttribute("product", new Product());
        return "Product_add";

    }
    @PostMapping("/products/add")
    public String addNewProduct(Model model, Product product, @RequestParam("Pictures") MultipartFile multipartFile, RedirectAttributes r) throws IOException {
         try{
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        product.setPicture(fileName);
        service.save(product);
        String uploadDir = "./src/main/resources/static";
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }} catch (Exception e){
             r.addFlashAttribute("messF", "Save Fail!!!");
             return "redirect:/products/showw";
         }
        r.addFlashAttribute("mess", "Save Successfully!!!");
        return "redirect:/products/showw";
    }
@GetMapping("/products/showAllpro")
    public String showProduct(Model model, HttpSession httpSession){
    List<Product> listProducts = service.listAllProduct();
    model.addAttribute("listAllProducts", listProducts);
    return "Product_list";
}
@GetMapping("/products/showpro/{id}")
        public String showDetails(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
    try {
        Product product = service.get(id);
        model.addAttribute("productsDetail", product);
        return "Product_detail";
    } catch (ProductNotFoundException e) {
        ra.addFlashAttribute("message", "The product has been not fond");
        return "redirect:/products/showw";
    }
}
}







