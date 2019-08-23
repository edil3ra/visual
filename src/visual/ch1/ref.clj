(ns visual.ch1.ref
  (:require [quil.core :as q]
            [quil.middleware :as m]))


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
  (q/stroke-weight 1)

  )

(q/defsketch visual
  :title "You spin my circle right round"
  :size [50 50]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
