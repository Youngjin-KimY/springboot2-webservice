package com.ebay.book.springboot.service.posts;

import com.ebay.book.springboot.domain.posts.Posts;
import com.ebay.book.springboot.domain.posts.PostsRepository;
import com.ebay.book.springboot.web.dto.PostsListResponseDto;
import com.ebay.book.springboot.web.dto.PostsResponseDto;
import com.ebay.book.springboot.web.dto.PostsSaveRequestDto;
import com.ebay.book.springboot.web.dto.PostsUpdateRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public PostsService(PostsRepository value){
        this.postsRepository = value;
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
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

    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository
                .findAllOrderByIdDesc()
                .stream()
                //.map(posts -> new PostsListResponseDto(posts))
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts user = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no user exist. id= "+ id));

        postsRepository.deleteById(user.getId());
    }
}
