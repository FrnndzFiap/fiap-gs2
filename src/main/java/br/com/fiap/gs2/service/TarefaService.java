package br.com.fiap.gs2.service;

import br.com.fiap.gs2.model.Tarefa;
import br.com.fiap.gs2.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefarepository;

    public List<Tarefa> list() {
        return tarefarepository.findAll();
    }

    public Tarefa save(Tarefa tarefa) {
        return tarefarepository.save(tarefa);
    }

    public boolean existsById(Long id) {
        return tarefarepository.existsById(id);
    }

    public void delete(Long id) {
        tarefarepository.deleteById(id);
    }

    public Optional<Tarefa> findById(Long id) {
        return tarefarepository.findById(id);
    }

    public Optional<Tarefa> findByNome(String nome) {
        return tarefarepository.findByNome(nome);
    }
}
