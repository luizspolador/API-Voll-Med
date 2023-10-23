package br.com.spolador.apimed.domain.dto.medico;

import br.com.spolador.apimed.domain.entidades.medico.Medico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosListagemMedico {
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
