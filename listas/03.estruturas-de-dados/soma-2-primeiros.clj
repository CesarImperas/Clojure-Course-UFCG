(defn soma-2-primeiros [lista]
 (cond
      (empty? lista) (+)
      (= (count lista) 1) (first lista)
      :else (+ (first lista) (nth lista 1))))

;; Asserts
(assert (= (soma-2-primeiros '()) 0))
(assert (= (soma-2-primeiros '(1)) 1))
(assert (= (soma-2-primeiros '(1 2)) 3))
(assert (= (soma-2-primeiros '(1 2 3)) 3))

(assert (= (soma-2-primeiros []) 0))
(assert (= (soma-2-primeiros [1]) 1))
(assert (= (soma-2-primeiros [1 2]) 3))
(assert (= (soma-2-primeiros [1 2 3]) 3))
