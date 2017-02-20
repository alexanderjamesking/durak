(ns durak.feature-test
  (:require [clojure.test :refer [deftest testing is]]
            [durak.deck :as deck]
            [durak.game :as game]))

(defn start-a-game-with-two-players []
  (let [players [:a :b]]
    (game/start players (deck/build-deck))))

(defn assert-player-card-count [player expected-count]
  (is (= expected-count (count (game/get-cards player)))))

(defn assert-cards-in-deck [expected-count]
  (is (= expected-count (count (game/get-deck)))))

(defn assert-trump-suit-defined []
  (assert (contains? deck/suits (game/get-trump-suit))))

; start game
; attack
; defend
; end attack
; pick-up-field

(deftest start-game-with-two-players

  (start-a-game-with-two-players)

  (testing "players are dealt 6 cards each"
    (assert-player-card-count :a 6)
    (assert-player-card-count :b 6))

  (testing "the trump suit is defined"
    (assert-trump-suit-defined))

  (testing "there are 24 cards left in the deck"
    (assert-cards-in-deck 24))

)
