(defn conta [num]
  (dorun (map println (range (inc num)))))

(defn -main []
  (print "> Digite o número para a contagem de 0 até ele: ")
  (flush)
  (conta (Integer/parseInt (read-line))))

(-main)

