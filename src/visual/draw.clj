(ns visual.draw
  (:require [quil.core :as q]))


(defn horizontal-lines [count & {:keys [gap horizontal-size] :or {gap 5 horizontal-size 200}} ]
    (doseq [i (range count)]
      (q/line 0 (* i gap) horizontal-size (* i gap))
      ))


(defn vertical-lines [count & {:keys [gap vertical-size] :or {gap 5 vertical-size 200}} ]
    (doseq [i (range count)]
      (q/line (* i gap) 0 (* i gap) vertical-size)
      ))


(defn lines [count & {:keys [deg size gap] :or {size 200 gap 5 deg 0}} ]
  (q/with-rotation [(q/radians deg)]
    (doseq [i (range count)]
      (q/line 0 (* i gap) size (* i gap)))))


(defn lines-geometry [count & {:keys [size start progressive deg] :or {size 200 start 5 progressive 1 deg 0}} ]
  (q/with-rotation [(q/radians deg)]
    (let [hlines (->> (take count (repeat progressive)) 
                      (reduce (fn [acc next] (conj acc (* next (last acc)))) [start])
                      (map (fn [x] (- x start)))
                      (drop-last))]
    (doseq [h hlines]
      (q/line 0 h size h)))))


(defn lines-by [count & {:keys [horizontal-length offset-length offset-split vertical-gap]
                         :or {horizontal-length 200 offset-length 20 offset-slpit 4 vertical-gap 5}} ]
  (let [xs (->> (range (/ count offset-split))
                (map (fn [i] (take offset-split (repeat i)))) 
                (flatten)
                (vector (range count))
                (apply map vector)
                (map (fn [[i offset-count]]
                       (let [offset-length (* offset-length offset-count)]
                         [[0 (* i vertical-gap )] [(+ horizontal-length offset-length) (* i vertical-gap )]]))))
        ]
    (doseq [x xs]
      (apply q/line x)
      )  
    )
  )


(->> (range (/ 20 4))
     (map (fn [i] (take 5 (repeat i)))) 
     (flatten)
     (vector (range 20))
     (apply map vector)
     (map (fn [[i offset]]
            (let [offset-size (* offset 20)]
              [[0 (* i 5 )] [(+ 200 offset-size) (* i 5 )]]))))


