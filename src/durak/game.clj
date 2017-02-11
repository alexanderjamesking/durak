(ns durak.game
  (require
    [durak.deck :refer [deck-symbols]]
    [clojure.pprint :refer [pprint]]
    ))

(defn deal-cards [deck players]

  (let [to-deal (take 12 deck)
        remaining (drop 12 deck)
        trump (take 1 remaining)
    _ (println trump)
        new-deck (conj (vec (drop 1 remaining)) trump)
        _ (println (last new-deck))
        deal-order (take 12 (cycle players))
        dealt (mapv (fn [k v] [k v]) deal-order to-deal)
        grouped (group-by (fn [e] (first e)) dealt)
        myreducer (fn [acc i]
                    (assoc acc i (map second (grouped i))))
        res (reduce myreducer {} players)
        out (conj res {:deck remaining :trump-suit :hearts})]


    (println (deck-symbols deck))

    (println "to deal: " (deck-symbols to-deal))


    (println "a: " (deck-symbols (:a out)))
    (println "b: " (deck-symbols (:b out)))
    (println "remaining: " (deck-symbols remaining))
    (println "trump: " trump)
    (println (last new-deck))

    (println (count new-deck))
    (println (type new-deck))
    (println (count (deck-symbols new-deck)))
    (println (type (deck-symbols new-deck)))

    (println "===")
    (println (vec (deck-symbols new-deck)))
    (println "===")
    ;(println "new-deck: "  new-deck)

    out
    )
  )


; (defn p [i] (println (:key i)) (:key i))

;(def x (mapv (fn [k v] { :key k :value v }) (take 12 (cycle #{:b :a})) to-deal))