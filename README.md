# Sistema de Busca de Nomes em Arquivos

## Sobre o projeto

Este projeto consiste em um sistema de busca de nomes em arquivos de texto utilizando **concorrência em Java**. A aplicação realiza a pesquisa simultânea de um nome em três arquivos diferentes, utilizando Threads Virtuais para executar as buscas de forma independente e concorrente.

Durante a execução, o sistema identifica as linhas que contêm o nome procurado, contabiliza as ocorrências encontradas em cada arquivo e apresenta o total geral de ocorrências, além do tempo de execução da operação.

## Funcionalidades

- Busca simultânea de nomes em múltiplos arquivos de texto.
- Utilização de Threads Virtuais para execução concorrente das tarefas.
- Identificação e exibição do número das linhas que contêm o nome procurado.
- Contabilização do total de ocorrências em todos os arquivos.
- Medição do tempo total de execução da busca.

## Tecnologias utilizadas

- **Java 21 ou superior:** linguagem de programação utilizada no desenvolvimento.
- **Virtual Threads:** permitem executar múltiplas tarefas concorrentes com menor custo de gerenciamento de threads.
- **ExecutorService:** responsável pelo gerenciamento e execução das tarefas concorrentes.
- **AtomicInteger:** utilizado para compartilhar e atualizar o contador global de ocorrências de maneira segura entre as threads.
- **BufferedReader e Files:** utilizados para realizar a leitura dos arquivos de texto.

## Arquivos pesquisados

A aplicação realiza a busca nos seguintes arquivos:

- `signatarios-fev-2002.txt`
- `signatarios-jun-2016.txt`
- `signatarios-out-2014.txt`

Os arquivos devem estar disponíveis no diretório de execução da aplicação, ou seus caminhos devem ser ajustados no código-fonte.

## Como funciona

1. O sistema define o nome que será pesquisado.
2. É criado um `AtomicInteger` para armazenar o total de ocorrências encontradas nos arquivos.
3. O `ExecutorService`, utilizando `newVirtualThreadPerTaskExecutor()`, gerencia a execução das tarefas.
4. Para cada arquivo, uma instância de `BuscaNomeRunnable` é criada e submetida ao executor.
5. Cada tarefa realiza a leitura de seu respectivo arquivo linha por linha.
