package me.gabrieeeo.agendamento.controller;

import me.gabrieeeo.agendamento.model.Agendamento;
import me.gabrieeeo.agendamento.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<Agendamento> cadastrar(@RequestBody Agendamento agendamento) {
        return ResponseEntity.ok(agendamentoService.salvar(agendamento));
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listar () {
        return ResponseEntity.ok(agendamentoService.listarTodos());
    }

}
