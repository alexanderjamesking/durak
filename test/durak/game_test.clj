(ns durak.game-test
  (:require [clojure.test :refer [deftest testing is]]
            [durak.deck :as deck]
            [durak.game :refer :all]))


(deftest build-deck-of-cards
  (testing "deal 6 cards each to two players"
    (let [players [:a :b]
          deck (shuffle (deck/build-deck))
          dealt-cards (deal-cards deck players)
          player-a-cards (:a dealt-cards)
          player-b-cards (:b dealt-cards)]

      ; 24 left in the deck after dealing
      (is (= 24 (count (:deck dealt-cards))))

      (is (= 6 (count player-a-cards)))
      (is (= (nth deck 0) (nth player-a-cards 0)))
      (is (= (nth deck 2) (nth player-a-cards 1)))
      (is (= (nth deck 4) (nth player-a-cards 2)))
      (is (= (nth deck 6) (nth player-a-cards 3)))
      (is (= (nth deck 8) (nth player-a-cards 4)))

      (is (= 6 (count player-b-cards)))
      (is (= (nth deck 1) (nth player-b-cards 0)))
      (is (= (nth deck 3) (nth player-b-cards 1)))
      (is (= (nth deck 5) (nth player-b-cards 2)))
      (is (= (nth deck 7) (nth player-b-cards 3)))
      (is (= (nth deck 9) (nth player-b-cards 4)))))

  (testing "use the last card as the trump card"
    (let [players [:a :b]
          d (shuffle (deck/build-deck))
          dealt-cards (deal-cards d players)
          player-a-cards (:a dealt-cards)
          player-b-cards (:b dealt-cards)]

      (is (= 24 (count (:deck dealt-cards))))

      (println (deck/deck-symbols d))

      (println (deck/deck-symbols (dealt-cards :deck)))


      (println "all... " (deck/deck-symbols d))
      (println "dealtE " (deck/deck-symbols (take 12 d)))
      (println "deckN: " (deck/deck-symbols (dealt-cards :deck)))
      (println "trump: " (nth (deck/deck-symbols d) 12))
      (println "a..... " (deck/deck-symbols (dealt-cards :a)))
      (println "b..... " (deck/deck-symbols (dealt-cards :b)))


      (println "B " (last (deck/deck-symbols d)))
      (println "A " (first (deck/deck-symbols (dealt-cards :deck))))

      ;(is (= 6 (count player-a-cards)))
      ;(is (= (nth deck 0) (nth player-a-cards 0)))
      ;(is (= (nth deck 2) (nth player-a-cards 1)))
      ;(is (= (nth deck 4) (nth player-a-cards 2)))
      ;(is (= (nth deck 6) (nth player-a-cards 3)))
      ;(is (= (nth deck 8) (nth player-a-cards 4)))
      ;
      ;(is (= 6 (count player-b-cards)))
      ;(is (= (nth deck 1) (nth player-b-cards 0)))
      ;(is (= (nth deck 3) (nth player-b-cards 1)))
      ;(is (= (nth deck 5) (nth player-b-cards 2)))
      ;(is (= (nth deck 7) (nth player-b-cards 3)))
      ;(is (= (nth deck 9) (nth player-b-cards 4)))
      ))
  )


