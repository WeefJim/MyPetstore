package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Category;

import java.util.List;

/**
 * Created by jinyejun on 5/10/15.
 */
public interface CategoryDAO {

    // Select All Categories
    List<Category> getCategoryList();


    // Select a Category by id
    Category getCategory(String categoryId);
}
