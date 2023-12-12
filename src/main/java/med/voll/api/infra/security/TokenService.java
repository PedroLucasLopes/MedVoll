package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import med.voll.api.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("{api.security.token.secret}")
    private String secret;
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm
                    .HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(user.getLogin())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error to generate a JWT Tokem", exception);
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm
                    .HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("API Voll.med")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);

            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT invalid or expired");
        }
    }

    public Instant expirationDate() {
        return LocalDateTime
                .now()
                .plusHours(2)
                .toInstant(ZoneOffset
                        .of("-03:00"));
    }
}
