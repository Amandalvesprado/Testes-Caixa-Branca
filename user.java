package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável por gerenciar a autenticação de usuários em um sistema.
 * Contém métodos para conectar ao banco de dados e verificar credenciais de login.
 */
public class User {

    /**
     * Variável para armazenar o nome do usuário autenticado.
     */
    public String nome = "";

    /**
     * Variável para armazenar o resultado da verificação do login.
     * É {@code true} se o login for bem-sucedido, caso contrário, {@code false}.
     */
    public boolean result = false;

    /**
     * Método responsável por estabelecer a conexão com o banco de dados.
     *
     * @return Um objeto {@link Connection} representando a conexão com o banco de dados.
     * Retorna {@code null} se a conexão falhar.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver do banco de dados.
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Erro ao conectar ao banco de dados.
        }
        return conn;
    }

    /**
     * Método que verifica as credenciais de login de um usuário.
     *
     * @param login O login fornecido pelo usuário.
     * @param senha A senha fornecida pelo usuário.
     * @return {@code true} se as credenciais forem válidas, caso contrário, {@code false}.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();

        // Construção da instrução SQL.
        sql += "select nome from usuarios";
        sql += " where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Erro ao executar a consulta.
        }
        return result;
    }
}
