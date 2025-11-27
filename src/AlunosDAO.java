
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunosDAO {
    // Inserir novos alunos

    public void inserir(Alunos alunos) {
        String sql = "INSERT INTO alunos (nome, email) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,alunos.getNome());
            stmt.setString(2,alunos.getEmail());
            stmt.executeUpdate();

            System.out.println("Aluno inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir aluno " + e.getMessage());
        }
    }
    //Listar todos os alunos

    public List<Alunos> listar() {
        List<Alunos> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try(Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Alunos a = new Alunos(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
                lista.add(a);
            }
        }catch(Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }
    //Atualizar

    public void atualizar(Alunos aluno) {
        String sql = "UPDATE alunos SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getId());
            stmt.executeUpdate();
            System.out.println("Aluno atualizado!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
    //Deletar

    public void deletar(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Aluno deletado!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}

