package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
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

    @GetMapping("/listarid")
    public String listarNinjaPorId(){
        return "Ninja encontrado por ID";
    }

    @GetMapping("/listar")
    public String listarNinja(){
        return "Mostrando todos os Ninjas";
    }

    @PutMapping("/alterar")
    public String editarNinja(){
        return "Ninja editado com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarNinja(){
        return "Ninja deletado com sucesso";
    }

}
