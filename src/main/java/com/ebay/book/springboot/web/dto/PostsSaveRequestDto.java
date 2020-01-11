package com.ebay.book.springboot.web.dto;

import com.ebay.book.springboot.domain.posts.Posts;

public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    public PostsSaveRequestDto(){

    }

    public PostsSaveRequestDto(builder builder){
        this.title = builder.title;
        this.content = builder.content;
        this.author = builder.author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }



    public static class builder{
        private String title;
        private String content;
        private String author;

        public builder(){

        }
        public builder title(String title){
            this.title = title;
            return this;
        }
        public builder content(String contents){
            this.content = contents;
            return this;
        }
        public builder author(String author){
            this.author = author;
            return this;
        }
        public PostsSaveRequestDto build(){
            PostsSaveRequestDto postsSaveRequestDto = new PostsSaveRequestDto(this);
            if(isValid(postsSaveRequestDto)){
                return postsSaveRequestDto;
            }

            throw new IllegalArgumentException("Invalid data provided");
        }

        public boolean isValid(PostsSaveRequestDto value){
            return true;
        }

    }

    public Posts ToEntity(){
        return new Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

