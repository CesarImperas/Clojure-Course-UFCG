# Atividade Lista 1

Nome: Caio Cesar Vieira Cavalcanti
Matrícula: 123110825

## Parte 1

1. S-Expressão ou Expressão Simbólica é o conceito mais fundamental do Lisp e de seus dialetos. McCarthy (desenvolvedor da linguagem de programação Lisp) percebeu que para os trabalhos envolvendo a área de IA, não se era útil uma **computação numérica** e sim uma **computação simbólica**, em que tudo que fosse um dado, poderia ser representado por uma __lista de símbolos__.  Uma s-expressão pode-se dividir em dois tipos:
* Um **átomo**, que é um dado __individual__ e indivisível (também conhecido como **literal** nas demais linguagens de programação)
* Uma **lista**, que é um dado __composto__, formado por uma sequência de s-expressões, e por conta disso, a definição de listas é __recursiva__, ou seja, podemos ter, sem problemas, uma lista de lista, uma s-expressão composta por outra. Além disso, elas possuem algumas características, como: os átomos dessas listas são separados por espaços e delimitado por parênteses (aí que vem o famoso "bullying" com a linguagem, devido ao seu extensivo uso de **parênteses**).


2.
```clojure
1.61        ; número de ponto flutuante
"Caio"      ; string (lista de caracteres)
3/2         ; ratio (razão, uma representação de fração, com dois números inteiros)
:equacao    ; keyword (um tipo especial, que referencia o próprio valor/símbolo)
true        ; booleano
```

3. Uma forma é qualquer unidade de código que é sintaticamente válida/correta, e que produz um **valor** ao serem **avaliadas**. Nem toda s-expressão é uma forma! Podemos ter símbolos que não referenciam a um valor, e que se avaliados, no REPL (interpretador da linguagem, que na verdade é um __prompt interativo__), é produzido um erro ou uma exceção. Contudo, s-expressões que possui átomos (uma s-expressão atômica) ela é uma **forma simples**, e produz o seu próprio valor, já definido na construção da linguagem (como um inteiro qualquer, uma string, um booleano, etc). De forma geral, uma forma é uma S-Expressão parentizada que contém uma operação ou função após a primeira abertura dos parênteses e um conjunto de argumentos subsequentes, cada um separado por espaço (e não por vírgula). Com isso, quando uma S-Expressão está no que chamamos de **notação polonesa**, ou notação prefixada, em que pode ser avaliada e executada sem erros, temos como resultado uma **forma**.

4.
```clojure
; Não são formas:
(1 2 3)     		  ; lista de inteiros
("Olá" "Tudo" "Bem?")     ; lista de strings
((1/2) (1/4))             ; lista de lista de ratio

; São formas:
(+ 1 2)                     ; soma entre dois números inteiros (1 + 2 -> na notação infixa)
(str "Olá, " "tudo " "bem") ; função str concatena todas as strings como argumento em uma só 
(* 3 4)                     ; multiplicação ou produto entre dois números inteiros (3 * 4 -> na notação infixa) 
```


5. Símbolos são como denominamos as "variáveis" presentes nas linguagens de programação com paradigma imperativo, no qual, são criadas como **identificadores** e referenciam (não armazenam) um dado, podendo ser valores ou funções (que na prática, no paradigma funcional, são valores também) presentes em um local específico da memória, e que poderá ser usado quando tal identificador for chamado no decorrer do programa (ocorrendo o processo de dereferenciação - ou o ato de dereferenciar). Alguns exemplos de símbolos de Clojure/Lisp e que carrega consigo uma função, são os operadores aritméticos `(+ - / *)`. Exemplo usando um desses símbolos: 
```clojure
(+ 1 2)     ; user=> 3
(* 3 3)     ; user=> 9
```


6. 
```clojure
; Derivação semântica, utilizando a ordem aplicativa

(* (+ 2 5 7) (- 8 (inc 3)) 5)   ; => (inc 3) é 4 
(* (+ 2 5 7) (- 8 4) 5)         ; => (-8 4) é 4
(* (+ 2 5 7) 4 5)               ; => (+ 2 5 7) é 14
(* 14 4 5)                      ; => (* 14 4 5) é 280
280
```

7. As formas especiais são formas que possuem um **tratamento** especial, e que muitas vezes possuem uma semântica especial. Elas, diferentes das formas puras, não retornam um valor de fato quando avaliadas, mas sim, executam o que conhecemos de **efeito colateral**, e alteram partes do sistema ao seu favor, como imprimir um valor no terminal, criar novos dados na memória, realizar a vinculação ou referência de um símbolo ao seu valor referenciado, entre outros impactos, que não são visíveis ou observados como efeito imediato da avaliação dessa forma (ou efeito primário), por isso o nome de efeito colateral. Vamos conhecer algumas dessas formas especiais:
* `def` realiza a vinculação de um símbolo (um nome) com um valor passado como último argumento, e se avaliado pelo interpretador, não é retornado o valor que esse símbolo referencia, e sim o local da memória que se está armazenado esse símbolo, e o valor que o mesmo referencia. 
* `fn` também é uma forma especial, por criar um novo dado na memória, nesse caso uma função anônima, mas que não é utilizada ao mesmo tempo que é criada (essa é a maior diferença, do porque tratamos `fn` como forma especial), e sim, precisa ao criar, passar um argumento para a mesma executar e retornar um valor. 
* `if` somente avalia uma condição, ou melhor, verifica uma condição, e modifica o fluxo de código, em qual parte o programa vai prosseguir, e não retornando um valor como uma forma comum. Como detalhe desta forma `if`, ela subverte a ordem aplicativa comum de Lisp para as demais expressões, e sim utiliza a **lazy evaluation**, ou **avaliação preguiçosa**, que somente executa o fluxo de código que for aceito na condição.


8. 
```clojure
(defn dobro [n] (* 2 n))
(defn triplo [n] (* 3 n))
(defn vezes_12 [n]
    (dobro (dobro (triplo n))))

(vezes_12 10)

; Execução

(dobro (dobro (triplo 10)))     ; atribuição do argumento 10 para o parâmetro n da função triplo
(dobro (dobro (* 3 10)))
(dobro (dobro 30))              ; atribuição do argumento 30 para o parâmetro n da função dobro
(dobro (* 2 30))
(dobro 60)                      ; atribuição do argumento 60 para o parâmetro n da função dobro
(* 2 60)
120
```  


9.
```clojure
(fn [a b c] (- (* b b) (* 4 a c)))   		    ; `fn`
(def eq2delta (fn [a b c] (- (* b b) (* 4 a c))))   ; `def`
(defn eq2delta [a b c] (- (* b b) (* 4 a c)))       ; `defn`
```

10. 
```clojure
(defn raizes [a b c]
  (let [delta (- (* b b) (* 4 a c))]
    (cond
      (neg? delta) []
      (= delta 0) [(/ (- b) (* 2 a))]
      :else [(/ (+ (-b) (Math/sqrt delta)) (* 2 a))
             (/ (- (- b) (Math/sqrt delta)) (* 2 a))])))
```

11. Feito no arquivo `hello.clj`

12. Feito no arquivo `eq2.clj`

## Parte 2

Para essa parte, foi elaborado cada arquivo com a extensão `.clj` para a resolução de cada problemática.







