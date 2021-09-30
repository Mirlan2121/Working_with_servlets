package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_course",nullable = false)
    private String name;
    @ManyToMany
    @JoinColumn(name = "mentor_id")
    private Mentor mentorId;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;
}
