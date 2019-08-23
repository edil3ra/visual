(ns visual.ch1.multiple-lines
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [visual.draw :as d]
            ))


(def w-size 500)
(def h-size 500)

(defn init []
  {:width 200 :height 100})

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :rgb)
  (init))

(defn update-state [s]
  (def s s)
  (let []
    s
    ))

(defn draw-state [s]
  (q/background 0)
  (q/stroke 255)
  (doseq [[deg [x y]]
          (map list (mapv #(* %1 (/ Math/PI 2)) (range 0 4)) [[0 0] [500 0] [500 500] [0 500]])]
    (q/with-translation [x y] 
      (q/with-rotation [deg]
        (d/horizontal-lines (/ w-size 40) :gap 6 :hline-size 500)
        (d/vertical-lines (/ w-size 20) :gap 12 :vertical-size 500)))
    )
  (q/save "generated/box.png")
  (q/exit)
)

(q/defsketch visual
  :title "lines"
  :size [w-size h-size]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
