(ns questions.dice
  (:require [incanter.core :as i]
            [incanter.charts :as charts]
            [incanter.stats :as stats]))

(def roll-price 1)

(def profit (atom 0))

(defn roll-die []
  (inc (rand-int 100)))

(defn naive-strategy
  "Return value of true means you should take the payout."
  [n-prev-rolls roll]
  (> roll 60))

(defn play-roll [strategy roll]
  )

(defn gamble []
  (let [rolls (repeatedly roll-die)]
    ))
