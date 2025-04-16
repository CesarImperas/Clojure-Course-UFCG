(defn troca-pares [sequencia-inteiros]
  (loop [sequencia sequencia-inteiros
         resultado '()]
    (if-let [[primeiro segundo & resto] (seq sequencia)]
      (cond
        (not (nil? segundo)) (recur resto (cons primeiro (cons segundo resultado)))
        :else (recur resto (cons primeiro resultado)))
    (reverse resultado))))

;; Asserts
(assert (= (troca-pares '(1 2 3 4 5)) '(2 1 4 3 5)))
(assert (= (troca-pares '(1 2 3 4)) '(2 1 4 3)))
(assert (= (troca-pares '(1 2)) '(2 1)))
(assert (= (troca-pares '(1)) '(1)))
(assert (= (troca-pares '()) '()))

