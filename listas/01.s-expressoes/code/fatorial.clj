(defn fatorial [n]
  (cond
        (< n 0) "Número negativo"
        (= n 0) 1
        :else (* (fatorial (dec n)) n)))

;; Asserts
(assert (= (fatorial 0) 1))
(assert (= (fatorial 1) 1))
(assert (= (fatorial 6) 720))
(assert (= (fatorial -1) "Número negativo"))

