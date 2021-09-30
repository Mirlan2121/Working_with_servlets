package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Student> studentId;
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentorId;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course courseId;
}
