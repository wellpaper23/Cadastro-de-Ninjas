package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }




    @GetMapping("/boasvindas")
    public String BoasVindas(){
        return "Boas vindas, essa é a minha primeira mensagem nessa rota";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
          ninjaService.criarNinja(ninja);
         return ResponseEntity.status(HttpStatus.CREATED).body("Ninja com criada com sucesso! \n Nome: "+ninja.getNome()+" (ID): "+ninja.getId());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.buscarNinja(id);
        if (ninja != null){
            return ResponseEntity.status(HttpStatus.OK).body(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: "+id+"não encontrado em nossos registros");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinja(){
        List<NinjaDTO> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK).body(listaDeNinjas);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> editarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        if (ninjaService.buscarNinja(id) != null){
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body("Ninja com (ID): " + id + "deletada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado um ninja com ID "+id+" em nossos registros");        }
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.buscarNinja(id) != null) {
            String nome = ninjaService.buscarNinja(id).getNome();
            ;
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ninja " + nome + "com (ID): " + id + "deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado um ninja com ID " + id + " em nossos registros");
        }
    }
}
