import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static java.sql.DriverManager.getConnection;

public class ProfessoresDAO {
    public boolean emailExiste(String email){
        String sql = "SELECT id FROM professores WHERE email = ? LIMIT 1";
        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,"email");

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            System.out.println("Erro ao verificar o email " + e.getMessage());
            return false;
        }
    }
    public boolean cadastrarProfessor(Professores professores){
        if ( emailExiste(professores.getEmail())) {
            System.out.println("ERRO : Email ja cadastrado ! ");
            return false;
        }
        return inserir(professores);
    }

    //Inserir novos professores
    public boolean inserir(Professores professores) {
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
        return false;
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
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("especialidade")
                    );
                    lista.add(p);
                }
            }catch(Exception e) {
                System.out.println("Erro ao listar: " + e.getMessage());
            }
            return lista;
        }
    public Professores buscarPorId(int id) {

        String sql = "SELECT * FROM Professores WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new Professores(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar Professor: " + e.getMessage());
        }

        return null;
    }

    //Atualizar

        public boolean atualizar(Professores professores) {
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
            return false;
        }
        //Deletar

        public boolean deletar(int id) {
            String sql = "DELETE FROM professores WHERE id = ?";
            try (Connection conn = Conexao.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("professor deletado!");

            } catch (Exception e) {
                System.out.println("Erro ao deletar: " + e.getMessage());
            }
            return false;
        }

    public Professores login(String email, String senha) {

        String sql = "SELECT * FROM professores WHERE email = ? AND senha = ? LIMIT 1 ";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,email);
            stmt.setString(2,senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Professores(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
        }

        return null;
    }
}