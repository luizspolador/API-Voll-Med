package br.com.spolador.apimed.controller;

import br.com.spolador.apimed.dto.medico.DadosAtualizacaoMedico;
import br.com.spolador.apimed.dto.medico.DadosCadastroMedico;
import br.com.spolador.apimed.dto.medico.DadosListagemMedico;
import br.com.spolador.apimed.entidades.medico.Medico;
import br.com.spolador.apimed.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // injeção de dependencias
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrarMedicos(@RequestBody @Valid DadosCadastroMedico dados){
        medicoRepository.save(new Medico(dados)); // recebe um dto e converte para Medico
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){ // padrão caso o parametro não seja passado na url.
        // nesse caso, o padrão é tamanho = 10 e ordenação por nome
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new); // conversão de Medico para DadosListagemMedico
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = medicoRepository.getReferenceById(dados.getId());
        medico.atualizarInformacoes(dados);
    }

    //EXCLUIR DO DB
//    @DeleteMapping("{id}")
//    @Transactional
//    public void excluirMedicoDoDB(@PathVariable Long id){
//        medicoRepository.deleteById(id);
//    }

    //exclusão lógica
    @DeleteMapping("{id}")
    @Transactional
    public void excluirMedicoDoDB(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id); // recupera o medico do db
        medico.excluir(); // inativa o medico
    }

}
