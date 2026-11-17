## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -encoding UTF-8 -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```

R - A classe legado "SecretariaLegadoWS" faz uso de matrizes de texto para representar os dados dos alunos. Enquanto a classe "FonteDeAlunos" representa os dados dos alunos utilizando uma classe Aluno. Isso demonstra a divergência de informações entre o código legado e o código atual.
