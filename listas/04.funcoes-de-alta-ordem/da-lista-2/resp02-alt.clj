(defn conta-rec [num]
  (doseq [x (iterate inc num)]
    (println x)))

(defn conta []
  (conta-rec 0))

(conta)

