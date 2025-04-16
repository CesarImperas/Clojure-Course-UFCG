(defn conta []
  (dorun (map println (iterate inc 0))))

(conta)

