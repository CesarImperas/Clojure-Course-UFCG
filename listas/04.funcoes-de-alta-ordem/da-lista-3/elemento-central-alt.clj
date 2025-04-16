(defn elemento-central [lista]
  (as-> lista $
      (count $)
      (quot $ 2)
      (nth lista $)))


;; Asserts
(assert (= (elemento-central '(1 2 3 4 5)) 3))
(assert (= (elemento-central '(1)) 1))
(assert (= (elemento-central '(1 2)) 2))

