package med.voll.api.domain.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.domain.endereco.DadosEndereco;

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
