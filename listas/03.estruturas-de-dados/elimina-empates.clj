(defn elimina-empates [sequencia-inteiros]
  (loop [sequencia sequencia-inteiros
         resultado '()]
    (if-let [[primeiro segundo & resto] (seq sequencia)]
      (cond
        (= primeiro segundo) (recur (cons (inc segundo) resto) (cons primeiro resultado))
        (not (nil? segundo)) (recur (cons segundo resto) (cons primeiro resultado))
        :else (recur resto (cons primeiro resultado)))
      (reverse resultado))))

;; Asserts
(assert (= (elimina-empates '(1 1 2 3 4)) '(1 2 3 4 5)))
(assert (= (elimina-empates '(5 5 5 5)) '(5 6 5 6)))
(assert (= (elimina-empates '(1 1 1 2)) '(1 2 1 2)))
(assert (= (elimina-empates '(1 1)) '(1 2)))
(assert (= (elimina-empates '(1)) '(1)))
(assert (= (elimina-empates '()) '()))

