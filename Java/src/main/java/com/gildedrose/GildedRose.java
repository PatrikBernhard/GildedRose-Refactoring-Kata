package com.gildedrose;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

class GildedRose {
    Item[] items;
    final static int HIGHEST_QUALITY = 50;
    final static int LOWEST_QUALITY = 0;
    final static int DUE_DATE = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void setQualityInRange(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            if (item.quality < 0) {
                item.quality = LOWEST_QUALITY;
            } else if (item.quality > 50) {
                item.quality = HIGHEST_QUALITY;
            }
        }
    }

    public void updateQuality() {
        for (Item item : this.items) {
            // Part 1, always increase despite what date it is
            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;

            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (10 < item.sellIn) {
                    item.quality = item.quality + 1;
                } else if (6 <= item.sellIn && item.sellIn <= 10) {
                    item.quality = item.quality + 2;
                } else if (item.sellIn <= 5) {
                    item.quality = item.quality + 3;
                }
            } else if (item.name.equals("Aged Brie")) {
                item.quality = item.quality + 1;
            }
            // Part 2, decrease sell in

            // Again, a NOT check for Sulfuras
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }
            
            // Part 3, handle changes according to due date
            if (item.sellIn < DUE_DATE) {
                if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = 0;
                } else if (item.name.equals("Aged Brie")) { 
                        item.quality = item.quality + 1;
                }
            }
            setQualityInRange(item);
        }
    }
}