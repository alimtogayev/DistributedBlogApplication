package alim.togayev.blogapplication.commentservice.service;

import alim.togayev.blogapplication.commentservice.entities.Comment;
import alim.togayev.blogapplication.commentservice.repo.CommentRepository;
import alim.togayev.blogapplication.commentservice.repo.PostInterface;
import alim.togayev.blogapplication.commentservice.repo.UserInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostInterface postInterface;
    private final UserInterface userInterface;
    public CommentService(CommentRepository commentRepository, PostInterface postInterface, UserInterface userInterface) {
        this.commentRepository = commentRepository;
        this.postInterface = postInterface;
        this.userInterface = userInterface;
    }

    public List<Comment> getPostComments(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> getUserComments(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    public Comment addComment(Comment comment) {
        postInterface.addCommentToPost(comment.getId());
        userInterface.addCommentToUser(comment.getId());
        return commentRepository.save(comment);
    }
}
