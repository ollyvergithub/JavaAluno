
package dao;
import classes.Aluno;
import java.sql.*;

public class AlunoDao {
    
    public String gravaAluno(Aluno aluno) {
        
        String aluno_existente =  aluno.getRgm();
        Object obj = getAluno(aluno_existente);
        System.out.println("Ollyver " +  obj);
        String resp = "";
        
        if(obj == null){
            try {
                Connection con = Conecta.getConexao();
                String sql = "INSERT INTO dados (rgm, nome, nota1, nota2)";
                sql += "VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, aluno.getRgm());
                ps.setString(2, aluno.getNome());
                ps.setFloat(3, aluno.getNota1());
                ps.setFloat(4, aluno.getNota2());
                ps.execute();
                ps.close();
                con.close();
                resp = "OK";
            } catch (Exception e) {
                resp = e.toString();
            }
        }else {
            resp = "Aluno já existente. Tente novamente!!";
        }
        return resp;
    }
    
    public Aluno getAluno(String rgm) {
        
        Aluno aluno = new Aluno();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM dados WHERE rgm = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rgm);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            aluno.setNome(rs.getString("nome"));
            aluno.setRgm(rs.getString("rgm"));
            aluno.setNota1(rs.getFloat("nota1"));
            aluno.setNota2(rs.getFloat("nota2"));
        } else {
            aluno = null;
        }
        } catch (Exception e) {
            aluno = null;
        }
        return aluno;
    }
    
        public String deleteAluno(String rgm) {
        
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "DELETE FROM dados WHERE rgm="+rgm;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    public String alteraAluno(Aluno aluno) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "update dados SET nome = ?, nota1=?, nota2=? where rgm = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setFloat(2, aluno.getNota1());
            ps.setFloat(3, aluno.getNota2());
            ps.setFloat(3, aluno.getNota2());
            ps.setString(4, aluno.getRgm());
            ps.execute();
            ps.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
}
