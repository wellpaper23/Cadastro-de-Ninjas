package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.data.jpa.support.PageableUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    //GET-- mandar uma Requisição para Listar as missões
    @GetMapping("/listar")
    public String listarMissoes() {
        return "Lista de missoes";
    }

    //POST-- Mandar requisiçao para criar uma missão
    @PostMapping("/criar")
    public String criarMissoes(){
        return "Criado com sucesso!";
    }

    //PUT--  Mandar requisição para alterar uma missão
    @PutMapping("/alterar")
    public String alterarMissoes(){
        return "Alterado com sucesso!";
    }

    //DELETE-- Mandar uma requisição para deletar uma missão
    @DeleteMapping("/deletar")
    public String deletarMissoes(){
        return "Deletado com sucesso!";
    }
}
