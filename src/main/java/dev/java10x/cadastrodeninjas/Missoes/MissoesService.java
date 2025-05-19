package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<MissoesModel> buscarPorId(int id) {
        return missoesRepository.findAllById(id);
    }

    //criar missão


}
