package br.com.spolador.apimed.controller;

import br.com.spolador.apimed.dto.paciente.DadosAtualizacaoPaciente;
import br.com.spolador.apimed.dto.paciente.DadosCadastroPaciente;
import br.com.spolador.apimed.dto.paciente.DadosListagemPaciente;
import br.com.spolador.apimed.entidades.paciente.Paciente;
import br.com.spolador.apimed.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired // injeção de dependencias
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrarPacientes(@RequestBody @Valid DadosCadastroPaciente dados){
        pacienteRepository.save(new Paciente(dados)); // recebe um dto e converte para Paciente
    }

    @GetMapping
    public Page<DadosListagemPaciente> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.getId());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.inativar();
    }
}
