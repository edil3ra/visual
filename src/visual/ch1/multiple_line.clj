(ns visual.ch1.multiple-line
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn d-diagonal [x y & [x-size y-size]]
  (let [x-size (or x-size 40) y-size (or y-size 40)]
    (q/line (+ x 0) y (+ x x-size) (+ y y-size))
    (q/line (+ x 5) y (+ x 5 x-size) (+ y y-size))
    (q/line (+ x 10) y (+ x 10 x-size) (+ y y-size))))

(defn init []
  {:x 200 :y 200
   :diagonals (mapv (fn [i] {:x (* i 30) :y (* i 20)}) (range 10))})

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :rgb)
  (init))

(defn update-state [s]
  (def s s)
  (let [x-update (inc (:x s))]
    (assoc s :diagonals
           (mapv (fn [diagonal]
                   (if (>= (:x diagonal) 500)
                     (assoc diagonal :x 0)
                     (update diagonal :x inc)))
                 (:diagonals s)))))

(defn draw-state [s]
  (q/background 0)
  (q/stroke 255)
  (q/stroke-weight 2)
  (q/smooth)
  (let [diagonals (:diagonals s)]
    (doseq [diagonal diagonals]
      (d-diagonal (:x diagonal) (:y diagonal) 100 200))))

(q/defsketch visual
  :title "You spin my circle right round"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
