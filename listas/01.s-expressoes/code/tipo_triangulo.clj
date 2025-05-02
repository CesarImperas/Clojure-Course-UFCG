(defn eh-triangulo [a b c]
  (if (and (> a 0) (> b 0) (> c 0))
    (and (> (+ a b) c)
         (> (+ a c) b)
         (> (+ c b) a))))

(defn tipo-triangulo [a b c]
  (if (eh-triangulo a b c)
    (cond
          (and (= a b) (= b c)) :equilatero
          (or (= a b) (= b c) (= a c)) :isosceles
          :else :escaleno)
    nil))

;; Asserts
(assert (= (tipo-triangulo 3 3 3) :equilatero))
(assert (= (tipo-triangulo 3 4 3) :isosceles))
(assert (= (tipo-triangulo 3 4 5) :escaleno))
(assert (= (tipo-triangulo 1 2 3) nil))

