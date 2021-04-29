package br.dev.rvz.bicicletaria.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BicicletaServiceTest {

    @MockBean
    private BicicletaRepository bicicletaRepository;

    @Autowired
    private BicicletaService bicicletaService;

    private Bicicleta bicicleta;

    @BeforeEach
    public void setup() {
        bicicleta = new Bicicleta("Modelo x", "Tipo 1", 26);
    }

    @Test   
    public void testarCadastroBicicleta() {
        Mockito.when(bicicletaRepository.save(Mockito.any(Bicicleta.class))).thenReturn(bicicleta);
        Bicicleta obj = bicicletaService.gravarBicicleta(bicicleta);
        Assertions.assertEquals(obj, bicicleta);
    }
}
