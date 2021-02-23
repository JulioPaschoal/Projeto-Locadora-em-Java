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
        categoria.setNome("Terror");
        categoria.setTipo('F'); // F FILMES || J JOGOS
        
         //CategoriaDAO.inserir(categoria);
        // categoria.setId(14);
       //  System.out.println(CategoriaDAO.alterar(categoria));
      //  System.out.println(CategoriaDAO.exluir(13));
        
        //System.out.println(CategoriaDAO.listar());
    }
}
