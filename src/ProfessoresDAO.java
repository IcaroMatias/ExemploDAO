import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessoresDAO {
        // Inserir novos professores

        public void inserir(Professores professores) {
            String sql = "INSERT INTO professores (nome, email, especialidade, salario," +
                    " rua, numero, bairro, cidade, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = Conexao.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)){

                stmt.setString(1,professores.getNome());
                stmt.setString(2,professores.getEmail());
                stmt.setString(3,professores.getEspecialidade());
                stmt.setDouble(4,professores.getSalario());
                stmt.setString(5,professores.getRua());
                stmt.setInt(6,professores.getNumero());
                stmt.setString(7,professores.getBairro());
                stmt.setString(8,professores.getCidade());
                stmt.setBoolean(9,professores.getStatus());

                stmt.executeUpdate();

                System.out.println("Professor inserido com sucesso!");

            } catch (Exception e) {
                System.out.println("Erro ao inserir professor: " + e.getMessage());
            }
        }
        //Listar todos os professores

        public List<Professores> listar() {
            List<Professores> lista = new ArrayList<>();
            String sql = "SELECT * FROM professores";

            try(Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Professores p = new Professores(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("especialidade"),
                            rs.getDouble("salario"),
                            rs.getString("rua"),
                            rs.getInt("numero"),
                            rs.getString("bairro"),
                            rs.getString("cidade"),
                            rs.getBoolean("status")
                    );
                    lista.add(p);
                }
            }catch(Exception e) {
                System.out.println("Erro ao listar: " + e.getMessage());
            }
            return lista;
        }
        //Atualizar

        public void atualizar(Professores professores) {
            String sql = "UPDATE alunos SET nome = ?, email = ?, especialidade = ?," +
                    " salario = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, status = ? WHERE id = ?";

            try (Connection conn = Conexao.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, professores.getNome());
                stmt.setString(2, professores.getEmail());
                stmt.setString(3, professores.getEspecialidade());
                stmt.setDouble(4, professores.getSalario());
                stmt.setString(5, professores.getRua());
                stmt.setInt(6, professores.getNumero());
                stmt.setString(7, professores.getBairro());
                stmt.setString(8,professores.getCidade());
                stmt.setBoolean(9, professores.getStatus());
                stmt.setInt(10,professores.getId());
                stmt.executeUpdate();
                System.out.println("professor atualizado!");

            } catch (Exception e) {
                System.out.println("Erro ao atualizar: " + e.getMessage());
            }
        }
        //Deletar

        public void deletar(int id) {
            String sql = "DELETE FROM professores WHERE id = ?";
            try (Connection conn = Conexao.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("professor deletado!");

            } catch (Exception e) {
                System.out.println("Erro ao deletar: " + e.getMessage());
            }
        }
}