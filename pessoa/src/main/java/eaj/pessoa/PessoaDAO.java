package eaj.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public void excluirPessoa(Pessoa p){
        Connection connection = null;
        PreparedStatement stmt = null;
    
        try{
            connection = Conexao.getConnection();
            stmt = connection.prepareStatement(
                "DELETE FROM pessoa WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();
            connection.close();
        }catch(Exception e){

        }

    }

    public void alterarPessoa(Pessoa p){
        Connection connection = null;
        PreparedStatement stmt = null;
        try{
            connection = Conexao.getConnection();
            stmt = connection.prepareStatement(
                "UPDATE pessoa SET nome = ?, idade = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setInt(3, p.getId());

            stmt.executeUpdate();
            connection.close();
        }catch(Exception e){

        }

    }

    public void cadastrarPessoa(Pessoa p){
        Connection connection = null;
        PreparedStatement stmt = null;
        try{
            connection = Conexao.getConnection();
            stmt = connection.prepareStatement(
                "insert into pessoa(nome, idade) values(?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdade());

            stmt.executeUpdate();
            connection.close();
        }catch(Exception e){

        }

    }

    public Pessoa getPessoaById(int id){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa p = null;

        try {
            connection = Conexao.getConnection();

            stmt = connection.prepareStatement("select * from pessoa where id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                p = new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"));
                //p.setIdade(rs.getInt("idade"));
                //p.setNome(rs.getString("nome"));
            }
            connection.close();

        } catch (Exception ex) {
            // response.getWriter().append("Connection Failed! Check output console");
        }
        
        return p;
    }

    public List<Pessoa> listarPessoas(){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pessoa> listarPessoas = new ArrayList<>();

        try{
            connection = Conexao.getConnection();
            stmt = connection.prepareStatement("select * from pessoa");
            rs = stmt.executeQuery();
            while(rs.next()){
                Pessoa p = new Pessoa(rs.getInt("id"),rs.getString("nome"), rs.getInt("idade"));
                listarPessoas.add(p);
            }


        }catch(Exception e){

        }
        return listarPessoas;
    }
}
