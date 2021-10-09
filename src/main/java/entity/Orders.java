package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status",length = 20)
    private String status;

    @JoinColumn(name  = "orders_method")
    @ManyToOne
    private OrdersMetod ordersMetod;
    @JoinColumn(name = "payment_method")
    @ManyToOne
    private PaymentMethod paymentMethod;
    @JoinColumn(name = "address_id")
    @ManyToOne
    private Address address;
}
