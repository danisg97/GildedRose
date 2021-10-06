import codely.kata.Item;
import codely.service.ItemUpdater;
import codely.service.ItemUpdaterImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        ItemUpdater itemProcessor = new ItemUpdaterImpl();
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items, itemProcessor);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
    }

}
