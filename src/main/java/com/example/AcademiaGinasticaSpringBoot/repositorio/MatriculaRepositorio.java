package com.example.AcademiaGinasticaSpringBoot.repositorio;

import com.example.AcademiaGinasticaSpringBoot.modelo.Matricula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatriculaRepositorio extends JpaRepository<Matricula, Long> {

    /**
     *
     * @param bairro bairro referência para o filtro
     * @return lista de alunos matriculados que residem no bairro passado como
     * parâmetro
     */
    //jeito com o jpql
    @Query(value = "SELECT * FROM tb_matriculas m "
            + "INNER JOIN tb_alunos a ON m.aluno_id = a.id "
            + "WHERE a.bairro = :bairro", nativeQuery = true)
    //@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
    List<Matricula> findAlunosMatriculadosBairro(String bairro);

    
    //jeito sem o jpql
    //List<Matricula> findByAlunoBairro(String bairro);   
}
