package br.com.spolador.apimed.domain.entidades.endereco;

import br.com.spolador.apimed.domain.dto.endereco.DadosEndereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dadosEndereco){
        this.logradouro = dadosEndereco.getLogradouro();
        this.bairro = dadosEndereco.getBairro();
        this.cep = dadosEndereco.getCep();
        this.uf = dadosEndereco.getUf();
        this.cidade = dadosEndereco.getCidade();
        this.numero = dadosEndereco.getNumero();
        this.complemento = dadosEndereco.getComplemento();
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        if(dadosEndereco.getLogradouro() != null){
            this.logradouro = dadosEndereco.getLogradouro();
        }
        if(dadosEndereco.getBairro() != null){
            this.bairro = dadosEndereco.getBairro();
        }
        if(dadosEndereco.getCep() != null){
            this.cep = dadosEndereco.getCep();
        }
        if(dadosEndereco.getUf() != null){
            this.uf = dadosEndereco.getUf();
        }
        if(dadosEndereco.getCidade() != null){
            this.cidade = dadosEndereco.getCidade();
        }
        if(dadosEndereco.getNumero() != null){
            this.numero = dadosEndereco.getNumero();
        }
        if(dadosEndereco.getComplemento() != null){
            this.complemento = dadosEndereco.getComplemento();
        }
    }
}
