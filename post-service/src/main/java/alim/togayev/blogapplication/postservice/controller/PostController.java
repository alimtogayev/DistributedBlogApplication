package alim.togayev.blogapplication.postservice.controller;

import alim.togayev.blogapplication.postservice.dto.PostDto;
import alim.togayev.blogapplication.postservice.entities.Comment;
import alim.togayev.blogapplication.postservice.entities.Like;
import alim.togayev.blogapplication.postservice.entities.Post;
import alim.togayev.blogapplication.postservice.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable(name = "id") Long id) {
        return postService.showPostsByUser(id);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/users/{id}/posts")
    public Post addPost(@PathVariable(name = "id") Long id, @RequestBody PostDto postRequest) {
        return postService.addPost(id, postRequest);
    }

    @PostMapping("/like")
    public Long addLikeToPost(@RequestBody Like like) {
        return postService.addLikeToPost(like);
    }

    @PostMapping("/comment")
    public Long addCommentToPost(@RequestBody Comment comment) {
        return postService.addCommentToPost(comment);
    }
}
