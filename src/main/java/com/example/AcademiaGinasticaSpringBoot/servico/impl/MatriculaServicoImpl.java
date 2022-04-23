package com.example.AcademiaGinasticaSpringBoot.servico.impl;

import com.example.AcademiaGinasticaSpringBoot.modelo.Aluno;
import com.example.AcademiaGinasticaSpringBoot.modelo.Matricula;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.MatriculaForm;
import com.example.AcademiaGinasticaSpringBoot.repositorio.AlunoRepositorio;
import com.example.AcademiaGinasticaSpringBoot.repositorio.MatriculaRepositorio;
import com.example.AcademiaGinasticaSpringBoot.servico.MatriculaServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServicoImpl implements MatriculaServico {

    @Autowired
    private MatriculaRepositorio matriculaRepository;

    @Autowired
    private AlunoRepositorio alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {

        if (bairro == null) {
            return matriculaRepository.findAll();
        } else {
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {
    }

}
