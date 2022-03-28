package com.ebay.book.springboot.domain.posts;

import com.ebay.book.springboot.web.dto.PostsListResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback
@ActiveProfiles("test")
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void postSaveAndLoad(){

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        Posts p1 = Posts.builder()
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

    @Test
    public void listTest() {
        Posts p1 = new Posts("aaaa","aaaa","aaaa");
        Posts p2 = new Posts("bbb","bbb","bbb");

        postsRepository.save(p1);
        postsRepository.save(p2);

        List<PostsListResponseDto> collect = postsRepository.findAll()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());

        for(PostsListResponseDto e1 : collect) {
            System.out.println(e1.toString());
        }
    }

}
