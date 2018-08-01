package com.Task.RSS_Feed.service;

import com.Task.RSS_Feed.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    void addItem(Item item);
}
