package ru.kpfu.itis.greenmapc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.greenmapc.exception.NotFoundException;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.model.VkWallRecord;
import ru.kpfu.itis.greenmapc.service.NewsService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {

    private NewsService newsService;


    @GetMapping("/")
    public String getNews(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                          @AuthenticationPrincipal User user,
                          ModelMap modelMap) {

        List<VkWallRecord> news;
        try {
            news = newsService.getNews(page);
        } catch (NumberFormatException e) {
            news = newsService.getNews(0);
        }

        modelMap.addAttribute("news", news);
        if(page != 0) {
            modelMap.addAttribute("previousPage", page - 1);
        }
        if(newsService.existNextPage(page)) {
            modelMap.addAttribute("nextPage", page + 1);
        }

        modelMap.addAttribute("user", user);
        return "news";
    }

    @GetMapping("/item/{newsItem}")
    public String getNewsItem(@PathVariable(value = "newsItem") int item,
                              @AuthenticationPrincipal User user,
                              ModelMap modelMap) {
        Optional<VkWallRecord> record = newsService.getItem(item);
        if(record.isPresent()) {
            modelMap.addAttribute("news", record.get());
        } else {
            throw new NotFoundException("Такой новости не существует");
        }
        modelMap.addAttribute("user", user);
        return "newsItem";
    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
}
