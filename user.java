import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    // Ponto 1: Início
    public Connection conectarBD() {
        Connection conn = null; // Ponto 2: Declaração da conexão
        try {
            // Ponto 3: Tenta conectar ao banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; 
            conn = DriverManager.getConnection(url); 
        } catch (Exception e) {
            // Ponto 4: Exceção de conexão
        }
        return conn; // Ponto 5: Retorna conexão (null ou válida)
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        String sql = ""; // Ponto 6: Declaração da query
        Connection conn = conectarBD(); // Ponto 7: Chama conectarBD()

        // Ponto 8: Montagem da query SQL
        sql += "SELECT nome FROM usuarios ";
        sql += "WHERE login = '" + login + "' ";
        sql += "AND senha = '" + senha + "'";

        try {
            // Ponto 9: Criação de Statement e execução da query
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql); 

            // Ponto 10: Verifica se a query retornou resultados
            if (rs.next()) {
                result = true; 
                nome = rs.getString("nome"); 
            }
        } catch (Exception e) {
            // Ponto 11: Tratamento de exceção
        }
        return result; // Ponto 12: Retorna o resultado
    }
}
