package com.example.demo.domain.product.product;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "product")
@Entity(name = "product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;
    private Boolean active;

    public Product(RequestProductDTO requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
        this.active = true;
    }
}
