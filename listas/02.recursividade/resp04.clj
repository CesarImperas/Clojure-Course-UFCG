(defn conta []
  (loop [num 0]
    (println num)
    (recur (inc num))))

(conta)

;; Explicação do porquê não há mais o erro de StackOverFlowError:
;;
;; Como Clojure não possui TCO por padrão, com os mecanismos de fato inseridos ao compilador da linguagem, o mesmo não pode, de maneira sozinha, inferir
;; se uma função recursiva é de cauda, e aplicar automaticamente a otimização nesta recursão (a chamada TCO - Tail Call Optimization). Para isso, precisamos
;; indicar o passo que acontece essa recursão de cauda, por meio da forma especial `recur`, que irá otimizar o bloco de código a ser repetido no passo de
;; recursão (aqui indicamos pela outra forma especial `loop`). Tal otimização, por baixo dos panos, aplica uma transformação da recursão em um laço iterativo que,
;; ao contrário da recursão nativa (propriamente dita), no qual ao final do passo de recursão, a pilha precisa ser desempilhada para realizar outra operação, a iterativa já consegue
;; atualizar os valores de modo que não precisa da etapa de desempilhamento, para realizar um computação num determinado problema, retornando ao fim do passo de recursão o resultado
;; sem algum erro a ser lançado, como estavamos observando nas funções anteriores.

