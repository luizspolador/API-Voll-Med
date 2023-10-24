package med.voll.api.domain.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.domain.endereco.Endereco;

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
