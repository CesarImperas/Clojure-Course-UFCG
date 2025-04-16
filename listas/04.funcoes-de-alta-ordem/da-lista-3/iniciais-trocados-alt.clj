(defn iniciais-trocados [lista]
 (if (>= (count lista) 2)
  (let [primeiro (first lista)
        segundo (second lista)]
    (apply concat (list (list segundo primeiro) (drop 2 lista))))
  lista))

;; Asserts
(assert (= (iniciais-trocados '(1 2 3)) '(2 1 3)))
(assert (= (iniciais-trocados '(1 2)) '(2 1)))
(assert (= (iniciais-trocados '(1)) '(1)))
(assert (= (iniciais-trocados '()) '()))

