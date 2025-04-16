(defn soma-alternados [sequencia]
  (->> (map-indexed vector sequencia)
       (filter #(even? (first %)))
       (map second)
       (reduce + 0)))

(defn soma-alternados-2 [sequencia]
  (->> (keep-indexed #(when (even? %1) %2) sequencia)
       (reduce + 0)))

;; Asserts
(assert (= (soma-alternados-2 '(1 2 3 4 5 6)) 9))
(assert (= (soma-alternados-2 '(1 2 3)) 4))
(assert (= (soma-alternados-2 '(2)) 2))
(assert (= (soma-alternados-2 '()) 0))

