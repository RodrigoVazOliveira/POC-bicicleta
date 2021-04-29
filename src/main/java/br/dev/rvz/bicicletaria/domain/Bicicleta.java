package br.dev.rvz.bicicletaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bicicletas")
@Data @AllArgsConstructor @NoArgsConstructor
public class Bicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String modelo;

    @Column(length = 80, nullable = false)
    private String tipo;

    @Column(length = 2, nullable = false)
    private Integer aro;
}
