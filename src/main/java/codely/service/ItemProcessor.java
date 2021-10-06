package codely.service;

import codely.kata.Item;

public interface ItemProcessor {
    void processAgedBrie(final Item item);
    void processSulfuras(final Item item);
    void processCommonObject(final Item item);
}
