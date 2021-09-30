package entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String context;

    private LocalDate data = LocalDate.now();
    @OneToMany
    @JoinColumn(name = "like_id")
    private List<Likes> likes;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User users;

}
