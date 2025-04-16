(defn soma-simetricos [sequencia i]
  (let [tamanho (count sequencia)]
    (cond
      (empty? sequencia) 0
      (or (neg? i) (>= i tamanho)) "Índice inválido!"
      :else (->> [i (- (dec tamanho) i)]
                 (map #(nth sequencia %))
                 (reduce +)))))

;; Asserts
(assert (= (soma-simetricos '(1 2 3 4 5 6 7 8 9 10) 2) 11))
(assert (= (soma-simetricos '(1 2) 1) 3))
(assert (= (soma-simetricos '(1) 0) 2))
(assert (= (soma-simetricos '() 0) 0))
(assert (= (soma-simetricos '(1 2) 2) "Índice inválido!"))
(assert (= (soma-simetricos '(1 2) -1) "Índice inválido!"))
(assert (= (soma-simetricos '() -1) 0))

