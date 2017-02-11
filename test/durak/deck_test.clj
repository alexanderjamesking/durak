(ns durak.deck-test
  (:require [clojure.test :refer [deftest testing is]]
            [durak.deck :refer :all]))

(deftest build-deck-of-cards
  (testing "build card"
    (let [card (build-card :hearts 12)]
      (is (= :hearts (:suit card)))
      (is (= 12 (:value card)))))

  (testing "card-symbol"
    (is (= "Q♥" (card-symbol (build-card :hearts 12))))
    (is (= "10♥" (card-symbol (build-card :hearts 10)))))

  (testing "suit-symbol"
    (is (= "♥" (suit-symbol :hearts)))
    (is (= "♠" (suit-symbol :spades)))
    (is (= "♦" (suit-symbol :diamonds)))
    (is (= "♣" (suit-symbol :clubs)))
    (is (= nil (suit-symbol :unknown))))

  (testing "suit contains 9 cards"
    (let [diamonds (build-suit :diamonds)]
      (is (= 9 (count diamonds)))))

  (testing "build deck"
    (let [deck (build-deck)]
      (is (= 36 (count deck)))))

  (testing "deck to symbols"
    (let [deck (set (deck-symbols (build-deck)))]
      (is (= 36 (count deck)))
      (assert (contains? deck "6♥"))
      (assert (contains? deck "7♥"))
      (assert (contains? deck "8♥"))
      (assert (contains? deck "9♥"))
      (assert (contains? deck "10♥"))
      (assert (contains? deck "J♥"))
      (assert (contains? deck "Q♥"))
      (assert (contains? deck "K♥"))
      (assert (contains? deck "A♥"))

      (assert (contains? deck "6♠"))
      (assert (contains? deck "7♠"))
      (assert (contains? deck "8♠"))
      (assert (contains? deck "9♠"))
      (assert (contains? deck "10♠"))
      (assert (contains? deck "J♠"))
      (assert (contains? deck "Q♠"))
      (assert (contains? deck "K♠"))
      (assert (contains? deck "A♠"))

      (assert (contains? deck "6♦"))
      (assert (contains? deck "7♦"))
      (assert (contains? deck "8♦"))
      (assert (contains? deck "9♦"))
      (assert (contains? deck "10♦"))
      (assert (contains? deck "J♦"))
      (assert (contains? deck "Q♦"))
      (assert (contains? deck "K♦"))
      (assert (contains? deck "A♦"))

      (assert (contains? deck "6♣"))
      (assert (contains? deck "7♣"))
      (assert (contains? deck "8♣"))
      (assert (contains? deck "9♣"))
      (assert (contains? deck "10♣"))
      (assert (contains? deck "J♣"))
      (assert (contains? deck "Q♣"))
      (assert (contains? deck "K♣"))
      (assert (contains? deck "A♣")))))
