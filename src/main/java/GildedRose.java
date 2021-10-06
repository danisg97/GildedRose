import codely.kata.Item;
import codely.service.ItemProcessor;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;
    ItemProcessor itemProcessor;

    public GildedRose(Item[] items, ItemProcessor itemProcessor) {
        this.items = items;
        this.itemProcessor = itemProcessor;
    }

    public void updateQuality() {
        for(final Item item : items) {
            if(AGED_BRIE.equals(item.name)) {
                itemProcessor.processAgedBrie(item);
            } else if(SULFURAS.equals(item.name)) {
                itemProcessor.processSulfuras(item);
            } else {
                itemProcessor.processCommonObject(item);
            }
        }
    }
}