package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "teams")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String logo;
    private String site;
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
    public String toString() {
        return "Имя: " + name + ", Спорт: " + sport + ", Страна: " + country ;
    }
}
