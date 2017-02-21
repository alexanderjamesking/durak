(ns durak.deck-test
  (:require [clojure.test :refer [deftest testing is]]
            [durak.deck :as deck]))

(defn assert-contains-suit [deck suit]
  (let [sym (deck/suit-symbol suit)]
    (doseq [x (conj (range 6 11) "J" "Q" "K" "A")]
      (assert (contains? deck (str x sym))))))

(deftest build-deck-of-cards
  (testing "build card"
    (let [card (deck/build-card :hearts 12)]
      (is (= :hearts (:suit card)))
      (is (= 12 (:value card)))))

  (testing "build card from symbol"
    (is (= (deck/build-card :hearts 12) (deck/symbol-tocard "Q♥")))
    (is (= (deck/build-card :diamonds 10) (deck/symbol-tocard "10♦")))
    (is (= (deck/build-card :clubs 11) (deck/symbol-tocard "J♣")))
    (is (= (deck/build-card :spades 13) (deck/symbol-tocard "K♠")))
    (is (= (deck/build-card :spades 14) (deck/symbol-tocard "A♠"))))

  (testing "build card from symbol throws IllegalArgumentException for unknown suit"
    (is (thrown? IllegalArgumentException (deck/symbol-tocard "9X")))
    (is (thrown? IllegalArgumentException (deck/symbol-tocard "10%"))))

  (testing "card-symbol"
    (is (= "Q♥" (deck/card-symbol (deck/build-card :hearts 12))))
    (is (= "10♥" (deck/card-symbol (deck/build-card :hearts 10)))))

  (testing "suit-symbol"
    (is (= "♥" (deck/suit-symbol :hearts)))
    (is (= "♠" (deck/suit-symbol :spades)))
    (is (= "♦" (deck/suit-symbol :diamonds)))
    (is (= "♣" (deck/suit-symbol :clubs)))
    (is (thrown? AssertionError (deck/suit-symbol :unknown))))

  (testing "suit contains 9 cards"
    (let [diamonds (deck/build-suit :diamonds)]
      (is (= 9 (count diamonds)))))

  (testing "build deck"
    (let [deck (deck/build-deck)]
      (is (= 36 (count deck)))))

  (testing "deck to symbols"
    (let [deck (set (deck/deck-symbols (deck/build-deck)))]
      (is (= 36 (count deck)))
      (assert-contains-suit deck :hearts)
      (assert-contains-suit deck :diamonds)
      (assert-contains-suit deck :spades)
      (assert-contains-suit deck :clubs))))
