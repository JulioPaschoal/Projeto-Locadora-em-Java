
package Entidades;

/**
 *
 * @author JULIO PASCHOAL
 */
public class Filme extends Item{
    private String diretor;
    private String duracao;

    public Filme(Categoria categoria) {
        super(categoria);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
