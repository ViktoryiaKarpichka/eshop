package com.teachmeskills.springbooteshop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Cart implements Serializable {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product productId) {
        products.add(productId);
    }

    public void deleteProduct(Product productId) {
         products.remove(productId);
      /*  Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()) {
            Product next = iterator.next();
            if (next.getId()==productId.getId()){
                iterator.remove();
            }

        }*/
       /* for (int i = 0; i < products.size(); i++) {
          Product product = products.get(i);
            if (product.getId()==productId.getId()) {
                products.remove(product);
            }
        }*/
    }

    public void clear() {
        products.clear();
    }
}
