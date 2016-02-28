(ns questions.histogram)

(defn bins
  "Takes a data collection and returns a list of maps holding the label and
  x-axis value."
  [coll]
  (let [k (Math/sqrt (count coll))
        min (apply min coll)
        max (apply max coll)
        spread (inc (- max min))
        width (Math/ceil (/ spread k))
        starts (take-while #(< % max) (iterate #(+ % width) min))
        label #(str % "-" (+ % width))]
    (map #(hash-map :x % :label (label %)) starts)))

(bins (range 10))
;; =>
;; ({:label "0-4.0", :x 0}
;;  {:label "4.0-8.0", :x 4.0}
;;  {:label "8.0-12.0", :x 8.0})

(def rolls [20 47 41 73 74 2 52 85 35 48 82 54 57 96 100 32 53 53 60 71])

(bins rolls)
;; =>
;; ({:label "2-25.0", :x 2}
;;  {:label "25.0-48.0", :x 25.0}
;;  {:label "48.0-71.0", :x 48.0}
;;  {:label "71.0-94.0", :x 71.0}
;;  {:label "94.0-117.0", :x 94.0})

(defn to-histogram
  "Takes a list of values, puts them into bins."
  [ls])
