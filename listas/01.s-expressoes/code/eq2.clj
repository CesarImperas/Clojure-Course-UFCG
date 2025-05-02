(defn raizes [a b c]
  (let [delta (- (* b b) (* 4.0 a c))
        root (fn [op] (/ (op (- b) (Math/sqrt delta)) (* 2 a)))]
    (cond
      (neg? delta) "Sem raizes no conjunto dos números reais"
      (zero? delta) (format "As duas raizes reais são iguais a: %.2f" (root +))
      :else (format "As duas raizes reais são %.2f e %.2f" (root +) (root -)))))

(defn -main []
  (println "Digite o coeficiente a: ")
  (let [a (Integer/parseInt (read-line))]
    (println "Digite o coeficiente b: ")
    (let [b (Integer/parseInt (read-line))]
      (println "Digite o coeficiente c: ")
      (let [c (Integer/parseInt (read-line))]
        (println "Raizes:" (raizes a b c))))))

(-main)
