package com.Task.RSS_Feed.service;

import com.Task.RSS_Feed.model.Feed;

public interface FeedService {

    Iterable getAllFeeds();

    void addFeed(Feed feed) throws Exception;

    Feed getFeedById(Long id);
    String getError();
}
