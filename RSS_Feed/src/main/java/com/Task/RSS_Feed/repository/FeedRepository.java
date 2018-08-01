package com.Task.RSS_Feed.repository;

import com.Task.RSS_Feed.model.Feed;
import com.Task.RSS_Feed.model.Item;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;


public interface FeedRepository extends JpaRepository<Feed, Long> {

}
