package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    // criar missao
    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }
    //alterar missões
    public MissoesModel atualizarMissao(Long id, MissoesModel missao) {
        if (missoesRepository.existsById(id)) {
            return missoesRepository.save(missao);
        }
    return null;
    }

    //exibir missão por id
    public MissoesModel buscarPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }
    //deletar missões
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}
