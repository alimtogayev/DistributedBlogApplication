package alim.togayev.blogapplication.likeservice.controller;

import alim.togayev.blogapplication.likeservice.entities.Like;
import alim.togayev.blogapplication.likeservice.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("like")
public class LikeController {
    private final LikeService likeService;
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/users/{id}/likes")
    public List<Like> getUserLikes(@PathVariable(name = "id") Long userId) {
        return likeService.getUserLikes(userId);
    }

    @PostMapping("/users/{uid}/posts/{pid}")
    public Like likePost(@PathVariable(name = "uid") Long uid, @PathVariable(name = "pid") Long pid) {
        return likeService.addLike(pid, uid);
    }

    @GetMapping("/posts/{id}/likes")
    public List<Like> getPostLikes(@PathVariable(name = "id") Long id) {
        return likeService.getUserLikes(id);
    }
}
