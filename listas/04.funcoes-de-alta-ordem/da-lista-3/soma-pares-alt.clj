(defn soma-pares [sequencia-inteiro]
  (reduce + (filter even? sequencia-inteiro)))
  
;; Asserts
(assert (= (soma-pares '(1 2 3 4 5 6)) 12))
(assert (= (soma-pares '(1 2 3)) 2))
(assert (= (soma-pares '(2)) 2))
(assert (= (soma-pares '()) 0))

