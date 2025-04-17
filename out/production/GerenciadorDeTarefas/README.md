## Gerenciador de Tarefas! 📝

**Estou criando um gerenciador de tarefas simples para reforçar conceitos aprendidos até agora!**

**Estou usando OOP, versionamento git, enumerações, vou aplicar persistência de dados de uma forma bem simples, começando a fazer projetos com camadas para organizar melhor as coisas, vou aplicar também tratamentos de erro para reforçar esse conceito**

*Com base em tempo e aprendizado irei adicionando novos recursos a esse projeto!*

😁😁😁😁 

## Como Usar

Siga estas instruções para executar e interagir com o gerenciador de tarefas:

### Pré-requisitos

* **Java Development Kit (JDK):** Certifique-se de ter o JDK instalado em sua máquina.

* **Ambiente de Desenvolvimento Integrado (IDE) - Opcional:** Embora não seja estritamente necessário, uma IDE como IntelliJ IDEA, Eclipse ou VS Code com a extensão Java pode facilitar a execução e visualização do código.

### Execução do Projeto

1.  **Clone o Repositório (se você estiver compartilhando o código via Git):**


    bash
    git clone 
    cd [nome do diretório do projeto]
    

2.  **Compilação (se necessário):** Se você estiver executando o código diretamente sem uma IDE, pode precisar compilar os arquivos `.java` para arquivos `.class`. Navegue até o diretório raiz do projeto e execute:


    bash
    javac src/main/java/application/Program.java src/main/java/entities/*.java src/main/java/entities/enums/*.java # Adapte os caminhos conforme a sua estrutura
    
    *Substitua os caminhos acima pela estrutura real dos seus pacotes e arquivos.*

3.  **Execução:** Execute a classe principal (`Program.java`) para iniciar o gerenciador de tarefas:
    ```bash
    java src/main/java/application/Program
    ```
    *Novamente, ajuste o caminho se necessário.*

    **Se estiver usando uma IDE:** Geralmente, você pode abrir o projeto na IDE e executar a classe principal (`Program.java`) diretamente através da interface.

### Interagindo com o Gerenciador de Tarefas

Ao executar o programa, você será guiado por um menu ou prompts no console para interagir com o gerenciador de tarefas. As funcionalidades atuais incluem (liste as funcionalidades que já estão implementadas):

* **Adicionar uma nova tarefa:** Você será solicitado a fornecer o nome, descrição, prioridade (BAIXA, MEDIA, ALTA, URGENTE) e status (PENDENTE, CONCLUIDA) da tarefa.
* **Listar todas as tarefas:** Exibe todas as tarefas cadastradas com suas informações (nome, descrição, prioridade, status).
* **[Outras funcionalidades implementadas, como marcar tarefa como concluída, etc.]**

**Exemplo de interação:**