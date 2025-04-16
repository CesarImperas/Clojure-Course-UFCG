# Estruturas de Dados

1. No arquivo `soma-2-primeiros.clj`, escreva asserts para a
   função `soma-2-primeiros` que retorna a soma dos dois
   primeiros valores de uma _lista_ clojure. Se a lista tiver
   apenas um elemento, a soma deve ser igual a esse elemento. Se
   a lista tiver zero elementos, a soma é zero. Em seguida,
   escreva a função que passe nos asserts.

   > Dicas. Ao invés de usar `if`, use `cond`, já que há três
   > casos na condição mencionada acima. Outras funções ou formas
   > que você pode usar nesta solução: `empty?`, `count`,
   > `first`, `rest` e `nth`.

2. No mesmo arquivo, copie os asserts feitos anteriormente,
   trocando as listas por vetores. E verifique se sua solução
   funciona para ambos os conjuntos de testes. Se você tiver
   usado apenas as funções mencionadas que são de _sequências_ a
   solução deve funcionar perfeitamente. Se não funcionar, ajuste
   o que for necessário na implementação para que funcione tanto
   para listas, como para vetores.

3. No arquivo `elemento-central.clj`, escreva asserts para a
   função `elemento-central` que recebe uma sequência qualquer e
   retorna o elemento no centro da sequência, se o número de
   elementos for ímpar. Ou o elemento da direita do par de
   elementos centrais, caso o número de elementos seja par.
   Escreva também a função para que passe nos testes.

4. No arquivo `iniciais-trocados.clj`, escreva asserts para a
   função `iniciais-trocados` que recebe uma lista de inteiros e
   retorna uma lista com os mesmos elementos, mas com os dois
   primeiros em posições trocadas.

5.  No arquivo `soma-simetricos.clj`, escreva asserts para a
    função `soma-simetricos` que recebe uma sequencia de inteiros
    e um índice e que retorna a soma dos valores em posições
    simétricas da sequência. Por exemplo, se a lista tiver 10
    elementos e o índice for 2, a função deve retornar a soma dos
    valores nos índices 2 e 7 (o terceiro na ordem normal e o
    terceiro de trás pra frente).

6. No arquivo `soma-pares.clj`, escreva asserts para a função
   `soma-pares` que recebe uma sequencia de inteiros e que
   retorna a soma de todos os valores pares da sequência. Escreva
   também a função.

7. No arquivo `soma-alternados.clj`, escreva asserts para a função
   `soma-alternados` que recebe uma sequencia de inteiros e que
   retorna a soma dos valores em posições pares (cujos índices
   são 0, 2, 4, etc) da sequência. Escreva também a função de
   forma que passe nos testes.

8. No arquivo `elimina-empates.clj`, escreva asserts para a função
   `elimina-empates` que recebe uma sequência de inteiros e que
   elimina os empates (vizinhos de valor igual), usando a
   seguinte lógica. Se houver empates, então o primeiro elemento
   (o mais à direita do par) deve ser somado a 1, eliminando o
   empate. O procedimento deve ser repetido se outros empates
   existirem até que não haja mais nenhum empate. Observe que ao
   eliminar um empate, um novo empate pode ser criado. Esse
   empate também deve ser eliminado, usando a mesma lógica.
   Escreva também a função.

9. No arquivo `troca-pares.clj` escreva asserts para a função
   `troca-pares` que troca todos os pares de vizinhos da
   sequência, dois a dois. Por exemplo, se a sequência é `1 2 3
   4`, a função deve retornar a sequência `2 1 4 3`. Escreva
   também a função.
