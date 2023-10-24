package med.voll.api.domain.medico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.domain.endereco.Endereco;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosDetalhamentoMedico {
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Especialidade especialidade;
    private Endereco endereco;

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
