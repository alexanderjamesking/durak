(ns durak.game-test
  (:require [clojure.test :refer [deftest testing is]]
            [durak.deck :as deck]
            [durak.game :as game]))

(defn get-intervals-for-player [num-players player-index]
  (map #(+ % player-index) (filter #(zero? (mod % num-players)) (range (- (* 6 num-players) 1)))))

(defn verify-players-cards [deck players dealt-cards]
  (let [num-players (count players)]
    (doseq [player (map-indexed vector players)]
      (let [[player-index player-name] player
            players-cards (player-name dealt-cards)]
        (is (= game/cards-per-player (count players-cards)))
        (let [intervals (get-intervals-for-player num-players player-index)]
          (doseq [i (range game/cards-per-player)]
            (is (= (nth deck (nth intervals i)) (nth players-cards i)))))))))

(defn verify-cards-remaining-count [dealt-cards players]
  (let [num-players (count players)]
    (is (= (- (count (deck/build-deck)) (* game/cards-per-player num-players)) (count (:deck dealt-cards))))))

(deftest build-deck-of-cards
  (testing "use the last card in the altered deck as the trump card"
    (let [deck (take 12 (shuffle (deck/build-deck)))
          trump (first deck)
          altered-deck (game/move-trump-card-to-end deck)]
      (is (= (count deck) (count altered-deck)))
      (is (= trump (last altered-deck)))))

  (testing "deal 6 cards each to two players"
    (let [players [:a :b]
          deck (shuffle (deck/build-deck))
          dealt-cards (game/deal-cards deck players)]
      (verify-cards-remaining-count dealt-cards players)
      (verify-players-cards deck players dealt-cards)))

  (testing "deal 6 cards each to three players"
    (let [players [:a :b :c]
          deck (shuffle (deck/build-deck))
          dealt-cards (game/deal-cards deck players)]
      (verify-cards-remaining-count dealt-cards players)
      (verify-players-cards deck players dealt-cards)))

  (testing "deal 6 cards each to four players"
    (let [players [:a :b :c :d]
          deck (shuffle (deck/build-deck))
          dealt-cards (game/deal-cards deck players)]
      (verify-cards-remaining-count dealt-cards players)
      (verify-players-cards deck players dealt-cards))))
