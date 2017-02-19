Feature: Durak

#  Background:
#    Given the trump suit is Hearts
#    And the players
#      | Boris |
#      | Igor  |
#    When the cards are dealt
#    Then the game starts

  Scenario: Boris attacks Igor
    Given the cards
      | player | cards              |
      | Boris  | 6♦ 7♣ A♣ 10♠ 9♥ Q♥ |
      | Igor   | Q♦ 7♦ J♠ J♥ A♦ 8♥  |
    And Boris is the attacker
    When Boris attacks with the 6♦
    Then Igor responds with the 7♦
