package med.voll.api.domain.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.getLogradouro();
        this.bairro = dados.getBairro();
        this.cep = dados.getCep();
        this.uf = dados.getUf();
        this.cidade = dados.getCidade();
        this.numero = dados.getNumero();
        this.complemento = dados.getComplemento();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.getLogradouro() != null) {
            this.logradouro = dados.getLogradouro();
        }
        if (dados.getBairro() != null) {
            this.bairro = dados.getBairro();
        }
        if (dados.getCep() != null) {
            this.cep = dados.getCep();
        }
        if (dados.getUf() != null) {
            this.uf = dados.getUf();
        }
        if (dados.getCidade() != null) {
            this.cidade = dados.getCidade();
        }
        if (dados.getNumero() != null) {
            this.numero = dados.getNumero();
        }
        if (dados.getComplemento() != null) {
            this.complemento = dados.getComplemento();
        }
    }
}
