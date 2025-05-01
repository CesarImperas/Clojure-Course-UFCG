;; Snake Game Functional in Clojure - Caio Cesar Vieira Cavalcanti - 123110825 - 01/05/2025
;; Problema - A cobra não se movimenta a cada tick automaticamente


(ns snake-game
  (:require [clojure.string :as str])
  (:import [org.jline.terminal TerminalBuilder Terminal]
           [org.jline.reader.impl LineReaderImpl]))

;; ---------------------------------------------------------------------
;; Constants and utility functions
;; ---------------------------------------------------------------------

(def WIDTH 20)
(def HEIGHT 10)
(def TICKRATE 300)

(def directions {:UP [0 -1]
                 :DOWN [0 1]
                 :LEFT [-1 0]
                 :RIGHT [1 0]})

(def opposites {:UP :DOWN, :DOWN :UP, :LEFT :RIGHT, :RIGHT :LEFT})

(def terminal (-> (TerminalBuilder/builder)
                  (.jna true)
                  (.system true)
                  (.build)))

(def reader (.reader terminal))

(defn set-raw-mode []
  (.enterRawMode terminal))

(defn restore-mode []
  (.close terminal))

(defn wait [ms]
  (Thread/sleep ms))

(defn clear-screen []
  (print "\033[H\033[2J")
  (flush))

;; Random function
(defn rand-pos [snake]
  (let [pos {:x (rand-int WIDTH)
             :y (rand-int HEIGHT)}]
    (if (some #(= pos %) snake)
      (recur snake)
      pos)))

;; ---------------------------------------------------------------------
;; Snake functions
;; ---------------------------------------------------------------------


(defn move-head [head dir]
  (let [[dx dy] (get directions dir)]
    {:x (+ (:x head) dx)
     :y (+ (:y head) dy)}))

(defn collision? [pos snake]
  (or (< (:x pos) 0) (>= (:x pos) WIDTH)
      (< (:y pos) 0) (>= (:y pos) HEIGHT)
      (some #(= pos %) snake)))

(defn update-snake [snake head ate?]
  (if ate?
    (cons head snake)
    (cons head (butlast snake))))

(defn next-state [state]
  (let [head (move-head (first (:snake state)) (:direction state))
        ate? (= head (:food state))
        new-snake (update-snake (:snake state) head ate?)
        dead? (collision? head (:snake state))]
    {:snake new-snake
     :direction (:direction state)
     :food (if ate? (rand-pos new-snake) (:food state))
     :game-over? dead?
     :history (conj (:history state) state)}))

;; ---------------------------------------------------------------------
;; Render terminal
;; ---------------------------------------------------------------------

(defn render-cell [snake food x y]
  (cond
    (= {:x x :y y} (first snake)) "S"
    (some #(= {:x x :y y} %) (rest snake)) "s"
    (= {:x x :y y} food) "*"
    :else "-"))

(defn render [state]
  (clear-screen)
  (doseq [y (range HEIGHT)]
    (println (apply str (for [x (range WIDTH)] (render-cell (:snake state) (:food state) x y))))))

;; ---------------------------------------------------------------------
;; Input - Keyboard WASD directions
;; ---------------------------------------------------------------------

(defn read-key []
  (let [key (.read reader)]
    (when (not= key -1) ;; -1 means no key pressed
      key)))

(defn key->dir [k]
  (case k
    119 :UP
    115 :DOWN
    97 :LEFT
    100 :RIGHT
    nil))

(defn update-dir [direction input-dir]
  (if (and input-dir (not= (opposites input-dir) direction))
    input-dir
    direction))

;; ---------------------------------------------------------------------
;; Replay
;; ---------------------------------------------------------------------

(defn replay [history]
  (doseq [s history]
    (render s)
    (wait 200))
  (println "Replay finished")
  (println "Thanks for playing the Snake Game by Caio Cesar s2"))

;; ---------------------------------------------------------------------
;; Game loop
;; ---------------------------------------------------------------------

(defn loop-game [state]
  (render state)
  (if (:game-over? state)
    (do
      (println "\nGame Over! Replay in 3s")
      (wait 3000)
      (replay (:history state)))
    (let [input (read-key)
          new-dir (if input
                    (update-dir (:direction state) (key->dir input))
                    (:direction state))
          nextS (next-state (assoc state :direction new-dir))]
      (wait TICKRATE)
      (recur nextS))))


;; ---------------------------------------------------------------------
;; Main
;; ---------------------------------------------------------------------

(defn -main []
  (set-raw-mode)
  (try
    (let [initial {:snake [{:x 5 :y 5}]
                   :direction :RIGHT
                   :food {:x 10 :y 5}
                   :game-over? false
                   :history []}]
      (loop-game initial))
    (finally
      (restore-mode))))

(-main)




