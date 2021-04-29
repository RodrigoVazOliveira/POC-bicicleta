package br.dev.rvz.bicicletaria.services;

import br.dev.rvz.bicicletaria.repositories.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BicicletaService {

    @Autowired
    private BicicletaRepository bicicletaRepository;

    
}
