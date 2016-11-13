package com.meajireview.meajireviewforadmin;

/**
 * Created by songmho on 2016-10-24.
 */

public class ShopItem {
    String food, price;

    public String getFood() {
        return food;
    }

    public String getPrice() {
        return price;
    }
    public ShopItem(String food, String price){
        this.food=food;
        this.price=price;
    }
}
