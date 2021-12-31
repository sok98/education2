package com.spring.news;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    String title = "인지 신문사";
    ArrayList<News> db_news = new ArrayList<News>();
    ArrayList<Banner> db_banner = new ArrayList<Banner>();

    public WebController() {
        db_news.add(new News(0, "기사1", "a.jpg", "내용1"));
        db_news.add(new News(1, "기사2", "b.jpg", "내용2"));
        db_news.add(new News(2, "기사3", "c.jpg", "내용3"));
        db_news.add(new News(3, "기사4", "d.jpg", "내용4"));
        db_news.add(new News(4, "기사5", "e.jpg", "내용5"));

        db_banner.add(new Banner(0, "banner1.jpg", "https://www.naver.com"));
        db_banner.add(new Banner(1, "banner2.jpg", "https://www.google.com"));
        db_banner.add(new Banner(2, "banner3.jpg", "https://www.daum.net"));
    }

    @RequestMapping(value = "/")
    public String main(Model model) {
        List<News> db_top3 = new ArrayList<>();
        db_top3.add(db_news.get(0));
        db_top3.add(db_news.get(2));
        db_top3.add(db_news.get(1));

        model.addAttribute("title", title);
        model.addAttribute("address", "서울시 강남구");

        model.addAttribute("db_top3", db_top3);
        model.addAttribute("db_news", db_news);
        model.addAttribute("db_banner", db_banner);

        return "main";
    }

    @RequestMapping(value = "/read")
    public String read(Model model, @RequestParam int id) {
        News find = null;
        for (News news : db_news) if (news.getId() == id) find = news;
        model.addAttribute("news", find);

//        News news = db_news.get(id);
//        model.addAttribute("news", news);

        return "read";
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "add";
    }

//    @RequestMapping(value = "/add_commit")
//    public String add_commit(@ModelAttribute News news){
//        // db 저장
//        System.out.println(news);
//        db_news.add(news);
//
//        // 다시 홈으로 이동
//        return "redirect:/";
//    }

    @RequestMapping(value = "/add_commit")
    @ResponseBody
    public String add_commit(@ModelAttribute News news) {
        news.setId(db_news.get(db_news.size() - 1).getId() + 1);
        // db 저장
        System.out.println(news);
        db_news.add(news);

        // 다시 홈으로 이동
        return "<script> alert('ok'); window.location.href='/'; </script>";
    }

    @RequestMapping(value = "/del_commit")
    public String del_commit(@RequestParam int id) {
        News find = null;
        for (News news : db_news) if (news.getId() == id) find = news;

        db_news.remove(find);
        return "redirect:/";
    }

    @RequestMapping(value = "/update")
    public String update(Model model, @RequestParam int id) {
//        News find = null;
//        for (News news : db_news) if (news.getId() == id) find = news;
        News find = db_news.stream().filter(n->n.getId() == id).findFirst().orElse(null);
        model.addAttribute("news", find);

        return "update";
    }

    @RequestMapping(value = "/update_commit")
    public String update_commit(@ModelAttribute News form) {
        News find = null;
        for (News news : db_news) if (news.getId() == form.getId()) find = news;
        find.setTitle(form.getTitle());
        find.setImg(form.getImg());
        find.setContent(form.getContent());

        return "redirect:/";
    }
}
