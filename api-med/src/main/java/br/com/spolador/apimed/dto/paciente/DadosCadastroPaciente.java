package br.com.spolador.apimed.dto.paciente;

import br.com.spolador.apimed.dto.endereco.DadosEndereco;
import lombok.*;

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

    @NotNull @Valid
    private DadosEndereco endereco;
}
