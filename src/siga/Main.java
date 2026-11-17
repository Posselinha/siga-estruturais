package siga;

/**
 * Demonstra os três deslizes acontecendo. Execute e observe a saída:
 * é dela que partem as etapas da ficha de atividade prática.
 */
public class Main {

    public static void main(String[] args) {
        SecretariaLegadoWS servicoLegado = new SecretariaLegadoWS();
        AlunoDAO alunoDAO = new AlunoDAOMemoria();
        FonteDeAlunos fonte = new AdaptadorSecretariaLegado(servicoLegado);

        System.out.println("=== SIGA — Aula 10: Adapter e Facade (código inicial) ===");

        System.out.println();
        System.out.println("1) Importação a partir do sistema legado");
        ImportadorAlunos importador = new ImportadorAlunos(fonte, alunoDAO);
        System.out.println("   Alunos importados: " + importador.importar());
        System.out.println("   Situação segundo o importador:");
        for (Aluno aluno : alunoDAO.listarTodos()) {
            System.out.println("     " + aluno);
        }

        System.out.println();
        System.out.println("2) O mesmo dado, convertido por outro trecho do sistema");
        new RelatorioSituacao(fonte).imprimir();

        System.out.println();
        System.out.println("3) Matrícula pela tela");
        Aluno bolsista = alunoDAO.buscarPorMatricula("2024001");
        bolsista.setBolsista(true);

        FachadaMatricula fachada = new FachadaMatricula(new ValidadorCpf(), alunoDAO, new ControleVagas(), new CalculadoraDesconto(), new MatriculaDAOMemoria(), new NotificadorEmail());

        TelaMatricula tela = new TelaMatricula(fachada);

        tela.aoClicarEmMatricular("2024001", "123.456.789-09", "DSM-2A");
        tela.aoClicarEmMatricular("2024002", "111", "DSM-2A");
        tela.aoClicarEmMatricular("2024009", "123.456.789-09", "DSM-2A");
        tela.aoClicarEmMatricular("2024004", "123.456.789-09", "DSM-2B");

        System.out.println();
        System.out.println("Sua tarefa: ver o README.md e a ficha de atividade prática.");
    }
}
