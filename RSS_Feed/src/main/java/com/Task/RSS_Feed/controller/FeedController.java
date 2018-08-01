package com.Task.RSS_Feed.controller;

import com.Task.RSS_Feed.model.Feed;
import com.Task.RSS_Feed.model.Item;
import com.Task.RSS_Feed.service.FeedService;
import com.Task.RSS_Feed.service.ItemService;
import com.sun.syndication.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class FeedController {

    private FeedService feedService;

    private ItemService itemService;

    private  Feed feed2= new Feed();
    private  Feed feed1= new Feed("www.15min.lt","15min");



    @Autowired
    public FeedController(FeedService feedService, ItemService itemService) {
        this.feedService = feedService;
        this.itemService = itemService;
    }
    @RequestMapping(value = { "/error" },method = RequestMethod.GET)
    public String error(){
        return "error";
    }


    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        String message = "Please provide new XML RSS Feed information";
        model.addAttribute("message", message);
        model.addAttribute("feed",feed2);

        return "index";
    }

    @RequestMapping(value = { "/feedList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("feeds", feedService.getAllFeeds());
        model.addAttribute("items", itemService.getAllItems());

        return "feedList";
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Feed> getAllFeeds() {
        return (List<Feed>) feedService.getAllFeeds();
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("feed") final Feed feed, final BindingResult result, final ModelMap model) throws Exception {
        if (result.hasErrors()) {
            return "error";
        }
    try {
        feedService.addFeed(feed);
    }

catch (Exception e){
     return "error";
}

        model.addAttribute("items", itemService.getAllItems());
        return "redirect:/index";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String createNewFeed(@RequestParam long id, Map<String, Object> feed, Model model)
    {
        List<Item> mostPopularItem = new ArrayList<>(feedService.getFeedById(id).getItems());

        if(feedService.getFeedById(id).getItems().size()>5) {
             mostPopularItem = mostPopularItem.subList(0, 5);
        }

        model.addAttribute("feed", feedService.getFeedById(id));
        model.addAttribute("item", feedService.getFeedById(id).getItems());
        model.addAttribute("item_count", feedService.getFeedById(id).getItems().size());
        model.addAttribute("itemTopFive", mostPopularItem);
        return "feed";
    }


}
