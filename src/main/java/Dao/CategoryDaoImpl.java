/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author sahin
 */


import Models.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private Connection con;

    public CategoryDaoImpl() {
      
    }

    @Override
    public void addCategory(Category category) {
        String insertSql = "INSERT INTO categories (name, description) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(insertSql)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category category) {
        String updateSql = "UPDATE categories SET name = ?, description = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(updateSql)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setInt(3, category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        String deleteSql = "DELETE FROM categories WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteSql)) {
            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String selectSql = "SELECT * FROM categories";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectSql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Category category = new Category(id, name, description);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        Category category = null;
        String selectSql = "SELECT * FROM categories WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, categoryId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    category = new Category(id, name, description);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}

