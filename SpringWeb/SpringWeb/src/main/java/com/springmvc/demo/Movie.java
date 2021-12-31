package com.springmvc.demo;


import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor
public class Movie {
    private int id;
    private String title;
    private String story;
    private String img;
    private String url;

    public Movie(int id, String title, String story) {
        this.id = id;
        this.title = title;
        this.story = story;
        img = "";
        url = "";
    }
}
