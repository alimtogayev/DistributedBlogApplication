package alim.togayev.blogapplication.postservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private Long userId;
    private Long postId;
    private String content;
}
