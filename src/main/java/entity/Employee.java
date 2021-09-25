package entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "full_name", nullable = true, unique = true)
    private String fullName;
    @Column(nullable = false)
    private Integer age;

}
