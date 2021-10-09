package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "city", length = 20)
    private String city;
    @Column(name = "street", length = 20)
    private String street;
    private String home;
    @Column(name = "apartment_office", length = 20)
    private String apartmentOffice;
    private String porch;
    private String floor;

}
