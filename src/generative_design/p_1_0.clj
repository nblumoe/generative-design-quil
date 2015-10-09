(ns generative-design.p-1-0
  (:require [quil
             [core :as q]
             [middleware :as m]]))

(defn setup []
  (q/no-cursor))

(defn update-state [state]
  state)

(defn draw-state [state]
  (q/color-mode :hsb 360 100 100)
  (q/rect-mode :center)
  (q/no-stroke)
  (q/background (/ (q/mouse-y) 2) 100 100)
  (q/fill (- 360 (/ (q/mouse-y) 2)) 100 100)
  (q/rect 360 360 (inc (q/mouse-x)) (inc (q/mouse-x))))

#_
(q/defsketch hello-color
  :title "Hello Color P.1.0"
  :size [720 720]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top :resizable]
  :middleware [m/fun-mode])
