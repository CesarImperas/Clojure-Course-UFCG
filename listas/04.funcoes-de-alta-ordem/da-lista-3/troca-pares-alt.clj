(defn troca-pares [sequencia]
  (->> sequencia
       (partition-all 2)
       (map reverse)
       (apply concat)))

;; Asserts
(assert (= (troca-pares '(1 2 3 4 5)) '(2 1 4 3 5)))
(assert (= (troca-pares '(1 2 3 4)) '(2 1 4 3)))
(assert (= (troca-pares '(1 2)) '(2 1)))
(assert (= (troca-pares '(1)) '(1)))
(assert (= (troca-pares '()) '()))

