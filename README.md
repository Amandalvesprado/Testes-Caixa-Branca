# Testes-Caixa-Branca
Atividade sobre Testes Caixa Branca da Disciplina UI/UX E Testes de Software 2024/2


*ETAPA 1*

Erros encontrados: 

**1. SQL**
Construir a query SQL usando concatenação e não ela realizar ela de uma vez só utilizando o PreparedStatement para evitar SQL Injection (ameaça de segurança que se aproveita de vulnerabilidades em sistemas que trabalham com bases de dados realizando ataques com comandos SQL)
Como está: 
     "sql += "select nome from usuarios"; 
              sql += "where login =  " + " ' "  + login + " ' "; 
              sql += " and senha = " + " ' "  + senha+ " ' ;"; "
Como poderia ser: 
String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";
PreparedStatement pst = conn.prepareStatement(sql);
pst.setString(1, login);
pst.setString(2, senha);

**2.Classe Driver Errada**
A linha onde se é declara a classe driver está incorreta, se o codigo for rodado com a linha 'class.forName("com.mysql.Driver.Manager").newInstance();' acontecerá um erro de execução. 
Como poderia ser: 
    Class.forName("com.mysql.cj.jdbc.Driver");

**3.Tratamentos de Exceções**
Na linha 32, o código captura exceções mas não fornece as informações necessarias, duficultado a depuração 
Como está:
     catch (Exception e) { }
Como poderia ser: 
     catch (Exception e) {
        e.printStackTrace();
}

**4.Conexões não Fechadas**
No codigo não é realizada o fechamendo das conexões Connection, Statement e ResultSet. Oque pode causar vazamento de recursos e prejudicar o desempenho do sistema.




