package codely.service;

import codely.kata.Item;

public class ItemUpdaterImpl implements ItemUpdater {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private static final int AGED_BRIE_10_DAYS_TO_SELL_IN = 10;
    private static final int AGED_BRIE_5_DAYS_TO_SELL_IN = 5;
    private static final int AGED_BRIE_0_DAYS_TO_SELL_IN = 0;

    private static final String CONJURED = "CONJURED";

    @Override
    public void updateAgedBrie(Item item) {
        if(item.quality <= MAX_QUALITY) {
            increaseAgedBrieQuality(item);
        }
        decreaseSellIn(item);
    }

    @Override
    public void updateSulfuras(Item item) {
        decreaseSellIn(item);
    }

    @Override
    public void updateCommonObject(Item item) {
        if(item.quality >= MIN_QUALITY) {
            decreaseQuality(item);
        }
        decreaseSellIn(item);
    }

    private void increaseQuality(Item item) {
        item.quality += 1;
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

    private void decreaseQuality(Item item) {
        if (isConjured(item)) {
            item.quality -= 2;
        } else {
            item.quality -= 1;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private Boolean isConjured (Item item) {
        String itemNameToUpperCase = item.name.toUpperCase();
        return itemNameToUpperCase.contains(CONJURED);
    }
}
