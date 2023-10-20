package br.com.spolador.apimed.entidades.medico;

import br.com.spolador.apimed.dto.medico.DadosAtualizacaoMedico;
import br.com.spolador.apimed.dto.medico.DadosCadastroMedico;
import br.com.spolador.apimed.dto.medico.Especialidade;
import br.com.spolador.apimed.entidades.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id") // equals and hashcode gerados referente ao id
@Table(name = "medicos")
@Entity
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded // apesar de estar em uma classe separada, os campos de Endereco são considerados na tabela medicos
    private Endereco endereco;
    private boolean ativo;

    public Medico(DadosCadastroMedico dadosCadastroMedico){
        this.ativo = true;
        this.nome = dadosCadastroMedico.getNome();
        this.email = dadosCadastroMedico.getEmail();
        this.telefone = dadosCadastroMedico.getTelefone();
        this.crm = dadosCadastroMedico.getCrm();
        this.especialidade = dadosCadastroMedico.getEspecialidade();
        this.endereco = new Endereco(dadosCadastroMedico.getEndereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if(dados.getNome() != null){
            this.nome = dados.getNome();
        }
        if(dados.getTelefone() != null){
            this.telefone = dados.getTelefone();
        }
        if(dados.getEndereco() != null){
            this.endereco.atualizarInformacoes(dados.getEndereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
