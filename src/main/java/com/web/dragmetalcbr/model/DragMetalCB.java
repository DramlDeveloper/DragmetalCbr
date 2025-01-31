package com.web.dragmetalcbr.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "metal_rate")
public class DragMetalCB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "update_at")
    private LocalDateTime date;
    @Column(name = "code")
    private int code;
    @Column(name = "buying_rate")
    private BigDecimal buy;
    @Column(name = "selling_rate")
    private BigDecimal sell;

}
