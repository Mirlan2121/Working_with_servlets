package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrdersItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "product_id")
    @OneToOne
    private Product product;

    private Integer productCount;

    @JoinColumn(name = "orders_id")
    @OneToOne
    private Orders orders;
}
