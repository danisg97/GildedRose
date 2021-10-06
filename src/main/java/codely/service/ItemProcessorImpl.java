package codely.service;

import codely.kata.Item;

public class ItemProcessorImpl implements ItemProcessor {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private static final int AGED_BRIE_10_DAYS_TO_SELL_IN = 10;
    private static final int AGED_BRIE_5_DAYS_TO_SELL_IN = 5;
    private static final int AGED_BRIE_0_DAYS_TO_SELL_IN = 0;

    @Override
    public void processAgedBrie(Item item) {
        if(item.quality <= MAX_QUALITY) {
            increaseAgedBrieQuality(item);
        }
        decreaseSellIn(item);
    }

    @Override
    public void processSulfuras(Item item) {
        decreaseSellIn(item);
    }

    @Override
    public void processBackstage(Item item) {
        if(item.quality >= MIN_QUALITY) {
            decreaseQuality(item);
        }
        decreaseSellIn(item);
    }

    private void increaseQuality(Item item) {
        item.quality += 1;
    }

    private void decreaseQuality(Item item) {
        item.quality -= 1;
    }

    private void increaseAgedBrieQuality (Item item) {
        if (item.sellIn < AGED_BRIE_10_DAYS_TO_SELL_IN && item.sellIn > AGED_BRIE_5_DAYS_TO_SELL_IN) {
            item.quality += 2;
        }else if(item.sellIn < AGED_BRIE_5_DAYS_TO_SELL_IN) {
            item.quality += 3;
        } else if (item.sellIn == AGED_BRIE_0_DAYS_TO_SELL_IN) {
            item.quality = 0;
        } else {
            increaseQuality(item);
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }
}
