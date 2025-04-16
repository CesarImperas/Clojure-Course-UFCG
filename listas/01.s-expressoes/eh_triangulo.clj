(defn eh-triangulo [a b c]
  (and
       (> a 0)
       (> b 0)
       (> c 0)
       (< a (+ b c))
       (< b (+ a c))
       (< c (+ a b))))

;; Asserts
(assert (= (eh-triangulo 3 4 5) true))
(assert (= (eh-triangulo 1 2 3) false))
(assert (= (eh-triangulo 0 4 5) false))
(assert (= (eh-triangulo 5 5 8) true))
