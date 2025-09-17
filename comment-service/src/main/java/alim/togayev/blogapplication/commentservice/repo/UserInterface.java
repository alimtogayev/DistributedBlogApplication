package alim.togayev.blogapplication.commentservice.repo;

import alim.togayev.blogapplication.commentservice.entities.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("USER-SERVICE")
public interface UserInterface {
    @PostMapping("user/comments")
    public Long addCommentToUser(Long commentId);
}
