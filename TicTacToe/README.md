## 2 Player Tic Tac Toe

A 2 player tic-tac-toe game should be played between 2 players present in the system. **The application will revolve around the following entities**:

1. Player
2. Game
3. Move

**A player can register with the following details**:

- First name
- Last name
- Contact
  - Email ID
  - Phone
- Link to Profile picture

Once the user completes registration, the system should also capture the time(Format: dd/MM/yyyy hh:mm:ss AM/PM), when the user has registered. **Every user will also have these 2 attributes**:

- Instance level attribute "ID"
- Static variable named "counter", which will be initialized with 1. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1.

**Each Game consists of multiple valid moves and a few other game level attributes**:

- ID (ID & counter needs to be maintained similar to that of the user)
- Start Timestamp
- Current Status
- List of moves
- End timestamp
- Winner
- Current Turn Player ID

A game will not have any value for the winner or end timestamp, until it's concluded. A game will conclude, when a user has won or when all the positions have been filled up, just like a physical tic-tac-toe game. Once a game has concluded, no further moves will be accepted.

**Each move will consist of the following details**:

- Player ID
- Marker symbol
- Horizontal position(HP)
- Vertical position(VP)

Please check the following diagram for understanding the horizontal & vertical position in detail:


+-------+------+----+

| HP = 1 | HP = 2 | HP = 3 |

| VP = 1 | VP = 1 | VP = 1 |

+-------+------+----+

| HP = 1 | HP = 2 | HP = 3 |

| VP = 2 | VP = 2 | VP = 2 |

+-------+-------+----+

| HP = 1 | HP = 2 | HP = 3 |

| VP = 3 | VP = 3 | VP = 3 |

+-------+-------+----+


Every move needs to be validated before accepting. A move will be considered invalid if the provided inputs for the horizontal or vertical positions are invalid or the corresponding place is already filled in the current game. After every move, the status & winner(if any) of the game needs to be calculated.

**A global Application class needs to be created for supporting the following operations**:

1. Register a user
2. Create a game between 2 existing players.
3. Let the 2 users play the game by entering their respective moves
4. Show the current status of the game
5. See the details of a user. It should print the user's profile attributes and the number of games the user has won and lost.