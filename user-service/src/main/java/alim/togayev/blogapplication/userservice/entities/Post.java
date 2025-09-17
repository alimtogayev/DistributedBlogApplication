package alim.togayev.blogapplication.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private List<Long> likeIds;
    private List<Long> commentIds;
}
