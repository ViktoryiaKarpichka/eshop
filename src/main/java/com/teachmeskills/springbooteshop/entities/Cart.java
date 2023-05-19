package com.teachmeskills.springbooteshop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Cart implements Serializable {

    private List<Product> products = new ArrayList<>();
    private int totalPrice = 0;
  /*  private Map<Integer, Product> products;
    public Cart() {
        this.products = new HashMap<>();
    }*/

    public void addProduct(Product myProduct) {
        products.add(myProduct);
       /* products.put(product.getId(), product);
        totalPrice += product.getPrice();*/
    }

    public void deleteProduct(Product myProduct) {
        products.remove(myProduct);
        /*Product product = products.get(productId);
        products.remove(productId);
        totalPrice -= product.getPrice();*/
    }
   /* public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }*/

    public void clear() {
        products.clear();
    }
}
