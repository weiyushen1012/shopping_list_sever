package com.weiyushen.shoppinglist.repository;

import com.weiyushen.shoppinglist.model.ShoppingListItem;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Integer> {
}
