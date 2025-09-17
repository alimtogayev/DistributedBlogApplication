package alim.togayev.blogapplication.userservice.feign;

import alim.togayev.blogapplication.userservice.dto.PostDto;
import alim.togayev.blogapplication.userservice.entities.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("POST-SERVICE")
public interface PostInterface {
    @PostMapping("post/users/{id}/posts")
    public Post addPost(@RequestParam(name = "id") Long id, @RequestBody PostDto postRequest);
}
