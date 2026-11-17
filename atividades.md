## Sua tarefa

Siga as etapas da ficha de atividade prática:

1. **Localizar a duplicação.** Identifique os dois trechos que convertem o formato legado e descreva, neste README, em que ponto exato eles divergem.
2. **Criar o Adapter.** Escreva a interface `FonteDeAlunos`, com o método `List<Aluno> listar()`, e a classe `AdaptadorSecretariaLegado`, que a implementa recebendo `SecretariaLegadoWS` por composição. A conversão deve passar a existir em **um único lugar**, com a regra da letra minúscula aplicada uma vez só.
3. **Refatorar o cliente.** `ImportadorAlunos` deve passar a receber `FonteDeAlunos`, e não mais a classe legada. Ao terminar, a palavra `SecretariaLegadoWS` não deve aparecer em nenhum lugar do importador. Ajuste `RelatorioSituacao` para consumir a mesma fonte.
4. **Criar a Facade.** Escreva `FachadaMatricula` com a operação `matricular(String matricula, String cpf, String codigoTurma)`, movendo para ela a orquestração hoje presente na tela. `TelaMatricula` deve passar a receber **um** colaborador e a conter apenas a chamada e o tratamento de erro da interface.
5. **Justificar.** Explique neste README por que cada caso pediu o padrão escolhido, descrevendo **o problema** antes de nomear o padrão.
