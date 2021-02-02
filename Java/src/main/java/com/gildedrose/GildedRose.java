package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // If item is NOT the two that gets increased quality in time (Brie, Backstage pass)
            if (!items[i].name.equals("Aged Brie") // Two NOT equal checks
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                //  Check to ensure doesn't go negative.
                // Maybe should be additional method making sure quality is well defined (i.e. 0 <= quality <= 50 for non-legendary)
                if (items[i].quality > 0) { 
                    //Another NOT check, should be an inclusive check or at least be with the first 2
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        // Gets here if NOT brie, pass or sulfuras and quality not < 0.
                        items[i].quality = items[i].quality - 1;
                    }
                }
            // Hard to read nested branches, reaches here if Aged Brie or Backstage Pass (Note: not Sulfuras)
            } else {
                if (items[i].quality < 50) { // Increase by 1 if not capped at 50
                    items[i].quality = items[i].quality + 1;

                    // Checks if Backstage pass but no else for Aged Brie (Note: no NOT this time)
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) { // Checking if should be increased by 2
                            if (items[i].quality < 50) { // Checking not capped
                                items[i].quality = items[i].quality + 1; // Should be a 2 if not for previous increase
                            }
                        }
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) { // Check if not capped again
                                items[i].quality = items[i].quality + 1; // Should be 3 if not for previous increases
                            }
                        }
                    }
                }
            }
            // Again, a NOT check for Sulfuras
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            // If passed due date
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Decrease items that are not brie and backstage pass again by 1
                        if (items[i].quality > 0) { // Check if can be decreased
                            // And also if not Sulfuras
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else { // If backstage pass and passed due date
                        // Set to 0
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else { // If Aged Brie is passed due date, this will increase it by an additional 1.
                    if (items[i].quality < 50) { // Check if capped
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}