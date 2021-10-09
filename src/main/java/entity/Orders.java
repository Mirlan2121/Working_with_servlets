package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany
    private List<OrdersMetod> ordersMetod;
    @JoinColumn(name = "payment_method")
    @OneToOne
    private PaymentMethod paymentMethod;
    @JoinColumn(name = "address_id")
    @OneToOne
    private Address address;
}
