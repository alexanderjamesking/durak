# Durak [![Build Status](https://travis-ci.org/alexanderjamesking/durak.svg?branch=master)](https://travis-ci.org/alexanderjamesking/durak)
One day this will hopefully be a playable version of the Durak card game...

## Phases
### Configure
- Number of players

### Begin
- Deal 6 cards to each player
- Turn the first card to choose which suit is the trump card
- Choose starting defender
- Choose starting attacker (player to the left of the defender)

### Rounds
- Attacker adds one or more cards to the field
- Defender defends by playing a higher card of the same suit or a trump card to the field
- Other players who are not the defender can also attack...
- Attack finishes with either a successful attack or a successful defence
  - Successful Attack
  - Successful Defence
- Next...
  - discard any cards added that were not picked up
  - players pick cards from the deck until they have a full hand (clockwise, attacker first) or deck exhausted
  - choose next defender
  - choose next attacker
  - Repeat until no more rounds are possible (only one player left)

### End
- The remaining player left in the game is the fool


## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2017 Alex King
