(ns durak.deck)

(def suits (set '(:spades :hearts :diamonds :clubs)))

(defn value-symbol [card-value]
  "Takes a card value and returns its symbol, e.g. J for 11, Q for 12"
  (case card-value
    11 "J"
    12 "Q"
    13 "K"
    14 "A"
    card-value))

(defn suit-symbol [card-suit]
  "Takes a card suit and returns its symbol, e.g. ♠ for :spades"
  (case card-suit
    :spades "♠"
    :hearts "♥"
    :diamonds "♦"
    :clubs "♣"
    nil))

(defn build-card [suit value]
  {:suit suit :value value})

(defn build-suit [suit]
  (set (map #(build-card suit %) (range 6 15))))

(defn card-symbol [card]
  (let [value (:value card)
        suit (:suit card)]
    (str (value-symbol value) (suit-symbol suit))))

(defn build-deck []
  (reduce concat (map build-suit suits)))

(defn deck-symbols [deck]
  (map #(card-symbol %) deck))