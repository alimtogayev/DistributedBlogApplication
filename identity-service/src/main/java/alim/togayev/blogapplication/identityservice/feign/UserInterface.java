package alim.togayev.blogapplication.identityservice.feign;

import alim.togayev.blogapplication.identityservice.entities.UserCredential;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("USER-SERVICE")
public interface UserInterface {
    @PostMapping("/user/save")
    public String save(@RequestBody String username);
}
