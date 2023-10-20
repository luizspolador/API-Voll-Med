package br.com.spolador.apimed.entidades.paciente;

import br.com.spolador.apimed.dto.paciente.DadosAtualizacaoPaciente;
import br.com.spolador.apimed.dto.paciente.DadosCadastroPaciente;
import br.com.spolador.apimed.entidades.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "pacientes")
@Entity
@Getter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente){
        this.ativo = true;
        this.nome = dadosCadastroPaciente.getNome();
        this.email = dadosCadastroPaciente.getEmail();
        this.telefone = dadosCadastroPaciente.getTelefone();
        this.cpf = dadosCadastroPaciente.getCpf();
        this.endereco = new Endereco(dadosCadastroPaciente.getEndereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if(dados.getNome() != null){
            this.nome = dados.getNome();
        }
        if(dados.getTelefone() != null){
            this.telefone = dados.getTelefone();
        }
        if(dados.getEndereco() != null){
            endereco.atualizarInformacoes(dados.getEndereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
