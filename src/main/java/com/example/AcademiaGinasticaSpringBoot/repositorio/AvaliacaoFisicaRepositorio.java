
package com.example.AcademiaGinasticaSpringBoot.repositorio;

import com.example.AcademiaGinasticaSpringBoot.modelo.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFisicaRepositorio extends JpaRepository<AvaliacaoFisica, Long> {
    
    
    
}
