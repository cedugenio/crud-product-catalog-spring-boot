package br.com.cedugenio.catalogo.controllers;

import br.com.cedugenio.catalogo.model.entities.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    @GetMapping(path = "/all")
    public Client getClient(){
        return new Client(1, "Ana Beatriz","123.456.789-06");
    }

    @GetMapping("/{id}")

    public Client getClientWithId(@PathVariable int id) {
        return new Client(id, "Luciana","233.446.654-32");
    }
    @GetMapping
    public Client getClientWithIdOther(
            @RequestParam(name = "id", defaultValue = "1") int id) {
        return new Client(id, "Carlos Eugenio","233.566.555-32");
    }
}
