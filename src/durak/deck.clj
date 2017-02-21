(ns durak.deck
  (:require [clojure.spec :as s]))

(def suits (set '(:spades :hearts :diamonds :clubs)))

(s/def ::suit #{:spades :hearts :diamonds :clubs})

(s/def ::suit-sym #{"♠" "♥" "♦" "♣"})

(defn value-symbol [card-value]
  "Takes a card value and returns its symbol, e.g. J for 11, Q for 12"
  (case card-value
    11 "J"
    12 "Q"
    13 "K"
    14 "A"
    card-value))

(defn symbol-value [card-value]
  "Takes a card symbol and returns its value, e.g. 11 for J, 12 for Q"
  (case card-value
    "J" 11
    "Q" 12
    "K" 13
    "A" 14
    (read-string card-value)))

(defn suit-symbol [card-suit]
  {:pre [(s/valid? ::suit card-suit)]
   :post [(s/valid? ::suit-sym %)]
   }
  "Takes a card suit and returns its symbol, e.g. ♠ for :spades"
  (case card-suit
    :spades "♠"
    :hearts "♥"
    :diamonds "♦"
    :clubs "♣"
    (throw (new IllegalArgumentException))))

(defn symbol-suit [card-suit]
  "Takes a card symbol and returns its suit, e.g. :spades for ♠"
  (case card-suit
    "♠" :spades
    "♥" :hearts
    "♦" :diamonds
    "♣" :clubs
    (throw (new IllegalArgumentException))))

(defn build-card [suit value]
  {:suit suit :value value})

(defn symbol-tocard [sym]
  (let [suit (symbol-suit (str (last sym)))
        value (symbol-value (subs sym 0 (- (count sym) 1)))]
    (build-card suit value)))

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