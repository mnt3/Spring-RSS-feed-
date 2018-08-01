package com.Task.RSS_Feed.repository;

import com.Task.RSS_Feed.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item,Long> {
}
