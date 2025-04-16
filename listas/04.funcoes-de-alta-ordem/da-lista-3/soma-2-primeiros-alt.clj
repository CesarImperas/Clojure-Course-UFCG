(defn soma-2-primeiros [lista]
  (apply + (take 2 lista)))
  
;; Asserts
(assert (= (soma-2-primeiros '()) 0))
(assert (= (soma-2-primeiros '(1)) 1))
(assert (= (soma-2-primeiros '(1 2)) 3))
(assert (= (soma-2-primeiros '(1 2 3)) 3))

(assert (= (soma-2-primeiros []) 0))
(assert (= (soma-2-primeiros [1]) 1))
(assert (= (soma-2-primeiros [1 2]) 3))
(assert (= (soma-2-primeiros [1 2 3]) 3))

