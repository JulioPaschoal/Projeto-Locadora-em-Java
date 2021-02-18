package persistencia;

import Entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author JULIO PASCHOAL
 */
public class CategoriaDAO {

    // MEDOTO PARA INSERIR NO BANCO DE DADOS \\
    public static boolean inserir(Categoria categoria) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO categoria (nome, tipo) "
                    + "VALUES (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setString(2, String.valueOf(categoria.getTipo()));
            comando.execute();
            comando.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}