package com.example.AcademiaGinasticaSpringBoot.servico.impl;

import com.example.AcademiaGinasticaSpringBoot.infra.utils.JavaTimeUtils;
import com.example.AcademiaGinasticaSpringBoot.modelo.Aluno;
import com.example.AcademiaGinasticaSpringBoot.modelo.AvaliacaoFisica;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.AlunoForm;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.AlunoUpdateForm;
import com.example.AcademiaGinasticaSpringBoot.repositorio.AlunoRepositorio;
import com.example.AcademiaGinasticaSpringBoot.servico.AlunoServico;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServicoImpl implements AlunoServico {

    @Autowired
    private AlunoRepositorio repository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {

        if (dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

        Aluno aluno = repository.findById(id).get();

        return aluno.getAvaliacoes();

    }

}
