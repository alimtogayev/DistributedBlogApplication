package alim.togayev.blogapplication.commentservice.controller;

import alim.togayev.blogapplication.commentservice.entities.Comment;
import alim.togayev.blogapplication.commentservice.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/users/{id}")
    public List<Comment> getUserComments(@PathVariable(name = "id") Long id) {
        return commentService.getUserComments(id);
    }
    @PostMapping("/users/{uid}/posts/{pid}")
    public Comment commentPost(@PathVariable(name = "uid") Long uid, @PathVariable(name = "pid") Long pid, @RequestBody String content) {
        Comment comment = new Comment();
        comment.setPostId(pid);
        comment.setContent(content);
        comment.setUserId(uid);
        return commentService.addComment(comment);
    }

    @GetMapping("/posts/{id}")
    public List<Comment> getPostComments(@PathVariable(name = "id") Long id) {
        return commentService.getPostComments(id);
    }


}
