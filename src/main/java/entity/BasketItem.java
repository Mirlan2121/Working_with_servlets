package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "basket_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productId;
    private Integer productCount;
    @JoinColumn(name = "basket_id")
    @ManyToOne
    private Basket basket;
}
