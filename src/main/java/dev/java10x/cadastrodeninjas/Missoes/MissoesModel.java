package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;
    //
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

//construtores
    public MissoesModel() {
    }
    public MissoesModel(String nome, String dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }
//getters e setters
    public String getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }
    public void addNinja(NinjaModel Ninja) {
        this.ninjas.add(Ninja);
    }
    public void removeNinja(NinjaModel Ninja) {
    this.ninjas.remove(Ninja);
    }
    public void setListaDeNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }

}
