import codely.kata.Item;
import codely.service.ItemUpdater;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;
    ItemUpdater itemUpdater;

    public GildedRose(Item[] items, ItemUpdater itemProcessor) {
        this.items = items;
        this.itemUpdater = itemProcessor;
    }

    public void updateQuality() {
        for(final Item item : items) {
            if(AGED_BRIE.equals(item.name)) {
                itemUpdater.updateAgedBrie(item);
            } else if(SULFURAS.equals(item.name)) {
                itemUpdater.updateSulfuras(item);
            } else {
                itemUpdater.updateCommonObject(item);
            }
        }
    }
}