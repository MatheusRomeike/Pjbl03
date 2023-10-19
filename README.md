# Tabela Hash com Tratamento de Colisões

Este programa implementa uma tabela hash que pode lidar com colisões usando duas técnicas: encadeamento separado e sondagem linear. Ele é capaz de armazenar nós com chaves do tipo inteiro e do tipo string.

## Funcionamento do Programa

### Implementação da Tabela Hash

A tabela hash é implementada com base em uma matriz de listas vinculadas. A capacidade da tabela é determinada durante a inicialização.

### Função de Hash

A função de hash é usada para calcular o índice de inserção dos nós na tabela hash. Para chaves do tipo inteiro, o índice é calculado como o resto da divisão da chave pelo tamanho da tabela. Para chaves do tipo string, o índice é calculado como o resto da soma dos valores ASCII dos caracteres da chave pelo tamanho da tabela.

### Tratamento de Colisões

1. Encadeamento Separado: Se ocorrer uma colisão durante a inserção, o programa usa a técnica de encadeamento separado, adicionando o novo nó a uma lista vinculada na posição correspondente da tabela hash.

2. Sondagem Linear: Se ocorrer uma colisão durante a inserção, o programa usa a técnica de sondagem linear, procurando o próximo slot disponível na tabela hash e adicionando o novo nó nesse slot.

### Operações Suportadas

O programa suporta as seguintes operações na tabela hash:

- Inserção de Nó
- Busca de Nó por Chave (tanto para chaves do tipo inteiro quanto do tipo string)
- Remoção de Nó por Chave (tanto para chaves do tipo inteiro quanto do tipo string)

## Uso do Código

O arquivo `HashTable.java` contém a implementação da tabela hash, juntamente com as funções de hash, tratamento de colisões e operações de manipulação da tabela. O arquivo `Main.java` contém exemplos de uso das operações da tabela hash.

