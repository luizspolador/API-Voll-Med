package med.voll.api.domain.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class DadosAutenticacao {
    private String login;
    private String senha;
}
