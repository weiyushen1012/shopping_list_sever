package com.weiyushen.shoppinglist.repository;

import com.weiyushen.shoppinglist.model.ShoppingList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer> {
    @Query(value = "SELECT * FROM shopping_list WHERE user_id = :userId", nativeQuery = true)
    public List<ShoppingList> getShoppingListByUserId(@Param("userId") Integer userId);

}
