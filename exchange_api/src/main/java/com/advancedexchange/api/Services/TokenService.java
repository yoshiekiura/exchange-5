package com.advancedexchange.api.Services;
import com.advancedexchange.api.Entities.Token;
import java.util.Optional;

public interface TokenService {

    Iterable<Token> listAllTokens();

    Token saveToken(Token token);

    void deleteTokenById(Integer id);

    Optional<Token> getTokenById(Integer id);

}
