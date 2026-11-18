## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -encoding UTF-8 -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```

R - A classe legado "SecretariaLegadoWS" faz uso de matrizes de texto para representar os dados dos alunos. Enquanto a classe "FonteDeAlunos" representa os dados dos alunos utilizando uma classe Aluno. Isso demonstra a divergência de informações entre o código legado e o código atual.

R -

Importação do sistema legado

O serviço da secretaria entregava os dados em matriz de texto com o status em letra, e não podíamos alterá-lo. Como a conversão para Aluno estava duplicada entre importador e relatório gerando inconsistência com letra minúscula e acoplada à classe concreta do legado, apliquei o padrão Adapter. O AdaptadorSecretariaLegado implementa a interface FonteDeAlunos do SIGA, centralizando a conversão e desacoplando os clientes sem mexer nos dois lados.

Matrícula pela tela

Para matricular um aluno, a tela precisava conhecer seis classes e a ordem exata de chamá-las, colocando regra de negócio na camada de apresentação e criando risco de duplicação com a matrícula em lote. Como o problema era o excesso de passos expostos e não o formato dos dados, apliquei o padrão Facade. A FachadaMatricula orquestra o subsistema através da operação matricular(...), fazendo a tela depender de um único colaborador e cuidar só da interface.

Por que padrões diferentes

Apesar da estrutura parecida, a intenção é diferente: o Adapter converte os dados para atender a uma interface já existente, enquanto a Facade cria uma nova interface para reduzir passos. Nos dois casos, copiar o código seria a pior escolha, pois espalharia o conhecimento e geraria divergências com o tempo.
