package alim.togayev.blogapplication.userservice.service;

import alim.togayev.blogapplication.userservice.dto.PostDto;
import alim.togayev.blogapplication.userservice.entities.Comment;
import alim.togayev.blogapplication.userservice.entities.Like;
import alim.togayev.blogapplication.userservice.entities.Post;
import alim.togayev.blogapplication.userservice.entities.User;
import alim.togayev.blogapplication.userservice.feign.PostInterface;
import alim.togayev.blogapplication.userservice.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final PostInterface postInterface;
    public UserService(UserRepository userRepository, PostInterface userInterface) {
        this.userRepo = userRepository;
        this.postInterface = userInterface;
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public Post addPost(Long userId, PostDto postRequest){
        Post post = postInterface.addPost(userId, postRequest);
        User user = userRepo.findById(userId).orElse(null);
        user.getPostIds().add(post.getId());
        return post;
    }

    public Long addLikeToUser(Like like){
        User user = userRepo.findById(like.getUserId()).orElse(null);
        user.getLikeIds().add(like.getId());
        userRepo.save(user);
        return like.getId();
    }

    public String save(String username){
        User user = new User();
        user.setUsername(username);
        userRepo.save(user);
        return user.getUsername();
    }

    public Long addCommentToUser(Comment comment){
        User user = userRepo.findById(comment.getUserId()).orElse(null);
        user.getCommentIds().add(comment.getId());
        userRepo.save(user);
        return comment.getId();
    }
}
