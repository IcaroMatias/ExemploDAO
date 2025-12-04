public class Professores {
    private int id, numero;
    private String nome,email,especialidade,rua,bairro,cidade;
    private double salario;
    private boolean status;

    public Professores(String nome, String email, String especialidade){
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
        this.salario = this.salario;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.status = status;
    }
    public Professores(int id,String nome,String email,String especialidade){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
        this.salario = salario;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean isStatus() {
        return status;
    }
}
