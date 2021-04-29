package br.dev.rvz.bicicletaria.services;

import br.dev.rvz.bicicletaria.domain.Bicicleta;
import br.dev.rvz.bicicletaria.repositories.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BicicletaService {

    @Autowired
    private BicicletaRepository bicicletaRepository;


    public Bicicleta gravarBicicleta(Bicicleta bicicleta) {
        try {
            return bicicletaRepository.save(bicicleta);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
