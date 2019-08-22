(ns visual.ch1.stair
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn d-diagonal [x y & [x-size y-size]]
  (let [x-size (or x-size 40) y-size (or y-size 40)]
    (q/line (+ x 0) y (+ x x-size) (+ y y-size))
    (q/line (+ x 10) y (+ x 10 x-size) (+ y y-size))
    (q/line (+ x 20) y (+ x 20 x-size) (+ y y-size))))


(defn init []
  {:x 200 :y 200
   :diagonals (mapv (fn [i] {:x (* i 30) :y (* i 20)}) (range 20))
   })

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :rgb)
  (init))

(defn update-state [s]
  (def s s)
  (let [x-update (inc (:x s))]
    (assoc s
           :x x-update)))

(defn draw-state [s]
  (q/background 0)
  (q/stroke 255)
  (q/stroke-weight 5)
  (q/smooth)
  (let [diagonals (:diagonals s)]
    (doseq [diagonal diagonals]
      (d-diagonal (:x diagonal) (:y diagonal) 100 20)
      )
    )
  ;; (digonal 10 10)
  ;; (digonal 100 100)
  ;; (digonal 200 200)
  )

(q/defsketch visual
  :title "You spin my circle right round"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode])
