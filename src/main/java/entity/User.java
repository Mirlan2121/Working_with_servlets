package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "users_name", nullable = false)
    private String name;// not null uni
    @Column(name = "login", nullable = false,unique = true)
    private String login;// not null
    @Column(name = "password", nullable = false)
    private String password;//not null
    private int age;



}
