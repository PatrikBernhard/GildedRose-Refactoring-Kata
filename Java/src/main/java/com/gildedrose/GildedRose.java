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
            // If item is NOT the two that gets increased quality in time (Brie, Backstage pass)
            if (!item.name.equals("Aged Brie") // Two NOT equal checks
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                //  Check to ensure doesn't go negative.
                // Maybe should be additional method making sure quality is well defined (i.e. 0 <= quality <= 50 for non-legendary)
                if (item.quality > LOWEST_QUALITY) { 
                    //Another NOT check, should be an inclusive check or at least be with the first 2
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        // Gets here if NOT brie, pass or sulfuras and quality not < 0.
                        item.quality = item.quality - 1;
                    }
                }
            // Hard to read nested branches, reaches here if Aged Brie or Backstage Pass (Note: not Sulfuras)
            } else {
                    item.quality = item.quality + 1;

                    // Checks if Backstage pass but no else for Aged Brie (Note: no NOT this time)
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) { // Checking if should be increased by 2
                                item.quality = item.quality + 1; // Should be a 2 if not for previous increase
                        }
                        if (item.sellIn < 6) {
                                item.quality = item.quality + 1; // Should be 3 if not for previous increases
                        }
                    }
            }
            // Again, a NOT check for Sulfuras
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }
            // If passed due date
            if (item.sellIn < DUE_DATE) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Decrease items that are not brie and backstage pass again by 1
                            // And also if not Sulfuras
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                    } else { // If backstage pass and passed due date
                        // Set to 0
                        item.quality = 0;
                    }
                } else { // If Aged Brie is passed due date, this will increase it by an additional 1.
                        item.quality = item.quality + 1;

                }
            }
            setQualityInRange(item);
        }
    }
}