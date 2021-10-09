package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
}