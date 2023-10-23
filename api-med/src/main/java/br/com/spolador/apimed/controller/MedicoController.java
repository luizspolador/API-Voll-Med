package br.com.spolador.apimed.controller;

import br.com.spolador.apimed.domain.dto.medico.DadosAtualizacaoMedico;
import br.com.spolador.apimed.domain.dto.medico.DadosCadastroMedico;
import br.com.spolador.apimed.domain.dto.medico.DadosDetalhamentoMedico;
import br.com.spolador.apimed.domain.dto.medico.DadosListagemMedico;
import br.com.spolador.apimed.domain.entidades.medico.Medico;
import br.com.spolador.apimed.domain.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // injeção de dependencias
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarMedicos(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico((dados));
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico)); // devolve 201
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){ // padrão caso o parametro não seja passado na url.
        // nesse caso, o padrão é tamanho = 10 e ordenação por nome
        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new); // conversão de Medico para DadosListagemMedico
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = medicoRepository.getReferenceById(dados.getId());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }


    //exclusão lógica
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build(); // deve devolver um 204
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharMedicoPeloId(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

}
