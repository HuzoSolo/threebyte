/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

/**
 *
 * @author sahin
 */

import Models.Category;
import java.util.List;

public interface CategoryDao {

    /**
     *
     * @param category
     */
    void addCategory(Category category);
    void updateCategoryName(int id, String categoryName);
    void deleteCategory(int categoryId);
    List<Category> getAllCategories();
    Category getCategory(int categoryId); 
    
    
}
