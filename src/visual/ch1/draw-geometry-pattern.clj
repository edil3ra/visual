(ns visual.ch1.draw-geometry-pattern
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
  (q/with-translation [0 0]
    (q/with-rotation [0]
      (d/lines-geometry 10 :start 50 :progressive 1.303 :size 500)
      (q/rotate (/ Math/PI 2))
      (q/translate [0 -500])
      (d/lines-geometry 10 :start 50 :progressive 1.305 :size 500)
    ))


  (q/save "generated/box3.png")
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
