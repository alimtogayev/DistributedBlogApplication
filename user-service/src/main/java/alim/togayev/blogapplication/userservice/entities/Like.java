package alim.togayev.blogapplication.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    private Long id;
    private Long userId;
    private Long postId;
}
