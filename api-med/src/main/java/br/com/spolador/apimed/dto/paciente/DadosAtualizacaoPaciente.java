package br.com.spolador.apimed.dto.paciente;

import br.com.spolador.apimed.dto.endereco.DadosEndereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosAtualizacaoPaciente {
    @NotNull
    private Long id;
    private String nome;
    private String telefone;
    @Valid
    private DadosEndereco endereco;
}
