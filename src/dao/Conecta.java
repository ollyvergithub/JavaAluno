
package dao;

import java.sql.*;

public class Conecta {
    
    public static Connection getConexao() {
        Connection con = null;
        String serverName = "localhost";
        String myDatabase = "aluno";
        String username = "root";
        String password = "";
        
        String driverName = "com.mysql.jdbc.Driver"; // Caminho para a classe driver
        String url = "jdbc:mysql://" + serverName + "/" + myDatabase; // endereco do servidor
        
        try {
            Class.forName(driverName);  //setando o driver para trabalhar
            con = DriverManager.getConnection(url, username, password); // Tento fazer a conexão
            
        } catch (ClassNotFoundException e) {
             System.out.println("Driver não encontrado " + e.toString());
             
        }catch(SQLException e){
            System.out.println("Erro ao conectar com o Banco de Dados " + e.toString());
        }
        
        return con;
        
    }
    
}
