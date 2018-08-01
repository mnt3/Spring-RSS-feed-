package com.Task.RSS_Feed.service;

import com.Task.RSS_Feed.model.Item;
import com.Task.RSS_Feed.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {


    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Transactional
    @Override
    public void addItem(Item item) {

        itemRepository.save(item);
    }
}
