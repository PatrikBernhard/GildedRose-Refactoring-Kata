package com.gildedrose;

public class BrieItem extends IdentifiedItem {
    public BrieItem(Item item) {
        super(item);
    }

    public void update() {
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            item.quality += 2; 
        } else {
            item.quality += 1;
        }
    }
}