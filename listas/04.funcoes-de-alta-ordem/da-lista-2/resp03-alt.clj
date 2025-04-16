(defn conta 
  ([num]
    (doseq [x (iterate inc num)]
      (println x)))
  ([] (conta 0)))

(conta)

