package com.example.demo.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    //os metodos default sao implementados em runtime
    //se quisermos queries mais complexas, codarr

    List<Product> findAllByActiveTrue();    //JPA implementa em runtime

}
