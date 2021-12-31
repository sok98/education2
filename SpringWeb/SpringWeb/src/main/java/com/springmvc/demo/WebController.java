package com.springmvc.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class WebController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return  "<h1>홈페이지</h1>";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return  "<h1>테스트홈페이지</h1>";
    }

    @GetMapping("/movie")
    @ResponseBody
    public String movie() {
        Movie movie = new
                Movie(0, "스파이더맨: 노 웨이 홈", "^^^");
        movie.setImg("movie1.jpg");

        String html = "";

        html = "<H1>" + movie.getTitle()  + "</H1>" +
               "영화줄거리 :  <h2>"  + movie.getStory() + "</h2>" +
               "<img src='" + movie.getImg() + "' width=300>";

        return  html;
    }

    @GetMapping("/movie2")
    public String movie2(Model model) {
        Movie movie = new
                Movie(0, "스파이더맨: 노 웨이 홈", "^^^");
        movie.setImg("movie1.jpg");
        movie.setUrl("https://movie.naver.com/movie/bi/mi/basic.naver?code=208077");

        model.addAttribute("title", "홍길동");
        model.addAttribute("movie", movie);
        return  "movie2";
    }

    @GetMapping("/movie3")
    public String movie3(Model model) {

        ArrayList<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie(1, "스파이더맨", "^^^^"));
        movies.add(new Movie(2,  "오징어", "====="));
        movies.add(new Movie(3,  "해피 뉴 이어", "########"));

        model.addAttribute("title", "홍길동");
        model.addAttribute("movies", movies);

        return  "movie2";
    }



}


