package alim.togayev.blogapplication.postservice.service;

import alim.togayev.blogapplication.postservice.dto.PostDto;
import alim.togayev.blogapplication.postservice.entities.Comment;
import alim.togayev.blogapplication.postservice.entities.Like;
import alim.togayev.blogapplication.postservice.entities.Post;
import alim.togayev.blogapplication.postservice.repo.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<Post> showPostsByUser(Long userId) {
        return postRepository.findByUserId(userId);
    }
    public Post addPost(Long userId, PostDto postRequest) {
        Post post = new Post();
        post.setUserId(userId);
        post.setContent(postRequest.getContent());
        post.setTitle(postRequest.getTitle());
        return postRepository.save(post);
    }
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Long addLikeToPost(Like like) {
        Post post = postRepository.findById(like.getPostId()).orElse(null);
        assert post != null;
        post.getLikeIds().add(like.getId());
        postRepository.save(post);
        return like.getId();
    }

    public Long addCommentToPost(Comment comment){
        Post post = postRepository.findById(comment.getPostId()).orElse(null);
        post.getCommentIds().add(comment.getId());
        postRepository.save(post);
        return comment.getId();
    }
}
