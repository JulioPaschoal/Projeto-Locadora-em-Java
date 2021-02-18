
package Entidades;

/**
 *
 * @author JULIO PASCHOAL
 */
public class Jogo extends Item{
    private int memoria;
    private String Tipo;

    public Jogo(Categoria categoria) {
        super(categoria);
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
}
