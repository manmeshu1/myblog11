package com.myblog.myblog11.util;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.PostService;
import org.springframework.stereotype.Service;
@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;



    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setCotent(postDto.getCotent());
        Post savedPost = postRepository.save(post);
        PostDto dto = new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setCotent(savedPost.getCotent());




        return dto;
    }
}
