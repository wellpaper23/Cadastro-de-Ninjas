package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaService;
import org.hibernate.query.Page;
import org.springframework.data.jpa.support.PageableUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissoesController {

    MissoesService missoesService;
    MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;

    }


    //GET-- mandar uma Requisição para Listar as missões
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> listaDeMissoes =  missoesService.listarTodasAsMissoes();
        return ResponseEntity.ok(listaDeMissoes);
    }
    //Listar Missao por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorID(@PathVariable Long id) {
        MissoesDTO missao = missoesService.buscarPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com ID: "+id+"não encontrado em nossos registros");
        }
    }

    //POST-- Mandar requisiçao para criar uma missão
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDTO missao) {
        missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão com criada com sucesso! \n Nome: "+missao.getNome()+" (ID): "+missao.getId());
    }

    //PUT--  Mandar requisição para alterar uma missão
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissoes(@PathVariable Long id,@RequestBody MissoesDTO missao) {
        if (missoesService.buscarPorId(id) != null){
            missoesService.atualizarMissao(id, missao);
            return ResponseEntity.status(HttpStatus.OK).body("Missão com (ID): " + id + "deletada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado um missão com ID "+id+" em nossos registros");        }
    }


    //DELETE-- Mandar uma requisição para deletar uma missão
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoesPorId(@PathVariable Long id) {
        if (missoesService.buscarPorId(id) != null) {
            String nome = missoesService.buscarPorId(id).getNome();

            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Missão "+ nome + " (ID): " + id + "deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado uma missão com ID " + id + " em nossos registros");
        }
    }
}
