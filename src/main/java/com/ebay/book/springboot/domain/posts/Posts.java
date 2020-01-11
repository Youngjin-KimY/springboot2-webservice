package com.ebay.book.springboot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable=false)
    private String content;

    private String author;

    public Posts(){

    }
    public Posts(builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.author = builder.author;
    }
    public Long getId(){return id;}

    public String getTitle() {
        return title;
    }


    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }

    public static class builder {
        private String title;
        private String content;
        private String author;
        public builder(){

        }

        public builder title(String title){
            this.title = title;
            return this;
        }

        public builder content(String content){
            this.content = content;
            return this;
        }

        public builder author(String author){
            this.author = author;
            return this;
        }

        public Posts build(){
            Posts posts = new Posts(this);

            if(isValid(posts)){
                return posts;
            }

            throw new IllegalArgumentException("Invalid data provided");
        }

        private boolean isValid(Posts post){
            return true;
        }
    }
}


