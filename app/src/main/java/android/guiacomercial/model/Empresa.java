package android.guiacomercial.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empresa extends EntidadeBase {

    private Integer nota;

    private String nome;

    private String descricao;

    public Empresa() {

    }

    public Empresa(String nome, String descricao) {
        this.nota = 0;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "[ " + nome + " " + descricao + " " + nota + " ]";
    }
}
