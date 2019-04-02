package com.advancedexchange.api.Services;

import com.advancedexchange.api.Entities.Token;

public interface TokenService {

    Iterable<Token> listAllTokens();

    Token saveToken(Token token);

}
