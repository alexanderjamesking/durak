(ns durak.game)

(def cards-per-player 6)

(defn move-trump-card-to-end [cards]
  (conj (vec (rest cards)) (first cards)))

(defn deal-cards [deck players]
  "Deals 6 cards to each player, puts trump card to the end of the deck.
  Returns a map containing deck, trump suit, player name -> cards
  e.g.
  {
    :deck [ vector of cards]
    :trump-suit :hearts
    :player-a [ 6 cards ]
    :player-b [ 6 cards ]
  }
  "
  (let [num-cards-to-deal (* (count players) cards-per-player)
        cards-to-deal (take num-cards-to-deal deck)
        remaining (drop num-cards-to-deal deck)
        trump-card (first remaining)
        deck-remaining-after-dealing (move-trump-card-to-end remaining)
        deal-order (take num-cards-to-deal (cycle players))
        ; map deal-order with cards-to-deal to create a map of player to card
        dealt (mapv (fn [k v] [k v]) deal-order cards-to-deal)
        extract-player (fn [e] (first e))
        grouped-by-player (group-by extract-player dealt)
        extract-cards-for-player (fn [acc player] (assoc acc player (map second (grouped-by-player player))))
        map-of-player-name-to-cards (reduce extract-cards-for-player {} players)]
    (conj map-of-player-name-to-cards {:deck deck-remaining-after-dealing
                                       :trump-suit (:suit trump-card)})))