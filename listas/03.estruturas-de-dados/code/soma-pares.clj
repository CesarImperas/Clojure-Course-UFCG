(defn soma-pares [sequencia-inteiro]
  (loop [sequencia sequencia-inteiro
         soma 0]
    (cond
      (empty? sequencia) soma
      :else (recur (rest sequencia) 
                   (+ soma (if (even? (first sequencia)) (first sequencia) 0))))))

;; Asserts
(assert (= (soma-pares '(1 2 3 4 5 6)) 12))
(assert (= (soma-pares '(1 2 3)) 2))
(assert (= (soma-pares '(2)) 2))
(assert (= (soma-pares '()) 0))

