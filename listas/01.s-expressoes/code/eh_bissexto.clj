(defn eh-bissexto [ano]
  (cond
        (zero? (mod ano 400)) true
        (zero? (mod ano 100)) false
        (zero? (mod ano 4)) true
        :else false))


;; Asserts 
(assert (= (eh-bissexto 2000) true))
(assert (= (eh-bissexto 1900) false))
(assert (= (eh-bissexto 2200) false))

