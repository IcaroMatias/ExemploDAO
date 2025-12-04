import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProfessoresDAO dao = new ProfessoresDAO();

        while (true){
            System.out.println("==== Sistema de Professores ====");
            //MENSAGEM DE SESSAO
            if (ProfessoresSessao.getUsuarioLogado() != null) {
                System.out.println("Olá " + ProfessoresSessao.getUsuarioLogado().getNome()
                        + ", bem-vindo ao novo sistema escolar. ");
            }else {
                System.out.println("Professor não logado ");
            }
            // --- MENU ---
            System.out.println("1) Cadastrar Professor");
            System.out.println("2) Listar Professor");
            System.out.println("3) Buscar por ID");
            System.out.println("4) Atualizar Professor");
            System.out.println("5) Deletar Professor");
            System.out.println("6) Login");
            System.out.println("7) Logout");
            System.out.println("0) Sair");
            System.out.print("\nEscolha: ");
            int op = sc.nextInt();
            sc.nextLine();

            //Bloqueio se não estiver logado
            if (ProfessoresSessao.getUsuarioLogado() == null && !(op == 6 || op == 0)) {
                System.out.println("Precisa estar logado para iniciar essa sessão ");
                System.out.println("Use a opção 6 para realizar o login ");
                System.out.println("Pressione ENTER para continuar ");
                sc.nextLine();
                continue;
            }
            switch (op){
                //Cadastrar
                case 1:
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Email ");
                    String email = sc.nextLine();
                    System.out.println("Senha ");
                    String senha = sc.nextLine();

                    Professores novo = new Professores(nome,email,senha);

                    if (dao.inserir(novo)) {
                        System.out.println("Cadastrado");
                    }else{
                        System.out.println("Falha ao cadastrar");
                    }
                    break;
                case 2:
                    System.out.println("===Listar Professor");
                    for(Professores p : dao.listar()){
                        System.out.println(p.getId() + p.getNome() + p.getEmail());
                    }
                    break;
                // 3 - BUSCAR POR ID
                case 3:
                    System.out.print("ID: ");
                    int idBusca = sc.nextInt();

                    Professores encontrado = dao.buscarPorId(idBusca);

                    if (encontrado != null)
                        System.out.println(encontrado.getId() + " - " + encontrado.getNome());
                    else
                        System.out.println("Não encontrado.");
                    break;

                // 4 - ATUALIZAR
                case 4:
                    System.out.print("ID: ");
                    int idUp = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String nomeUp = sc.nextLine();

                    System.out.print("Novo email: ");
                    String emailUp = sc.nextLine();

                    System.out.print("Nova senha: ");
                    String senhaUp = sc.nextLine();

                    Professores alt = new Professores(idUp, nomeUp, emailUp, senhaUp);

                    if (dao.atualizar(alt)) {
                        System.out.println("Atualizado!");
                    }else{
                        System.out.println("Erro ao atualizar.");
                    }
                    break;

                // 5 - DELETAR
                case 5:
                    System.out.print("ID: ");
                    int idDel = sc.nextInt();

                    if (dao.deletar(idDel))
                        System.out.println("Deletado!");
                    else
                        System.out.println("Erro ao deletar.");
                    break;

                // 6 - LOGIN
                case 6:
                    System.out.print("Email: ");
                    String emailLog = sc.nextLine();

                    System.out.print("Senha: ");
                    String senhaLog = sc.nextLine();

                    Professores logado = dao.login(emailLog, senhaLog);
                    if (logado != null) {
                        ProfessoresSessao.setUsuarioLogado(logado);
                        System.out.println("Login OK! Bem-vindo, " + logado.getNome());
                    } else {
                        System.out.println("Login inválido.");
                    }
                    break;

                // 7 - LOGOUT
                case 7:
                    if (ProfessoresSessao.getUsuarioLogado() != null) {
                        System.out.println("Logout realizado: " +
                                ProfessoresSessao.getUsuarioLogado().getNome());
                        ProfessoresSessao.limpar();
                    } else {
                        System.out.println("Você não está logado.");
                    }
                    break;
                // 0 - SAIR
                case 0:
                    System.out.println("Encerrando...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("\nPressione ENTER para continuar...");
            sc.nextLine();

        }
    }

}