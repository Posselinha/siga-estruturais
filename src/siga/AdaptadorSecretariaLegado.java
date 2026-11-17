package siga;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorSecretariaLegado implements FonteDeAlunos {

    private static final int COLUNA_MATRICULA = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_SITUACAO = 2;
    private static final String SITUACAO_ATIVO = "A";

    private final SecretariaLegadoWS servico;

    public AdaptadorSecretariaLegado(SecretariaLegadoWS servico) {
        this.servico = servico;
    }

    @Override
    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        for (String[] linha : servico.consultarTabelaAlunos()) {
            alunos.add(converter(linha));
        }
        return alunos;
    }

    private Aluno converter(String[] linha) {
        Aluno aluno = new Aluno(linha[COLUNA_MATRICULA], linha[COLUNA_NOME]);
        aluno.setAtivo(SITUACAO_ATIVO.equals(linha[COLUNA_SITUACAO]));
        return aluno;
    }
}