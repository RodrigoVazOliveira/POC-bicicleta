package br.dev.rvz.bicicletaria.dtos.bicicleta.entrada;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CadastroBicicletaDTO {
    private String modelo;
    private String tipo;
    private Integer aro;
}