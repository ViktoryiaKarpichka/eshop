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

    // не получается реализовать этот метод. Продукт не удаляется. В консоли видно,что делается один селект.
    //Или надо создавать отдельно базу данных cart. Помогите разобраться, плиз
    public void deleteProduct(Product productId) {
          products.remove(productId);
    }
      /*  Product product = new Product();
      for (int i = 0; i < products.size(); i++) {
            product = products.get(i);
            if (product.equals(myProduct)) {
                products.remove(product);
            }
        }*/


    public void clear() {
        products.clear();
    }
}
