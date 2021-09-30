package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts postId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
}
