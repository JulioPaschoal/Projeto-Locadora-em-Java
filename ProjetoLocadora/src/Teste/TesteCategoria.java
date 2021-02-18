
package teste;

import Entidades.Categoria;
import persistencia.CategoriaDAO;

/**
 *
 * @author JULIO PASCHOAL
 */
public class TesteCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNome("Ação");
        categoria.setTipo('F');//F - FILME || J - JOGO
        
        
        CategoriaDAO.inserir(categoria);
   }
}
