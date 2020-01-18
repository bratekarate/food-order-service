package com.jtl.microscape.orderservice.core.restaurant;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor
@Data
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

}
