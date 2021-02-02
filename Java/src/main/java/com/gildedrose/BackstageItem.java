package com.gildedrose;

public class BackstageItem extends IdentifiedItem {
    public BackstageItem(Item item) {
        super(item);
    }

    public void update() {
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            item.quality = 0; 
        } else if (0 <= item.sellIn && item.sellIn <= 5) {
            item.quality += 3;
        } else if (6 <= item.sellIn && item.sellIn <= 10) {
            item.quality += 2;
        } else if ( 10 < item.sellIn) {
            item.quality += 1;
        }
    }
}