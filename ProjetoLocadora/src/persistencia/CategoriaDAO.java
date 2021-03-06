package persistencia;

import entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JULIO PASCHOAL
 */
public class CategoriaDAO {

    // METODO PARA INSERIR CATEGORIAS NO BANCO DE DADOS \\
    public static boolean inserir(Categoria categoria) {
        try {
            Connection conn = Conexao.getConexao();
            String sql = "INSERT INTO categoria (nome, tipo) VALUES (?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setString(2, String.valueOf(categoria.getTipo()));
            comando.execute();
            comando.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // METODO PARA FAZER UPDATE NAS CATEGORIAS \\
    public static boolean alterar(Categoria categoria) {
        try {
            Connection conn = Conexao.getConexao();
            String sql = "UPDATE categoria SET "
                    + "nome = ?, "
                    + "tipo = ? "
                    + "WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setString(2, String.valueOf(categoria.getTipo()));
            comando.setInt(3, categoria.getId());

            int nrLinhas = comando.executeUpdate();

            comando.close();

            return nrLinhas > 0;
        } catch (Exception e) {
            return false;
        }
    }

    // METODO PARA EXCLUIR UMA CATEGORIAS \\
    public static boolean exluir(int id) {
        try {
            Connection conn = Conexao.getConexao();
            String sql = "DELETE FROM categoria WHERE id = ?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1, id);
            int nrLinhas = comando.executeUpdate();
            comando.close();
            return nrLinhas > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    // METODO PARA LISTA TODAS AS CATEGORIAS \\
    public static ArrayList<Categoria> listar() {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        try {
            Connection conn = Conexao.getConexao();
            String sql = "SELECT * FROM categoria";
            Statement comando = conn.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()) {
                Categoria c = new Categoria();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setTipo(resultado.getString("tipo").charAt(0));
                categorias.add(c);
            }
            resultado.close();
            comando.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categorias;
    }
}
