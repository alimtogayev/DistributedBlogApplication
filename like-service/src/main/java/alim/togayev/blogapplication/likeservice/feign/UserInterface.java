package alim.togayev.blogapplication.likeservice.feign;

import alim.togayev.blogapplication.likeservice.entities.Like;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("USER-SERVICE")
public interface UserInterface {
    @PostMapping("user/like")
    public Long addLikeToUser(@RequestBody Like like);
}
