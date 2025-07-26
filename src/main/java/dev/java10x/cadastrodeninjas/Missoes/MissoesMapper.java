package dev.java10x.cadastrodeninjas.Missoes;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setListaDeNinjas(missoesDTO.getNinjas());
        missoesModel.setId(missoesDTO.getId());
        return missoesModel;
    }
    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setListaDeNinjas(missoesModel.getNinjas());
        missoesDTO.setId(missoesModel.getId());

        return missoesDTO;
    }
}
