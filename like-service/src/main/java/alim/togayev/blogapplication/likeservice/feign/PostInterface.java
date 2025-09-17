package alim.togayev.blogapplication.likeservice.feign;

import alim.togayev.blogapplication.likeservice.entities.Like;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("POST-SERVICE")
public interface PostInterface {
    @PostMapping("post/like")
    public Long addLikeToPost(@RequestBody Like like);
}
