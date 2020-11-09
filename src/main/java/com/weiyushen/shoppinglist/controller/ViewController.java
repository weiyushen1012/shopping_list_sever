package com.weiyushen.shoppinglist.controller;

import com.weiyushen.shoppinglist.model.*;
import com.weiyushen.shoppinglist.repository.ShoppingListItemRepository;
import com.weiyushen.shoppinglist.repository.ShoppingListRepository;
import com.weiyushen.shoppinglist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/")
public class ViewController {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingListItemRepository shoppingListItemRepository;

    private User getCurrentUser() {
        var userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.getUserByEmail(userEmail);
    }

    @GetMapping(path = "/")
    public String getHome(Model model) {

        model.addAttribute("lists", shoppingListRepository.getShoppingListByUserId(getCurrentUser().getId()));

        return "home";
    }

    @GetMapping(path = "/{shoppingListId}")
    public String getShoppingListEntry(Model model, @PathVariable("shoppingListId") Integer shoppingListId) {

        model.addAttribute("lists", shoppingListRepository.getShoppingListByUserId(getCurrentUser().getId()));

        var shoppingList = shoppingListRepository.findById(shoppingListId);
        shoppingList.ifPresent(list -> {
            model.addAttribute("shoppingListName", list.getName());
            model.addAttribute("currentShoppingListId", list.getId());

            model.addAttribute("listItems", list.getShoppingListItems());
        });

        return "home";
    }

    @PostMapping("add-list")
    public String addShoppingList(Model model, @ModelAttribute("shoppingList") ShoppingListBody body) {

        if (body.getShoppingListName() == null || body.getShoppingListName().length() == 0) {
            return "redirect:/";
        }

        var newShoppingList = new ShoppingList();

        newShoppingList.setName(body.getShoppingListName());
        newShoppingList.setShoppingListItems(new ArrayList<>());
        newShoppingList.setUser(getCurrentUser());

        var currentDate = new Date();
        newShoppingList.setCreated(currentDate);
        newShoppingList.setUpdated(currentDate);

        shoppingListRepository.save(newShoppingList);

        return "redirect:/";
    }

    @PostMapping("add-list-item")
    public String addShoppingListItem(Model model, @ModelAttribute("shoppingListItem") ShoppingListItemBody body) {
        var currentShoppingListId = body.getShoppingListId();
        var currentShoppingList = shoppingListRepository.findById(currentShoppingListId);


        if (body.getShoppingListItemContent() == null
                || body.getShoppingListItemContent().length() == 0
                || currentShoppingList.isEmpty()) {
            return "redirect:/" + currentShoppingListId;
        }

        var newShoppingListItem = new ShoppingListItem();

        newShoppingListItem.setContent(body.getShoppingListItemContent());
        newShoppingListItem.setShoppingList(currentShoppingList.get());

        var currentDate = new Date();
        newShoppingListItem.setCreated(currentDate);
        newShoppingListItem.setUpdated(currentDate);

        shoppingListItemRepository.save(newShoppingListItem);

        return "redirect:/" + currentShoppingListId;
    }
}
