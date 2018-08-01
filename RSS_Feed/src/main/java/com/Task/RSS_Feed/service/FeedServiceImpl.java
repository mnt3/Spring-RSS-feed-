package com.Task.RSS_Feed.service;

import com.Task.RSS_Feed.model.Feed;
import com.Task.RSS_Feed.model.Item;
import com.Task.RSS_Feed.repository.FeedRepository;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {

    private FeedRepository feedRepository;
    private String error = "";

    @Autowired
    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Transactional
    @Override
    public List<Feed> getAllFeeds() {
        return feedRepository.findAll();
    }

    @Transactional
    @Override
    public void addFeed(Feed feed) {
        System.out.println("feed url: " + feed.getUrl());

        try {

            String s = feed.getUrl();
            // using XMLreader with Rome framework, popular and easy to use
            XmlReader reader = new XmlReader(new URL(s));
            SyndFeed feed2 = new SyndFeedInput().build(reader);
            feed.setLast_update(feed2.getPublishedDate());
            feed.setTitle(feed2.getTitle());
            System.out.println("Feed Title: " + feed2.getAuthor());


            // for get all articles from feed
            for (Iterator i = feed2.getEntries().iterator(); i.hasNext(); ) {
                SyndEntry entry = (SyndEntry) i.next();
                System.out.println(entry.getTitle());
                Item newItem = new Item();
                newItem.setFeed(feed);
                // the library has  methods to escape in HTML, XML, Javascript, for non english (LT) symbols
                newItem.setTitle(org.apache.commons.lang.StringEscapeUtils.escapeHtml(entry.getTitle()));
                newItem.setPublished(entry.getPublishedDate());
                newItem.setLink(entry.getLink());
                // if description is to long for database, i take only 254 symbols
                if (entry.getDescription().getValue().length() > 254) {
                    newItem.setDescription(entry.getDescription().getValue().toString().substring(0, 254));
                } else {
                    newItem.setDescription(entry.getDescription().getValue());
                }
                feed.getItems().add(newItem);

            }
            feedRepository.save(feed);
            error = "";
        } catch (FeedException e) {
            error = "<br>This URL have feed validation error";
            e.printStackTrace();
        } catch (MalformedURLException e) {
            error = "<br>that a malformed URL has occurred";
            e.printStackTrace();
        } catch (IOException e) {
            error = "<br>Error";
            e.printStackTrace();
        }


    }

    @Transactional
    @Override
    public Feed getFeedById(Long id) {
        return feedRepository.getOne(id);
    }

    public String getError() {
        return error;
    }



}
