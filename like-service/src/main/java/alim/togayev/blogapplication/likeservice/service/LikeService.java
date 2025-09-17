package alim.togayev.blogapplication.likeservice.service;

import alim.togayev.blogapplication.likeservice.entities.Like;
import alim.togayev.blogapplication.likeservice.feign.PostInterface;
import alim.togayev.blogapplication.likeservice.feign.UserInterface;
import alim.togayev.blogapplication.likeservice.repo.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LikeService {
    private final LikeRepository likeRepo;
    private final PostInterface postInterface;
    private final UserInterface userInterface;
    public LikeService(LikeRepository repository, PostInterface postInterface, UserInterface userInterface) {
        this.likeRepo = repository;
        this.postInterface = postInterface;
        this.userInterface = userInterface;
    }

    public List<Like> getUserLikes(Long id) {
        return likeRepo.findByUserId(id);
    }

    public Like addLike(Long postId, Long userId) {
        Like like = new Like();
        like.setUserId(userId);
        like.setPostId(postId);
        postInterface.addLikeToPost(like);
        userInterface.addLikeToUser(like);
        return likeRepo.save(like);
    }
    public List<Like> getPostLikes(Long id){
        return likeRepo.findByPostId(id);
    }
}
