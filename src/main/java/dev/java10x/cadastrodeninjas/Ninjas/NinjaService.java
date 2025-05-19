package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository NinjaRepository) {
        this.ninjaRepository = NinjaRepository;
    }


    //criar ninja

    //listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }
    //listar um ninja por id
    public List<NinjaModel> buscarNinja(int id) {
        return ninjaRepository.findAllById(id);
    }
    //alterar ninja

    //deletar ninja

}
