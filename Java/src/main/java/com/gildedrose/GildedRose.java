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
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < DUE_DATE) { // If DUE_DATE has passed
                if (item.name.equals("Aged Brie")) {
                    item.quality = item.quality + 2;
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = 0;
                } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    // Currently do nothing
                } else {
                    item.quality = item.quality - 2;
                }
            } else { // If DUE_DATE is not yet passed

                if (item.name.equals("Aged Brie")) {
                    item.quality = item.quality + 1;
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (10 < item.sellIn) {
                        item.quality = item.quality + 1;
                    } else if (6 <= item.sellIn && item.sellIn <= 10) {
                        item.quality = item.quality + 2;
                    } else if (item.sellIn <= 5) {
                        item.quality = item.quality + 3;
                    }
                } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    // Currently do nothing
                } else {
                    item.quality = item.quality - 1;
                }
            }
            setQualityInRange(item);
        }
    }
}