(defn elimina-empates [sequencia]
  (->> sequencia
       (reductions #(if (= %1 %2) (inc %2) %2) nil)
       (rest)))

;; Asserts

(assert (= (elimina-empates '(1 1 2 3 4)) '(1 2 3 4 5)))
(assert (= (elimina-empates '(5 5 5 5)) '(5 6 5 6)))
(assert (= (elimina-empates '(1 1 1 2)) '(1 2 1 2)))
(assert (= (elimina-empates '(1 1)) '(1 2)))
(assert (= (elimina-empates '(1)) '(1)))
(assert (= (elimina-empates '()) '()))


;; A função `reductions` é semelhante a `reduce` com a diferença de retornar uma lazy sequence
;; com todos os valores intermediários dessa redução por uma função como argumento, ao invés
;; de um único valor resposta.

