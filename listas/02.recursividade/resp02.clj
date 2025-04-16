(defn conta-rec [num]
  (println num)
  (conta-rec (inc num)))

(defn conta []
  (conta-rec 0))

(conta)

;; Explicação do uso das duas funções:
;;
;; Necessitamos de duas funções, pois uma - função `conta` - não recebe argumento (aridade 0 ou nula) e, portanto, não pode ser a função recursiva que imprime
;; um valor e o incrementa a cada chamada, visto que necessita ter aridade 1 (o que não acontece na função `conta`), sendo necessário a criação
;; da função auxiliar recursiva `conta-rec`, que é invocada a partir da chamada da função principal do programa.

