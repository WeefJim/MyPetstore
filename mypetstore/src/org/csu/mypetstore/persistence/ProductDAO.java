package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;

import java.util.List;

/**
 * Created by jinyejun on 5/10/15.
 */
public interface ProductDAO {
    List<Product> getProductListByCategoryId(String categoryId);
    Product getProduct(String productId);
    List<Product> searchProductList(String keywords);
    List<Product> getAllProduct();
}
