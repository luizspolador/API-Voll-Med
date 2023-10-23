package br.com.spolador.apimed.domain.dto.paciente;

import br.com.spolador.apimed.domain.entidades.paciente.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosListagemPaciente {
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
