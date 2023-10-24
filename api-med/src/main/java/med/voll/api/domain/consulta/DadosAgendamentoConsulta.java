package med.voll.api.domain.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.domain.medico.Especialidade;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosAgendamentoConsulta {
        private Long idMedico;

        @NotNull
        private Long idPaciente;

        @NotNull
        @Future // data deve estar no futuro
        private LocalDateTime data;

        private Especialidade especialidade;
}
