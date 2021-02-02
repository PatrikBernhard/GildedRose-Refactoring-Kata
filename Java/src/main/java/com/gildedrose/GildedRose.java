package com.gildedrose;


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
    private IdentifiedItem identifyItems(Item item) {
        return new IdentifyItemFactory().identifyItem(item);
    }

    public void updateQuality() {
        for (Item item : this.items) {
            identifyItems(item).update();
            setQualityInRange(item);
        }
    }
}