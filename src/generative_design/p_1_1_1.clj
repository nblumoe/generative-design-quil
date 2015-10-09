(ns generative-design.p-1-1-1
  (:require [quil
             [core :as q]
             [middleware :as m]]))

(defn setup []
  (q/background 0)
  (q/no-cursor)
  (q/no-stroke))

(defn update-state [state]
  state)

(defn draw-state [state]
  (q/color-mode :hsb (q/width) (q/height) 100)
  (let [step-x (+ 2 (q/mouse-x))
        step-y (+ 2 (q/mouse-y))]
    (doseq [y (range 0 (q/height) step-y)
            x (range 0 (q/width) step-x)]
      (q/fill x (- (q/height) y) 100)
      (q/rect x y step-x step-y))))

#_
(q/defsketch color-spectrum
  :title "Color spectrum in a grid P.1.1.1"
  :size [800 400]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top :resizable]
  :middleware [m/fun-mode])
