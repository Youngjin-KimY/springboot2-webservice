package com.ebay.book.springboot.service.posts;

import com.ebay.book.springboot.domain.posts.Posts;
import com.ebay.book.springboot.domain.posts.PostsRepository;
import com.ebay.book.springboot.web.dto.PostsResponseDto;
import com.ebay.book.springboot.web.dto.PostsSaveRequestDto;
import com.ebay.book.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public PostsService(PostsRepository value){
        this.postsRepository = value;
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.ToEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

}
