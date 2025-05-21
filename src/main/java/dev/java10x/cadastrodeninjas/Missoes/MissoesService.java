package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository MissoesRepository) {
        this.missoesRepository = MissoesRepository;
    }

    //listar missões
    public List<MissoesModel> listarTodasAsMissoes() {
        return missoesRepository.findAll();
    }

    //alterar missões

    //deletar missões

    //exibir missão por id
    public MissoesModel buscarPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    //criar missão


}
