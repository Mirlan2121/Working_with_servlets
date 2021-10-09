package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders_method")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrdersMetod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "method", length = 10)
    private String method;
}
