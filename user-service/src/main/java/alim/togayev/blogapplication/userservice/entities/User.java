package alim.togayev.blogapplication.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false)
    private String username;
    @ElementCollection
    private List<Long> postIds;
    @ElementCollection
    private List<Long> commentIds;
    @ElementCollection
    private List<Long> likeIds;
}
