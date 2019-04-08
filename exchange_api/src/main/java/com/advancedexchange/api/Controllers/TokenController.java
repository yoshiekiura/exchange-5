package com.advancedexchange.api.Controllers;

import com.advancedexchange.api.Entities.Token;
import com.advancedexchange.api.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/")
    public String helloWorld() {
        return "Hi this is the back end app, use the /token to show the list of tokens as json";
    }

    @GetMapping("/tokens")
    public List<Token> listTokens() {
        Iterable<Token> allTokens = tokenService.listAllTokens();
        List<Token> allTokenList = new ArrayList<>();
        allTokens.forEach(allTokenList::add);
        return allTokenList;
    }

    @Cacheable(value = "tokens", key = "#id")
    @GetMapping("/tokens/{id}")
    public Token getToken(@PathVariable int id) {
        Optional<Token> token = tokenService.getTokenById(id);
        if(token.isPresent()) {
            return token.get();
        }
        return new Token();
    }

    @CacheEvict(value = "tokens", allEntries=true)
    @DeleteMapping("/tokens/{id}")
    public void deleteToken(@PathVariable int id) {
        Optional<Token> token = tokenService.getTokenById(id);
        if(token.isPresent()) {
            tokenService.deleteTokenById(id);
        }
    }

    @PostMapping("/tokens")
    public Token createToken(@RequestBody Token token) {
        Token savedToken = tokenService.saveToken(token);
        return savedToken;
    }


    @CachePut(value = "tokens")
    @PutMapping("/tokens/{id}")
    public Token updateToken(@RequestBody Token token, @PathVariable int id) {
        Token newToken = tokenService.getTokenById(id).isPresent() ? tokenService.getTokenById(id).get() : new Token();
        newToken.setTicker(token.getTicker());
        newToken.setSupply(token.getSupply());
        return tokenService.saveToken(newToken);
    }

}
