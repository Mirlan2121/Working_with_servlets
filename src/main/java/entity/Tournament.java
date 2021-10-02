package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tournament")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contry_id")
    private Country country;
    private String name;
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
    @Override
    public String toString() {
        return "Имя: " + name + ", Спорт: " + sport + ", Страна: " + country ;
    }
}