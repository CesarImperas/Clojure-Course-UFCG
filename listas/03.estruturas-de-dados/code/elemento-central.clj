(defn elemento-central [lista]
  (nth lista (quot (count lista) 2)))

;; Asserts
(assert (= (elemento-central '(1 2 3 4 5)) 3))
(assert (= (elemento-central '(1)) 1))
(assert (= (elemento-central '(1 2)) 2))

