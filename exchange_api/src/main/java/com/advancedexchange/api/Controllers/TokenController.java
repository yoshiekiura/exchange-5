package com.advancedexchange.api.Controllers;

import com.advancedexchange.api.Entities.Token;
import com.advancedexchange.api.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/tokens")
    public List<Token> listTokens() {
        Iterable<Token> allTokens = tokenService.listAllTokens();
        List<Token> allTokenList = new ArrayList<>();
        allTokens.forEach(allTokenList::add);
        return allTokenList;
    }

    @GetMapping("/tokens/{id}")
    public Optional<Token> getToken(@PathVariable int id) {
        Optional<Token> token = tokenService.getTokenById(id);
        return token;
    }

    @DeleteMapping("/tokens/{id}")
    public void deleteToken(@PathVariable int id) {
        Optional<Token> token = tokenService.getTokenById(id);
        if(token.isPresent()) {
            tokenService.deleteTokenById(id);
        }
    }

    @PostMapping("/tokens")
    public ResponseEntity<Object> createToken(@RequestBody Token token) {
        Token savedToken = tokenService.saveToken(token);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedToken.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/tokens/{id}")
    public ResponseEntity<Object> updateToken(@RequestBody Token token, @PathVariable int id) {

        Optional<Token> tokenOptional = tokenService.getTokenById(id);

        if (!tokenOptional.isPresent())
            return ResponseEntity.notFound().build();

        token.setId(id);

        tokenService.saveToken(token);

        return ResponseEntity.noContent().build();
    }

}
