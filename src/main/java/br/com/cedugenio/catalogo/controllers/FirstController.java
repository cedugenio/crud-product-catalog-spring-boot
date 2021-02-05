package br.com.cedugenio.catalogo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @RequestMapping(method = RequestMethod.GET, path={"/welcome","/bemvindo"})
    public String welcome() {
        return "Welcome to SpringBoot";
    }

}
