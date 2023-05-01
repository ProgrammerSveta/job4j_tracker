package ru.job4j.tracker;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class SortingTest {

    @Test
    public void itemAscByNameTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("banana"));
        items.add(new Item("apple"));
        items.add(new Item("cherry"));
        Collections.sort(items, new ItemAscByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("apple"));
        expected.add(new Item("banana"));
        expected.add(new Item("cherry"));
        assertEquals(items, expected);
    }

    @Test
    public void itemDescByNameTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("cherry"));
        items.add(new Item("apple"));
        items.add(new Item("banana"));
        Collections.sort(items, new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("cherry"));
        expected.add(new Item("banana"));
        expected.add(new Item("apple"));
        assertEquals(items, expected);
    }
}