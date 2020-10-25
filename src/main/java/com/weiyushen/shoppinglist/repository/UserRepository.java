package com.weiyushen.shoppinglist.repository;

import com.weiyushen.shoppinglist.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM user WHERE email = :email LIMIT 1", nativeQuery = true)
    public User getUserByEmail(@Param("email") String email);
}
