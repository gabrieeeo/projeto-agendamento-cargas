package me.gabrieeeo.agendamento.service;

import me.gabrieeeo.agendamento.model.Fornecedor;
import me.gabrieeeo.agendamento.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public boolean deletarPorId(Long id) {
        if (fornecedorRepository.existsById(id)) {
            fornecedorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Fornecedor atualizar(Long id, Fornecedor novoFornecedor) {
        return fornecedorRepository.findById(id).map(fornecedor -> {
            fornecedor.setNome(novoFornecedor.getNome());
            fornecedor.setCnpj(novoFornecedor.getCnpj());
            return fornecedorRepository.save(fornecedor);
        }).orElse(null);
    }


}
