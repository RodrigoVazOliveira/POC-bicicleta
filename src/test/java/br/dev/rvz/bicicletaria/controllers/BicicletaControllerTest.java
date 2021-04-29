package br.dev.rvz.bicicletaria.controllers;


import br.dev.rvz.bicicletaria.domain.Bicicleta;
import br.dev.rvz.bicicletaria.dtos.bicicleta.entrada.CadastroBicicletaDTO;
import br.dev.rvz.bicicletaria.services.BicicletaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest
public class BicicletaControllerTest {

    @MockBean
    private BicicletaService bicicletaService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testarCadastrarBicicletaComSucesso() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CadastroBicicletaDTO cadastroBicicletaDTO = new CadastroBicicletaDTO("Modelo 1", "Tipo 1", 27);
        String json = objectMapper.writeValueAsString(cadastroBicicletaDTO);

        Bicicleta bicicleta = new Bicicleta(1L, "Modelo 1", "Tipo 1", 27);

        Mockito.when(bicicletaService.gravarBicicleta(Mockito.any(Bicicleta.class)))
                .thenReturn(bicicleta);

        String resultado = objectMapper.writeValueAsString(bicicleta);

        mockMvc.perform(
            MockMvcRequestBuilders.post("/bicicletas/")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(resultado));

    }
}
