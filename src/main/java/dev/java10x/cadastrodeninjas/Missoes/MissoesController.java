package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaService;
import org.hibernate.query.Page;
import org.springframework.data.jpa.support.PageableUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;
    MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;

    }


    //GET-- mandar uma Requisição para Listar as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {

        return missoesService.listarTodasAsMissoes();
    }
    //Listar Missao por ID
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorID(@PathVariable Long id) {
        return missoesService.buscarPorId(id);
    }

    //POST-- Mandar requisiçao para criar uma missão
    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }

    //PUT--  Mandar requisição para alterar uma missão
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissoes(@PathVariable Long id,@RequestBody MissoesModel missao) {
        return missoesService.atualizarMissao(id, missao);
    }

    //DELETE-- Mandar uma requisição para deletar uma missão
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoesPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }
}
