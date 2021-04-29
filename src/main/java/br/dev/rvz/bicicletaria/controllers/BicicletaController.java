package br.dev.rvz.bicicletaria.controllers;

import br.dev.rvz.bicicletaria.domain.Bicicleta;
import br.dev.rvz.bicicletaria.dtos.bicicleta.entrada.CadastroBicicletaDTO;
import br.dev.rvz.bicicletaria.services.BicicletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bicicletas/")
public class BicicletaController {

    @Autowired
    private BicicletaService bicicletaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bicicleta gravarNovaBicicleta(@RequestBody CadastroBicicletaDTO cadastroBicicletaDTO) {
        return bicicletaService.gravarBicicleta(
                cadastroBicicletaDTO.converterDtoParaModelo()
        );
    }
}
