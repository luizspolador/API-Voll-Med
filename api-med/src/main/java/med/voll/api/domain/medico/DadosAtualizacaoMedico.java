package med.voll.api.domain.medico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosAtualizacaoMedico {
        @NotNull // apenas o id é obrigatório
        private Long id;
        private String nome;
        private String telefone;
        private DadosEndereco endereco;
}
