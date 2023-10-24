package med.voll.api.domain.medico;

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
public class DadosCadastroMedico {
        @NotBlank // não pode ser vazio nem nulo. Usado somente para String
        private String nome;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String telefone;

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // são de 4-6 dígitos
        private String crm;

        @NotNull
        private Especialidade especialidade;

        @NotNull
        @Valid // para que DadosEndereco tmb faça validações do BeanValidation
        private DadosEndereco endereco;
}
