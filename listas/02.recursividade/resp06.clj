(defn conta [num]
  (doseq [x (range (inc num))] (println x)))

(defn -main []
  (print "> Digite o número para a contagem de 0 até ele: ")
  (flush)
  (conta (Integer/parseInt (read-line))))

(-main)

