package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public String toString() {
        return name + ", Спорт: ";
    }
}
