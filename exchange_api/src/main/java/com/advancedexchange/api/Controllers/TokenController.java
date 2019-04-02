package com.advancedexchange.api.Controllers;

import com.advancedexchange.api.Entities.Token;
import com.advancedexchange.api.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/showtokens")
    public List<Token> token() {
        Iterable<Token> allTokens = tokenService.listAllTokens();
        List<Token> allTokenList = new ArrayList<>();
        allTokens.forEach(allTokenList::add);
        return allTokenList;
    }

}
