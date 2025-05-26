package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    private NinjaService ninjaService;



    @GetMapping("/boasvindas")
    public String BoasVindas(){
        return "Boas vindas, essa é a minha primeira mensagem nessa rota";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id){
        return ninjaService.buscarNinja(id);
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinja(){
        return ninjaService.listarNinjas();
    }

    @PutMapping("/alterar")
    public String editarNinja(){
        return "Ninja editado com sucesso";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

}
