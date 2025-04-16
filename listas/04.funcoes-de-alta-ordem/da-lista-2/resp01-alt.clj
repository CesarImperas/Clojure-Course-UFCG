(defn msg-rec [palavra]
  (println palavra)
  (doall (map msg-rec [palavra]))) 
 

(defn -main []
 (msg-rec (read)))

(-main)

