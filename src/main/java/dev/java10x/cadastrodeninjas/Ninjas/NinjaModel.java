package dev.java10x.cadastrodeninjas.Ninjas;
import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "missoes_ID")
    private MissoesModel missoes;

    //construtores
    public NinjaModel() {
    }
    public NinjaModel(int idade, String email, String nome) {
        this.idade = idade;
        this.email = email;
        this.nome = nome;
    }
    public NinjaModel(String nome, String email, int idade, MissoesModel missoes) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.missoes = missoes;
    }
    //getters e setters missoes
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }
    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }
}
