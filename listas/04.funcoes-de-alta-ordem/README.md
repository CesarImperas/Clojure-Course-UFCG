# Funções de alta ordem

O objetivo desta lista é treinar o uso de funções de alta ordem,
para programar em contextos que usem repetições. Você é livre
para usar qualquer uma das funções de alta ordem clássicas, tais
como `map`, `filter`, `reduce` e `apply` ou as demais menos
conhecidas, tais como `foreach` (que em Clojure é chamada
`doseq`), `some`, . Você também é livre para usar funções que
lidam com sequências _lazy_ (até mesmo as infinitas) feitas a
partir do uso de `range`, `repeat`, `repeatedly`, `cycle`,
`drop`, `take`, `take-while`, etc.  Também pode usar
_comprehensions_ com a macro `for` de Clojure. Você
também deve procurar oportunidades de usar as macros `->>` e `->` que
permite a escrita de _pipelines_ e o uso de uma notação em ordem
direta da aplicação de funções, melhorando a legibilidade. Por
fim, você pode usar funções de alta ordem que manipulam e
combinam funções, em particular a operação de composição (`comp`
em Clojure), `partial`, etc.

## Parte 1

Para isso, esta lista consiste em refazer os exercícios abaixo
mencionados das listas 2 e 3, trocando o uso de todos os loops e
usos de recursividade por operadores e funções de alta ordem,
como os mencionados acima.

### Como proceder?

Crie um diretório `da-lista-2` e outro `da-lista-3`. Em cada um
deles crie os arquivos para conter as respostas para cada uma das
questões dessas listas. 

Sugestão: copie suas respostas anteriores para estes diretórios e
altere as funções para atender ao que se espera. Se você tiver
criado testes, mantenha-os e haranta que a nova implementação
segue exatamente a mesma especificação e passa nos mesmos testes.
Observe que uma nova estratégia de programar é necessária. É
importante que você observe as diferenças entre as formas de
programar.
