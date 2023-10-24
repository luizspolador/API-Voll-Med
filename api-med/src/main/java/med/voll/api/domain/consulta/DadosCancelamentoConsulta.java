package med.voll.api.domain.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosCancelamentoConsulta {
        @NotNull
        private Long idConsulta;

        @NotNull
        private MotivoCancelamento motivo;
}
