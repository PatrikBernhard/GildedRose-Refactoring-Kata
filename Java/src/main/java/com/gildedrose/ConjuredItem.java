package com.gildedrose;

public class ConjuredItem extends IdentifiedItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    public void update() {
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            item.quality -= 4; 
        } else {
            item.quality -= 2;
        }
    }
}