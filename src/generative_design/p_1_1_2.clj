(ns generative-design.p-1-1-1
  (:require [quil
             [core :as q]
             [middleware :as m]]))

(defn setup []
  (q/no-cursor)
  (q/no-stroke)
  (q/smooth)
  {:angle-step 10
   :radius 200})

(defn update-state [state]
  (assoc state :radius (- (/ (q/height) 2) 30)))

(defn draw-state [{:keys [angle-step radius]}]
  (q/color-mode :hsb 360 (q/width) (q/height))
  (q/background 30)

  (q/begin-shape :triangle-fan)
  (q/vertex (/ (q/width) 2) (/ (q/height) 2))
  (doseq [angle (range 0 361 angle-step)]
    (q/vertex (+ (/ (q/width) 2)
                 (* radius (q/cos (q/radians angle))))
              (+ (/ (q/height) 2)
                 (* radius (q/sin (q/radians angle)))))
    (q/fill angle (q/mouse-x) (q/mouse-y)))
  (q/end-shape))

(defn key-typed [state {:keys [key]}]
  (let [angle-step #(/ 360 %)]
    (assoc state :angle-step (case key
                               :1 (angle-step 360)
                               :2  (angle-step 45)
                               :3 (angle-step 24)
                               :4 (angle-step 12)
                               :5 (angle-step 6)))))

#_
(q/defsketch color-spectrum-circle
  :title "Color spectrum in a circle P.1.1.2"
  :size [800 400]
  :setup setup
  :update update-state
  :draw draw-state
  :key-typed key-typed
  :features [:keep-on-top :resizable]
  :middleware [m/fun-mode])
