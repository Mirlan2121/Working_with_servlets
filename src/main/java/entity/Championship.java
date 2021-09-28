package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "championship")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kind_of_sport_id")
    private KindOfSport kindOfSport;
}