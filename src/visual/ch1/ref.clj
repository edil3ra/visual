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
