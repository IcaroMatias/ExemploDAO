public class ProfessoresSessao {
    private static Professores usuarioLogado = null;
    public static void setUsuarioLogado (Professores professores){
        usuarioLogado = professores;
    }
    public static Professores getUsuarioLogado(){
        return usuarioLogado;
    }
    public static void limpar(){
        usuarioLogado = null;
    }
}
