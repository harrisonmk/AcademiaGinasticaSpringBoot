package com.example.AcademiaGinasticaSpringBoot.servico.impl;

import com.example.AcademiaGinasticaSpringBoot.modelo.Aluno;
import com.example.AcademiaGinasticaSpringBoot.modelo.AvaliacaoFisica;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.AvaliacaoFisicaForm;
import com.example.AcademiaGinasticaSpringBoot.modelo.form.AvaliacaoFisicaUpdateForm;
import com.example.AcademiaGinasticaSpringBoot.repositorio.AlunoRepositorio;
import com.example.AcademiaGinasticaSpringBoot.repositorio.AvaliacaoFisicaRepositorio;
import com.example.AcademiaGinasticaSpringBoot.servico.AvaliacaoFisicaServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoFisicaServicoImpl implements AvaliacaoFisicaServico {

    @Autowired
    private AvaliacaoFisicaRepositorio avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepositorio alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {

        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
