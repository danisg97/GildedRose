import codely.kata.Item;
import codely.service.ItemProcessor;
import codely.service.ItemProcessorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        ItemProcessor itemProcessor = new ItemProcessorImpl();
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items, itemProcessor);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
    }

}
