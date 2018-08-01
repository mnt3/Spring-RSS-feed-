package com.Task.RSS_Feed.repository;

import com.Task.RSS_Feed.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeedRepository extends JpaRepository<Feed,Long> {
}
