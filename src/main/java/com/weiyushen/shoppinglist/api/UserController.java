package com.weiyushen.shoppinglist.api;

import com.weiyushen.shoppinglist.model.User;
import com.weiyushen.shoppinglist.model.UserBody;
import com.weiyushen.shoppinglist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestBody UserBody body) {
        User newUser = new User();
        newUser.setEmail(body.getEmail());
        newUser.setPassword(body.getPassword());

        var currentDate = new Date();

        newUser.setCreated(currentDate);
        newUser.setUpdated(currentDate);

        userRepository.save(newUser);

        return "Created";
    }

}
