package br.dev.rvz.bicicletaria.repositories;

import br.dev.rvz.bicicletaria.domain.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
}
