package com.advancedexchange.api.Bootstrap;

import com.advancedexchange.api.Entities.Token;
import com.advancedexchange.api.Services.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BootLoader implements ApplicationListener<ContextRefreshedEvent>{

    private Logger log = LogManager.getLogger(BootLoader.class);

    @Autowired
    private TokenService tokenService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        String[] tokenTickers = {"BTC", "ETH", "LINK", "VIDT","RLC"};

        for(int i = 0; i < tokenTickers.length ; i++){
            Token newToken = new Token(tokenTickers[i], (long) (1000000*(i+1)));
            tokenService.saveToken(newToken);
        }

    }

}


