package br.com.spolador.apimed.services;

import br.com.spolador.apimed.domain.entidades.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}") // garante a leitura pelo application.properties
    private String secret;

    public String gerarToken(Usuario usuario){
//        System.out.println(secret); // para validar via console a leitura da chave secret
        try{
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Voll.med") // quem está gerando o token
                    .withSubject(usuario.getLogin()) // proprietario do token
                    .withClaim("id ", usuario.getId()) // coletar o id do usuário
                    .withExpiresAt(dataExpiracao()) // limite de tempo para o token expirar -> 2h
                    .sign((algoritmo));
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar o token JWT ", exception);
        }
    }

    public String getSubject(String tokenJWT){ // passa um token JWT, verifica se o token esta válido e devolve o usuário(subject)
        try{
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API Voll.med")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado ", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")); // cria a data conforme fuso-horario de brasilia
    }
}
