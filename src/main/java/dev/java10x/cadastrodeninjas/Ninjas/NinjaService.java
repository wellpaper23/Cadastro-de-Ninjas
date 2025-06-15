package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    public NinjaService() {
    }

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository NinjaRepository) {
        this.ninjaRepository = NinjaRepository;
    }

    public NinjaService(NinjaMapper ninjaMapper) {
        this.ninjaMapper = ninjaMapper;
    }

    NinjaMapper ninjaMapper =  new NinjaMapper();
    //criar ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
    NinjaModel ninja = ninjaMapper.map(ninjaDTO);
    ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }
    //listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }
    //listar um ninja por id
    public NinjaModel buscarNinja(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }
    //alterar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninja) {
        if(ninjaRepository.existsById(id)) {
            return ninjaRepository.save(ninja);
        }
        return null;
    }
    //deletar ninja
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

}
