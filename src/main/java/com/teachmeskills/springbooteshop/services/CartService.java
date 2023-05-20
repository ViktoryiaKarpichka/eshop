package com.teachmeskills.springbooteshop.services;

import static com.teachmeskills.springbooteshop.utils.Constant.CART_PAGE;

import com.teachmeskills.springbooteshop.entities.Cart;
import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Service
public class CartService {

    private final ProductRepository productRepository;

    public ModelAndView addProductToCart(int productId, Cart shopCart) {
        ModelMap modelParams = new ModelMap();
        Product product = productRepository.findById(productId);
        shopCart.addProduct(product);
        modelParams.addAttribute("product", product);
        modelParams.addAttribute("cart", shopCart);
        return new ModelAndView(CART_PAGE, modelParams);
    }

    public ModelAndView deleteProductFromCart(int productId, Cart shopCart) {
        Product product = productRepository.findById(productId);
        shopCart.deleteProduct(product);
        return new ModelAndView(CART_PAGE);
    }

}
