package com.ebay.book.springboot.web.dto;

import com.ebay.book.springboot.domain.posts.Posts;

public class PostsResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.contents = entity.getContent();
        this.author = entity.getAuthor();
    }
}

