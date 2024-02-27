package com.example.demo.domain.product;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProductPutDTO(String id,
                                @NotBlank String name,
                                @NotNull Integer price_in_cents) {    //DTO

}
