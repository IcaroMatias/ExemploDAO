import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Cadastrar
        Scanner sc = new Scanner(System.in);

        AlunosDAO alunosDAO = new AlunosDAO();

        System.out.println("====Cadastrando um aluno====");

        System.out.println("Cadestre o nome do aluno ");
        String nome = sc.nextLine();

        System.out.println("Cadastre o email do aluno: ");
        String email = sc.nextLine();

        Alunos novo = new Alunos(nome,email);
        alunosDAO.inserir(novo);

        System.out.println("===Criando lista de Alunos===");
        for(Alunos a : alunosDAO.listar()){
            System.out.println(a.getId() + "_ " + a.getNome() + "_ " + a.getEmail());
        }
        //Atualizar
        System.out.println("\n ===Atualizar o Aluno===");
        System.out.println("Digite o id que deseja atualizar: ");
        int idAtualizar = sc.nextInt();
        sc.nextLine();

        System.out.println("Novo nome: ");
        String novoNome = sc.nextLine();

        System.out.println("Novo email: ");
        String novoEmail = sc.nextLine();

        Alunos atualizado = new Alunos(idAtualizar,novoNome, novoEmail);
        alunosDAO.atualizar(atualizado);

        //Deletar

        System.out.println("\n=== DELETAR UM ALUNO ===");
        System.out.print("Digite o ID do aluno que deseja deletar: ");
        int idDelete = sc.nextInt();
        alunosDAO.deletar(idDelete);
        sc.close();
    }
}