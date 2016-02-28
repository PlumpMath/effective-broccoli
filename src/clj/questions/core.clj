(ns questions.core
  (:require [vizard.core :refer :all]
            [vizard.plot :as plot]
            [incanter.core :as i]
            [incanter.charts :as charts]
            [incanter.stats :as stats]))

(start-plot-server!)

(defn group-data [& names]
  (apply concat (for [n names]
                  (map-indexed (fn [i x] {:x i :y x :col n}) (take 20 (repeatedly #(rand-int 100)))))))

(defn heat-data [w h]
  (for [x (range w)
        y (range h)]
    {:x x :y y :z (rand)}))

(plot! (plot/vizard {:mark-type :bar
                     :encoding {:x {:field :x :scale :ordinal}
                                :y {:field :y :scale :linear}
                                :g {:field :col}}
                     :color "category20b"
                     :legend? true}
                    (group-data "foo" "bar" "baz" "poot")))

(plot! (plot/vizard {:mark-type :line
                     :encoding {:x {:field :x :scale :linear}
                                :y {:field :y :scale :linear}
                                :g {:field :col}}
                     :color "category20b"
                     :legend? true}
                    (group-data "foo" "bar" "baz" "poot")))

(plot! (plot/vizard {:mark-type :heatmap
                     :encoding {:x {:field :x :scale :ordinal}
                                :y {:field :y :scale :ordinal}
                                :z {:field :z}}
                     :legend? true}
                    (heat-data 20 20)))

