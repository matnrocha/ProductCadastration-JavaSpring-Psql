package com.example.demo.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    //os metodos default sao implementados em runtime
    //se quisermos queries mais complexas, codarr

}
