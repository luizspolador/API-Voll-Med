package br.com.spolador.apimed.domain.dto.paciente;

import br.com.spolador.apimed.domain.entidades.endereco.Endereco;
import br.com.spolador.apimed.domain.entidades.paciente.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosDetalhamentoPaciente {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
