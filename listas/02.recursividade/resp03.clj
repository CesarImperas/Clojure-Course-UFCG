(defn conta
  ([num] 
   (println num) 
   (conta (inc num)))
  ([] (conta 0)))

(conta)

