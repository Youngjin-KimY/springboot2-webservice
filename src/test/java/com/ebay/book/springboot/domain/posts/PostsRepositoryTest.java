package com.ebay.book.springboot.domain.posts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void postSaveAndLoad(){

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        Posts p1 = new Posts.builder()
                .title(title)
                .content(content)
                .author("11kimyj@gmail.com")
                .build();
        postsRepository.save(p1);

        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
