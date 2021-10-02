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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Integer age;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
