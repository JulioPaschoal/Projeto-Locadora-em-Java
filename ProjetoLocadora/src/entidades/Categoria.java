package entidades;

/**
 *
 * @author JULIO PASCHOAL
 */
public class Categoria {

    private int id;
    private String nome;
    private char tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getNomeTipo() {
        return tipo == 'F' ? "Filme" : "Jogo";
    }

    @Override
    public String toString() {
        return "Categoria"
                + "\n" + "id= " + id
                + "\n" + "nome= " + nome
                + "\n" + "tipo= " + tipo;
    }

}
