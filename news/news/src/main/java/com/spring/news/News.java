package com.spring.news;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class News {
    private int id;
    private String title;
    private String img;
    private String content;
}
