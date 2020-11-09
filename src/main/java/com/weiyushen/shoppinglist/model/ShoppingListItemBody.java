package com.weiyushen.shoppinglist.model;

public class ShoppingListItemBody {
    private String shoppingListItemContent;
    private Integer shoppingListId;

    public String getShoppingListItemContent() {
        return shoppingListItemContent;
    }

    public void setShoppingListItemContent(String shoppingListItemContent) {
        this.shoppingListItemContent = shoppingListItemContent;
    }

    public Integer getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Integer shoppingListId) {
        this.shoppingListId = shoppingListId;
    }
}
