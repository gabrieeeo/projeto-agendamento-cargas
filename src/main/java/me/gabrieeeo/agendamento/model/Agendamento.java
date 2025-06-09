package me.gabrieeeo.agendamento.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Fornecedor fornecedor;

    private String pedido;
    private String material;
    private Integer quantidade;
    private LocalDate data;
    private String volume;
    private String observacoes;
}
