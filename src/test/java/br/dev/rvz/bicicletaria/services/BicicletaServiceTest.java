package br.dev.rvz.bicicletaria.services;

import br.dev.rvz.bicicletaria.domain.Bicicleta;
import br.dev.rvz.bicicletaria.repositories.BicicletaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class BicicletaServiceTest {

    @MockBean
    private BicicletaRepository bicicletaRepository;

    @Autowired
    private BicicletaService bicicletaService;

    private Bicicleta bicicleta;

    @BeforeEach
    public void setup() {
        bicicleta = new Bicicleta(null, "Modelo x", "Tipo 1", 26);
    }

    @Test
    public void testarCadastroBicicleta() {
        Mockito.when(bicicletaRepository.save(Mockito.any(Bicicleta.class))).thenReturn(bicicleta);
        Bicicleta obj = bicicletaService.gravarBicicleta(bicicleta);
        Assertions.assertEquals(obj, bicicleta);
    }

    @Test
    public void testarCadastroBicicletaErrorException() {
        bicicleta.setModelo(null);
        bicicleta.setAro(null);
        Mockito.when(bicicletaRepository.save(Mockito.any(Bicicleta.class)));
        Assertions.assertThrows(RuntimeException.class, () -> {
            bicicletaService.gravarBicicleta(bicicleta);
        });
    }
}
