(ns durak.deck-test
  (:require [clojure.test :refer :all]
            [durak.deck :refer :all]))

(defn assert-contains-suit [deck suit]
  (let [sym (suit-symbol suit)]
    (doseq [x (conj (range 6 11) "J" "Q" "K" "A")]
      (assert (contains? deck (str x sym))))))

(deftest build-deck-of-cards
  (testing "build card"
    (let [card (build-card :hearts 12)]
      (is (= :hearts (:suit card)))
      (is (= 12 (:value card)))))

  (testing "build card from symbol"
    (is (= (build-card :hearts 12) (symbol-tocard "Q♥")))
    (is (= (build-card :diamonds 10) (symbol-tocard "10♦")))
    (is (= (build-card :clubs 11) (symbol-tocard "J♣")))
    (is (= (build-card :spades 13) (symbol-tocard "K♠")))
    (is (= (build-card :spades 14) (symbol-tocard "A♠"))))

  (testing "build card from symbol throws IllegalArgumentException for unknown suit"
    (is (thrown? IllegalArgumentException (symbol-tocard "9X")))
    (is (thrown? IllegalArgumentException (symbol-tocard "10%"))))

  (testing "card-symbol"
    (is (= "Q♥" (card-symbol (build-card :hearts 12))))
    (is (= "10♥" (card-symbol (build-card :hearts 10)))))

  (testing "suit-symbol"
    (is (= "♥" (suit-symbol :hearts)))
    (is (= "♠" (suit-symbol :spades)))
    (is (= "♦" (suit-symbol :diamonds)))
    (is (= "♣" (suit-symbol :clubs)))
    (is (thrown? IllegalArgumentException (suit-symbol :unknown))))

  (testing "suit contains 9 cards"
    (let [diamonds (build-suit :diamonds)]
      (is (= 9 (count diamonds)))))

  (testing "build deck"
    (let [deck (build-deck)]
      (is (= 36 (count deck)))))

  (testing "deck to symbols"
    (let [deck (set (deck-symbols (build-deck)))]
      (is (= 36 (count deck)))
      (assert-contains-suit deck :hearts)
      (assert-contains-suit deck :diamonds)
      (assert-contains-suit deck :spades)
      (assert-contains-suit deck :clubs))))
