package med.voll.api.domain.paciente;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosCadastroPaciente {
        @NotBlank
        private String nome;

        @NotBlank @Email
        private String email;

        @NotBlank
        private String telefone;

        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        private String cpf;

        @NotNull
        @Valid
        private DadosEndereco endereco;
}
