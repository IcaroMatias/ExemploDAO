public class Alunos {
    private String nome;
    private int id;
    private String email;

    public Alunos(String nome,String email){
         this.nome = nome;
         this.email = email;
    }
    public Alunos(int id,String nome,String email){
        this.id = id;
        this.nome = nome;
        this.email = email;

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
