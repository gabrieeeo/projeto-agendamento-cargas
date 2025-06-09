package me.gabrieeeo.agendamento.controller;

import me.gabrieeeo.agendamento.model.Fornecedor;
import me.gabrieeeo.agendamento.service.FornecedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<Fornecedor> cadastrar(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(fornecedorService.salvar(fornecedor));
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listar() {
        return ResponseEntity.ok(fornecedorService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = fornecedorService.deletarPorId(id);
        if (removido) {
            return ResponseEntity.noContent().build(); //204
        }else {
            return ResponseEntity.notFound().build(); //404
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor novoFornecedor) {
        Fornecedor atualizado = fornecedorService.atualizar(id, novoFornecedor);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build(); // 404 se não encontrar o fornecedor
        }
    }

}
