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

    public Empresa(Integer nota, String nome, String descricao) {
        this.nota = nota;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "[ " + nome + " " + descricao + " " + nota + " ]";
    }
}
