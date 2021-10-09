package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "ser_name", length = 20)
    private String serName;
    private Integer phone;
    @JoinColumn(name = "address_id")
    @OneToOne
    private Address address;
}
