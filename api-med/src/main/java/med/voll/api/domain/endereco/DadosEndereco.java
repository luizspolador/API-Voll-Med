package med.voll.api.domain.endereco;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class DadosEndereco {
        @NotBlank
        private String logradouro;

        @NotBlank
        private String bairro;

        @NotBlank
        @Pattern(regexp = "\\d{8}") // 8 digitos
        private String cep;

        @NotBlank
        private String cidade;

        @NotBlank
        private String uf;

        //OPCIONAIS
        private String complemento;
        private String numero;

}
