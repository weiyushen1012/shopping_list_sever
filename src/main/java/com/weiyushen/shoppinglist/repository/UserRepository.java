package com.weiyushen.shoppinglist.repository;

import com.weiyushen.shoppinglist.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
