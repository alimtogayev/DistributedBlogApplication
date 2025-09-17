package alim.togayev.blogapplication.userservice.controller;

import alim.togayev.blogapplication.userservice.dto.PostDto;
import alim.togayev.blogapplication.userservice.entities.Comment;
import alim.togayev.blogapplication.userservice.entities.Like;
import alim.togayev.blogapplication.userservice.entities.Post;
import alim.togayev.blogapplication.userservice.entities.User;
import alim.togayev.blogapplication.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/users/{id}/posts")
    public Post createPost(@PathVariable Long id, @RequestBody PostDto postRequest) {
        return userService.addPost(id, postRequest);
    }

    @PostMapping("/like")
    public Long addLikeToUser(@RequestBody Like like) {
        return userService.addLikeToUser(like);
    }

    @PostMapping("/save")
    public String save(@RequestBody String username) {
        return userService.save(username);
    }

    @PostMapping("/comments")
    public Long addCommentToUser(@RequestBody Comment comment) {
        return userService.addCommentToUser(comment);
    }
}
