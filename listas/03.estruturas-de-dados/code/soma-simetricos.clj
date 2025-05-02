(defn soma-simetricos [sequencia i]
  (cond
      (empty? sequencia) 0    
      (or (< i 0) (>= i (count sequencia))) "Índice inválido!"
      :else (+ (nth sequencia i) (nth sequencia (- (dec (count sequencia)) i)))))

;; Asserts
(assert (= (soma-simetricos '(1 2 3 4 5 6 7 8 9 10) 2) 11)) 
(assert (= (soma-simetricos '(1 2) 1) 3))
(assert (= (soma-simetricos '(1) 0) 2))
(assert (= (soma-simetricos '() 0) 0))
(assert (= (soma-simetricos '(1 2) 2) "Índice inválido!"))
(assert (= (soma-simetricos '(1 2) -1) "Índice inválido!"))
(assert (= (soma-simetricos '() -1) 0))

