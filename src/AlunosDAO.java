
import java.sql.Connection;
public class AlunosDAO {
    public static void inserir(Alunos alunos) {
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
}
