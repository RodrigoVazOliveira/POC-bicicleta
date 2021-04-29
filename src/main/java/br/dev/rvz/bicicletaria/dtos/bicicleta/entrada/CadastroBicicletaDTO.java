package br.dev.rvz.bicicletaria.dtos.bicicleta.entrada;

import br.dev.rvz.bicicletaria.domain.Bicicleta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CadastroBicicletaDTO {
    private String modelo;
    private String tipo;
    private Integer aro;

    public Bicicleta converterDtoParaModelo() {
        return new Bicicleta(
                null,
                this.modelo,
                this.tipo,
                this.aro
        );
    }
}