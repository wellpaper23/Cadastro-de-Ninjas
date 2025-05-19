package dev.java10x.cadastrodeninjas.Missoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;


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
