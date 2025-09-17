package alim.togayev.blogapplication.commentservice.repo;

import alim.togayev.blogapplication.commentservice.entities.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("POST-SERVICE")
public interface PostInterface {
    @PostMapping("post/comment")
    public Long addCommentToPost(Long commentId);
}
