(defn msg-rec [palavra]
  (println palavra)
  (msg-rec palavra))

(defn -main []
  (msg-rec (read)))

(-main)


;; Explicação do erro:
;;
;; Como estamos realizando o processo __ad infinitum__ (algo como "até o infinito"),
;; não temos uma condição de parada explícita. Isso faz com que o programa seja executado
;; de tal forma que o único meio de ser encerrado é a própria exceção de `StackOverflowError`
;; ser lançada, no qual, ocorre quando a pilha de chamadas de execução da função recursiva, acaba
;; sendo consumida por completa (esse limite estabelecido pela linguagem, é uma das camadas
;; de segurança para evitar o consumo descontrolado dessa pilha). De modo geral, essa exceção
;; é uma resposta de forma carinhosa para o programador, de que o mesmo está realizando uma
;; computação de maneira errônea ou não eficiente (do ponto de vista recursivo).

