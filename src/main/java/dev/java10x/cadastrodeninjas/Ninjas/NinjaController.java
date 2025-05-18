package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String BoasVindas(){
        return "Boas vindas, essa é a minha primeira mensagem nessa rota";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado com sucesso";
    }

    @GetMapping("/mostrarID")
    public String mostrarNinjaPorId(){
        return "Ninja encontrado";
    }

    @GetMapping("/todosID")
    public String mostrarNinja(){
        return "Mostrando todos os Ninjas com ID";
    }

    @PutMapping("/editarID")
    public String editarNinja(){
        return "Ninja editado com sucesso";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinja(){
        return "Ninja deletado com sucesso";
    }

}
