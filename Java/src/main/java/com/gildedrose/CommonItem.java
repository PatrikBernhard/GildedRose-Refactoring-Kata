package com.gildedrose;

public class CommonItem extends IdentifiedItem {
    public CommonItem(Item item) {
        super(item);
    }

    public void update() {
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            item.quality -= 2; 
        } else {
            item.quality -= 1;
        }
    }
    
}
