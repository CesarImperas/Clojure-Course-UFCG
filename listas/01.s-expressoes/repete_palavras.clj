(defn repete-palavras [palavra qntd]
  (when (> qntd 0)
    (println palavra)
    (repete-palavras palavra (dec qntd))))

(defn -main []
  (println "Digite a palavra: ")
  (let [palavra (read-line)]
    (println "Digite a quantidade a ser repetida: ")
    (let [quantidade (Integer/parseInt (read-line))]
      (repete-palavras palavra quantidade))))

(-main)

