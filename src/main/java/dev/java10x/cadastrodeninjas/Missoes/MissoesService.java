package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper  missoesMapper;

    public MissoesService() {
    }

    public MissoesService(MissoesRepository MissoesRepository) {
        this.missoesRepository = MissoesRepository;
    }

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    //listar missões
    public List<MissoesDTO> listarTodasAsMissoes() {
    List<MissoesModel> missoes = missoesRepository.findAll();
    return  missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }
    // criar missao
    public MissoesDTO criarMissao(MissoesDTO novaMissao) {
        MissoesModel missoesModel = missoesMapper.map(novaMissao);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }
    //alterar missões
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missao) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missao);
            missaoAtualizada.setId(id);
            missaoAtualizada = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoAtualizada);
        }
    return null;
    }

    //exibir missão por id
    public MissoesDTO buscarPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);

    }
    //deletar missões
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}
