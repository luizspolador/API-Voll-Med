package med.voll.api.domain.paciente;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

import javax.persistence.*;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;

    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.getNome();
        this.email = dados.getEmail();
        this.telefone = dados.getTelefone();
        this.cpf = dados.getCpf();
        this.endereco = new Endereco(dados.getEndereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.getNome() != null) {
            this.nome = dados.getNome();
        }
        if (dados.getTelefone() != null) {
            this.telefone = dados.getTelefone();
        }
        if (dados.getEndereco() != null) {
            this.endereco.atualizarInformacoes(dados.getEndereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
