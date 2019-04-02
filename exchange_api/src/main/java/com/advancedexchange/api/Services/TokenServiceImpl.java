package com.advancedexchange.api.Services;

import com.advancedexchange.api.Entities.Token;
import com.advancedexchange.api.Repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TokenServiceImpl implements TokenService{

    private TokenRepository tokenRepository;

    @Autowired
    public void setTokenRepository(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Iterable<Token> listAllTokens() {
        return tokenRepository.findAll();
    }

    @Override
    public Token saveToken(Token token) {
        return tokenRepository.save(token);
    }

}
