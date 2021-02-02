package com.gildedrose;

import java.util.HashSet; 

public class IdentifyItemFactory {
    private final static HashSet<String>
        LEGENDARY = new HashSet<String>();
    private final static HashSet<String>
        BRIE = new HashSet<String>();
    private final static HashSet<String>
        BACKSTAGE = new HashSet<String>();

    public IdentifyItemFactory() {
        LEGENDARY.add("Sulfuras, Hand of Ragnaros");
        BRIE.add("Aged Brie");
        BACKSTAGE.add("Backstage passes to a TAFKAL80ETC concert");
    }

    public IdentifiedItem identifyItem(Item item) {
        if (LEGENDARY.contains(item.name)) {
            return new LegendaryItem(item);
        } else if (BRIE.contains(item.name)) {
            return new BrieItem(item);
        } else if (BACKSTAGE.contains(item.name)) {
            return new BackstageItem(item);
        } else if (item.name.toLowerCase().contains("conjured")) {
            return new ConjuredItem(item);
        } else {
            return new CommonItem(item);
        }
    }
}
