package com.ebay.book.springboot.web.dto;

public class PostsUpdateRequestDto {
    private String title;
    private String content;

    public PostsUpdateRequestDto(){

    }

    public PostsUpdateRequestDto(builder builder){
        title = builder.title;
        content = builder.content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {return content;}

    public static class builder{
        private String title;
        private String content;

        public builder(){ }

        public builder title(String title){
            this.title = title;
            return this;
        }
        public builder content(String content){
            this.content = content;
            return this;
        }

        public PostsUpdateRequestDto build(){
            PostsUpdateRequestDto postsUpdateRequestDto = new PostsUpdateRequestDto(this);
            if(isValid(postsUpdateRequestDto)) return postsUpdateRequestDto;

            throw new IllegalArgumentException("Invalid data provided");

        }

        public boolean isValid(PostsUpdateRequestDto value){return true;}
    }

}
