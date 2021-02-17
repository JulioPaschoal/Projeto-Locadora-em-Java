package testes;

import entidades.Categoria;
import persistencia.CategoriaDAO;

/**
 *
 * @author JULIO PASCHOAL
 */
public class TesteCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setId(4);
        categoria.setNome("Terror");
        categoria.setTipo('F'); // F -> FILMES || J -> JOGO 
        
        CategoriaDAO.inserir(categoria);
      //  System.err.println(CategoriaDAO.alterar(categoria));
     //   System.err.println(CategoriaDAO.excluir(4));
    //      System.out.println(CategoriaDAO.listar()); 
    }
}
