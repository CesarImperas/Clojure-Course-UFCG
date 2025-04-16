(defn soma-alternados [sequencia]
  (loop [soma 0
         indice 0]
    (cond
      (>= indice (count sequencia)) soma
      :else (recur (+ soma (nth sequencia indice)) (+ indice 2)))))


;; Asserts
(assert (= (soma-alternados '(1 2 3 4 5 6)) 9))
(assert (= (soma-alternados '(1 2 3)) 4))
(assert (= (soma-alternados '(2)) 2))
(assert (= (soma-alternados '()) 0))

