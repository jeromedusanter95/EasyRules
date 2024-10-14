package com.jeromedusanter.youonlyneedcards.domain

private val thirtyOne = GameModel(
    id = 1,
    name = "31",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.ELIMINATION),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "The goal of the game is to get the highest number of points without exceeding 31.",
    material = "A deck of 36 cards (from 6 to Ace)",
    howToPlay = """
        One player is designated as the dealer. After shuffling the deck, they discreetly check the first 3 cards. They can choose to keep them if they like, or place them face-up in the center of the table and take the next 3 cards from the deck. If they keep the first 3 cards, they put the next ones in the center and then deal three cards to each player. The player to the dealer’s left starts the game.

        On their turn, the player has several options:
        - They can exchange one of their cards with one from the center (then the next player takes their turn).
        - They can exchange all their cards with those in the center (then the next player takes their turn).
        - They can choose not to exchange any cards and pass their turn. This triggers the last round, where each player plays one last time before the hands are evaluated. If a player reaches 31 points (especially right after the deal), they must announce it immediately and the game stops for evaluation.

        The hands are evaluated by adding the values of the 3 cards of each player. Aces are worth 11 points, Kings, Queens, and Jacks are worth 10 points, and the other cards are worth their face value (for example, an 8 is worth 8 points). However, only cards of the same suit (♠, ♥, ♦, or ♣) count towards the score. The highest total in a single suit determines the final score.

        Examples:
        - 8♥ + 8♠ + Q♣ = 10 points
        - 10♠ + 7♥ + 8♠ = 15 points
        - A♠ + J♠ + K♠ = 31 points
        Special case: three identical cards (like three Aces, three 9s, or three Queens) are worth 30 points.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        The player with the lowest score at the end of a round is declared the loser. There can be multiple losers in the case of a tie. If all players have the same number of points, the round is replayed.

        Each loser loses 1 point from a total of 4 points at the start. A player is eliminated if they run out of points. The last player still in the game with at least 1 point is declared the winner.
    """.trimIndent()
)

private val barbu = GameModel(
    id = 2,
    name = "Barbu",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "The goal of the game is to have the fewest points at the end of the game. Each game consists of several rounds, each with different rules.",
    material = "A deck of 52 cards",
    howToPlay = """
The game is played over several rounds, in the following order:

Fewest tricks
No hearts
No queens
Barbu
General

For 5 players, the two black 2s are removed, and for 3 players, the 2 of clubs is removed.

One player, called the "dealer", deals all the cards (one by one, changing players clockwise), and the player to their left starts the round. In the next round, the player to the left of the dealer becomes the new dealer, and so on.

Each round consists of "tricks", where players take turns playing a card. The player with the highest card of the starting suit wins the trick. Players must follow suit if they can. If they don't have a card of the same suit, they can discard any card, but they won't win the trick.

Example: Player 1 starts with the 3 of diamonds, player 2 plays an 8 of diamonds, player 3 doesn’t have a diamond and discards a king of hearts, and player 4 plays a jack of diamonds. Player 4 wins the trick and collects the cards. They then start the next trick.

The rounds are played clockwise.

A round ends when players no longer have any cards in hand.

Fewest tricks
The goal is to take as few tricks as possible. At the end of the round, each player counts the number of tricks they have won and scores 5 points per trick.

No hearts
The goal is to avoid taking hearts in tricks. Each heart card taken is worth 5 points.

No queens
The goal is to avoid taking queens. Each queen is worth 20 points.

Barbu
You must avoid taking the king of hearts, which is worth 80 points.

General
All the rounds are combined: avoid tricks, hearts, queens, and the king of hearts. Players then tally up the points they have collected.
""".trimIndent(),
    variants = """
        Choosing rounds
        A variant allows the player after the dealer to choose the round they want to play based on their hand. The order of rounds becomes irrelevant. Each round can only be played once.
        
        Note that the "General" round must always be the last round.
        
        In this variant, players choosing last are at a disadvantage as they have fewer options.

        New rounds
        Additional rounds can be added:

        More tricks
        This is the only round where players want to take tricks. Each trick subtracts 5 points from their total.

        No first or last trick
        Players must avoid taking the first or last trick. Each of these tricks is worth 40 points.
    """.trimIndent(),
    end = "After playing all the rounds, players tally up their points. The player with the fewest points is the winner.",
    difficultyLevel = GameDifficultyLevelModel.HARD,
    durationInMinutes = 45
)

private val corsicaBattle = GameModel(
    id = 3,
    name = "Corsica Battle",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.ELIMINATION),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "The goal of the game is to win all the other players’ cards through your reflexes and speed!",
    material = "A deck of 52 cards",
    howToPlay = """
At the start of the game, the entire deck is distributed equally among the players.

In each round, a player begins by placing the top card of their deck in the center of the table, and the player to their left places the top card of their deck on top of it, and so on, forming a central pile.

The goal is to collect as many of the central piles as possible.

A player who has no cards is eliminated (or not, see variants).

There are 2 ways to win a round and thus collect the central pile:

First method: Be the first to slap the central pile.

To slap the central pile, a “slap situation” must arise:
Two consecutive cards of the same rank appear (e.g., a 5 of hearts follows a 5 of spades, or a Queen of diamonds follows a Queen of clubs, etc.).

We’ll see in the variants that additional slap situations can be introduced to spice up the game.

Be careful, if a player slaps when it’s not a slap situation, they must place 2 cards from their deck under the central pile.

Second method: Win the round through a face card.

Face cards (Aces, Kings, Queens, Jacks) are special cards.
If a player places a face card, the next player must place a certain number of cards on the central pile:
- for an Ace, they must place 4 cards.
- for a King, 3 cards.
- for a Queen, 2 cards.
- for a Jack, 1 card. The Jack is therefore the best card in the game.

If after placing the required number of cards, the next player doesn’t place a face card or there’s no slap situation, the player who placed the face card wins the pile.
""".trimIndent(),
    variants = """
Additional slap situations:
- Slap when there’s a sandwich of cards (Example: 8, King, 8 // 7, Ace, 7)
- Slap when there are two consecutive cards whose sum equals 10 (Example: 4 and 6 // 3 and 7 // 2 and 8 // Ace and 9)
- Slap when there’s a 10
- Slap when there’s a sandwich whose sum equals 10 (Example: 3, 4, 7 // 4, King, 6 // Ace, Jack, 9)

Second chance:
If a player has no more cards, they can continue to slap each round when a slap situation arises and re-enter the game, but if they make a mistake, they are permanently eliminated.
""".trimIndent(),
    end = "A player wins the game when they collect all the cards in play.",
    difficultyLevel = GameDifficultyLevelModel.EASY,
    durationInMinutes = 30
)

private val corruption = GameModel(
    id = 4,
    name = "Corruption",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.HIDDEN_IDENTITY, GameTagModel.ELIMINATION),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "The goal of the game is to be the last one standing. Bluff, lying, and strategy will be your best allies to assassinate and survive your neighbors!",
    material = "A deck of 52 cards",
    durationInMinutes = 30,
    howToPlay = """
At the beginning of the game, separate the face cards and the 10s from the rest of the deck. The face cards and 10s are the support cards, while the remaining cards represent gold.

Deal 2 support cards and 2 gold cards to each player. A support card represents 1 life. So, each player starts the game with 2 lives.

Create a draw pile with the remaining support cards and a second pile with the remaining cards, which we will call the "bank."

In a 4-player game or fewer, remove one of each support card (one 10, one Jack, one Queen, one King, and one Ace). There are then 3 of each support card.

The game proceeds turn by turn in a clockwise direction after a starting player is chosen.

At the start of their turn, a player can take one of the following actions:
- Draw 1 gold coin
- Draw 2 gold coins but can be countered by a Queen
- Use one of the abilities of their support cards
- Assassinate someone for 7 gold coins. The assassinated player loses only one life. This action cannot be countered. The 7 gold coins are returned to the bank.

The abilities of the cards are as follows:
- 10: Counters the Jack’s action
- Jack: Assassinate for only 3 gold coins but can be countered by the 10
- Queen: Draw 3 gold coins and counter the action of drawing 2 gold coins
- King: Steal 2 gold coins from a player of your choice but can be countered by another King
- Ace: Has two possible actions:
       - Look at another player’s support card and decide whether to discard it or not. If discarded, the other player must draw a new support card.
       - Draw a support card from the draw pile and secretly exchange (or not) one of their support cards with it. The discarded support card is placed under the draw pile face down.

Countering:
Any player can counter an action, even if it’s not their turn and even if they are not directly involved. A player whose action has been countered cannot play again in that turn.

Example: If Player 1 decides to assassinate Player 2 with their Jack, Player 2 can counter with their 10. If Player 2 doesn’t have a 10, Player 4 can counter with their 10 and defend Player 2. Player 1 is thus countered, loses their 3 gold coins, Player 2 doesn’t lose a life, and it’s now Player 2’s turn.

This rule applies to all available counters.

Challenge:
Since no one knows the support cards of other players, each player has the option to bluff and perform an action they (technically) cannot do.

Example: Player 1 has a Jack and a 10 but claims to have a Queen and takes 3 gold coins from the bank.

If another player suspects that Player 1 is lying, they can "challenge" them, meaning they ask Player 1 to prove they have the card they claim to have. Player 1 must then reveal their support card.
If Player 1 had the card they claimed, then the challenger loses a life.
If Player 1 did not have the card they claimed, then Player 1 loses a life.

You can also challenge counteractions.

Example: Player 1 has a King and decides to steal 2 gold coins from Player 2. Player 2 decides to counter with their King. Player 1 can challenge Player 2. If Player 2 has a King, Player 1 loses a life and doesn’t steal the 2 gold coins. If Player 2 doesn’t have a King, then Player 2 loses a life, and Player 1 steals the 2 gold coins.

Special cases:
- Player 1 has a Jack and assassinates Player 2 for 3 gold coins. If Player 2 believes Player 1 is lying and challenges them, Player 2 will lose 2 lives since the assassination will take place in addition to the failed challenge. If Player 1 does not have a Jack, Player 1 loses a life but not the 3 gold coins since the action is canceled.
- Player 1 has a Jack and assassinates Player 2 for 3 gold coins. Player 2 bluffs and counters with a 10 they do not have. If Player 1 (or any other player) challenges them, Player 2 loses 2 lives as well since the assassination will take place in addition to the failed challenge. If Player 2 really has a 10, Player 1 will lose a life and the 3 gold coins since the action will have been countered.

When a player loses a life, they discard one of their support cards of their choice but keep it face-up next to their other support card. They can no longer use the ability of the revealed support card.

When a player challenges another player but the challenge fails, the player who revealed their card places it under the draw pile and draws a new support card.

If a player loses both of their support cards (their 2 lives), they are eliminated and can no longer interact with the other players.

If, at the start of their turn, a player has 10 or more gold coins, they must perform an assassination (paying 3 or 7 gold coins).
""",
    end = "The game ends when there’s only one player left. This player is the winner.",
    difficultyLevel = GameDifficultyLevelModel.HARD
)

private val president = GameModel(
    id = 5,
    name = "President",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 4,
    maxPlayer = 6,
    goal = "The goal of the game is to get rid of all your cards first.",
    material = "A deck of 52 cards.",
    howToPlay = """
        Card hierarchy:
        The highest card is the 2, followed by Ace, King, Queen, Jack, 10, and so on. The 2 allows the player holding it to end a card sequence.

        Dealing and starting the game:
        In the first game, all the cards are dealt to the players. The player to the dealer’s left starts by playing 1 to 4 cards of the same value.

        Game play:
        On each turn, a player has several options:
        1. **Pass**: If the player doesn’t have higher cards or the correct number, they pass their turn.
        2. **Play higher cards**: The player can play one or more cards of a value higher than those already played.
        3. **Play a "2"**: If a player plays a 2, the sequence ends immediately, and they start a new sequence.

        Example:
        - Player 1 plays two 7s.
        - Player 2 plays two 9s.
        - Player 3 plays two Jacks.
        - Player 4 plays a 2, the sequence stops, and they start a new sequence.

        If no one can or wants to play, the last player to play a card starts a new sequence.

        Specific rules:
        - Cards played must always be higher than the previous ones.
        - You cannot finish with a 2.
        - It’s impossible to "loop back" after the 2 (e.g., playing an Ace followed by a 2 and then starting again with a 3).

        Role redistribution:
        At the end of a round, players assume the following roles based on their finish order:
        - **President**: The first player to finish.
        - Vice-President: The second player to finish.
        - Neutral (if 5 players): The third player to finish.
        - Vice-Scum: The second-to-last player.
        - Scum: The last player to finish.

        Card redistribution:
        In the next round:
        - The President receives the two best cards from the Scum and gives them two cards of their choice.
        - The Vice-President exchanges one card with the Vice-Scum.
        - If there’s a neutral player (5 players), they neither give nor receive cards.

        Starting the next round:
        The Scum always starts the next round, allowing them to play their weak cards first.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        The winner of the game is the first player to get rid of all their cards. The game continues until only one player remains with cards. This player is declared the "Scum."

        At the end of each game, roles are redistributed based on the order of finish, and a new game starts.
    """.trimIndent()
)

private val canasta = GameModel(
    id = 6,
    name = "Canasta",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TEAM),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "The goal of the game is to get rid of all your cards by forming combinations of the same value, with bonuses for canastas (combinations of 7 cards).",
    material = "Two decks of 54 cards (with 4 jokers).",
    howToPlay = """
        Combinations:
        In Canasta, players form combinations of cards of the same value (e.g., three Jacks, four 10s). A combination of 7 cards is called a "canasta." Special cards like jokers and 2s replace any card and are called "wild cards." Red 3s are bonus cards, and black 3s block the discard pile.

        Dealing:
        Each player receives 11 cards (13 for 3 players and 15 for 2 players). The rest of the cards form the draw pile, and the first card is flipped to start the discard pile. If this card is a joker, 2, or red 3, another card is flipped. If a player receives a red 3, they place it down and draw a new card.

        Picking up the discard pile:
        Instead of drawing a card from the draw pile, a player can take the entire discard pile, provided they can immediately use the top card to complete or form a combination. If the discard pile contains a 2 or joker, it’s "frozen" and can only be picked up with a pure combination (without a joker or 2).
        
        Example: If the discard pile contains several cards and the top card is a 6 of hearts, a player may take the pile because they have a 6 of clubs and a joker, allowing them to complete a new combination. If the pile had a joker or 2 on top, it would have been "frozen," and the player could only take it by playing a pure combination, like two other 6s without using wild cards.

        Game play:
        The player begins by drawing a card from the draw pile or picking up the discard pile, then can lay down or complete a combination. The player ends by discarding a card. The game proceeds clockwise.
        
        Example: During their turn, a player draws a 9 of spades from the draw pile. They already have a combination of 9s (9 of hearts, 9 of diamonds) on the table, so they immediately add their 9 of spades to this combination. Then, they discard a 4 of clubs to end their turn. The next player can either draw a card or pick up the discard pile.

        End of round:
        The round ends when a player has laid down all their cards. To finish, the team must have at least one complete canasta, and the player must get their partner's approval. If the draw pile is depleted, the game continues until no more moves can be made.
    """.trimIndent(),
    durationInMinutes = 60,
    difficultyLevel = GameDifficultyLevelModel.HARD,
    end = """
        At the end of each round, each team counts their points based on the combinations laid down and the remaining cards in hand. A pure canasta (without a joker) is worth 500 points, an impure canasta is worth 300 points. Jokers and 2s are worth 50 points, Aces are worth 20 points, and cards from 8 to King are worth 10 points. Red 3s are worth 100 points each. The first team to reach 5000 points wins the game.
    """.trimIndent(),
    variants = """
        - Two canastas are required to finish the game.
        - Cards can be drawn two at a time from the draw pile.
    """.trimIndent()
)

private val spikeLady = GameModel(
    id = 7,
    name = "Queen of Spades",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 4,
    maxPlayer = 4,
    goal = "The goal is to accumulate the fewest points by the end of the game.",
    material = "A deck of 52 cards.",
    howToPlay = """
        The game is played with 4 players. Each player is dealt 13 cards. The goal is to avoid taking penalty cards. Hearts are worth 1 point each, and the Queen of Spades is worth 13 points. 
        In the first round, players exchange 3 cards with their neighbors based on a defined order (left, right, across, and no exchange every fourth round).
        
        The player with the 2 of clubs starts by playing this card. Each player must follow the suit if they can. If they can’t, they can discard another card. The player who plays the highest card in the suit wins the trick and leads the next.

        Example:
        - Player 1 starts with the 2 of clubs. The other players must follow with a club if they have one.
        - Player 2 plays the 5 of clubs.
        - Player 3 plays the 8 of clubs.
        - Player 4, who doesn’t have any clubs, discards the Queen of Spades.
        - Player 3, who played the highest club (the 8 of clubs), wins the trick and leads the next.

        Players can’t play point cards (hearts or the Queen of Spades) during the first round. Additionally, a player cannot lead a trick with hearts until a heart has been played by another player.

        If a player manages to take all the hearts and the Queen of Spades, they perform a "Grand Slam," giving 26 points to their opponents while scoring no points themselves.
    """.trimIndent(),
    durationInMinutes = 30,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        The game ends when one player reaches or exceeds 100 points. The player with the fewest points is declared the winner.
    """.trimIndent(),
    variants = """
        Jack of Diamonds:
        In this variant, the Jack of Diamonds is worth -10 points. Players try to take this card without collecting the Queen of Spades. In a Grand Slam, the Jack of Diamonds doesn’t count toward the 26 points dealt to the other players.
        
        Seven of Clubs:
        In this variant, the Seven of Clubs is worth 7 points and becomes a card to avoid in addition to the Queen of Spades. In a Grand Slam, the Seven of Clubs doesn’t count toward the 26 points dealt to the other players.
    """.trimIndent()
)

private val fiveThousand = GameModel(
    id = 8,
    name = "5000",
    tagList = listOf(GameTagModel.DICE),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "The goal of the game is to be the first player to reach exactly 5000 points by rolling specific dice combinations.",
    material = "5 six-sided dice",
    howToPlay = """
Each player rolls the 5 dice in turn and tries to score points by making specific combinations.

To start accumulating points, a player must "open" by scoring at least 750 points in one turn. Once a player has opened, there is no minimum score required to continue scoring.

If a player rolls no points in a turn, they lose all the points accumulated during that turn, and it’s the next player’s turn.

When a player scores points on all dice in a roll, they have the option to reroll all the dice to try to score more. However, as mentioned earlier, if they score no points on this reroll, they lose all the points accumulated in that turn.

Dice combinations score points as follows:
- A 1 is worth 100 points.
- A 5 is worth 50 points.
- Three of a kind is worth 100 times the value of the die (e.g., three 3s score 300 points). Three 1s score 1000 points.
- A straight from 1 to 5 scores 500 points, and a straight from 2 to 6 also scores 500 points.
- If a player rolls five 1s in a single roll, they win the game immediately, regardless of other players' scores.

The goal is to reach exactly 5000 points to win the game. If a player exceeds 5000, their score is reset to what it was at the start of the turn.
    """.trimIndent(),
    durationInMinutes = 30,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
The game ends when a player reaches exactly 5000 points. This player wins the game.
    """.trimIndent(),
    variants = """
- If a player matches another player's score, the other player’s score is reset to what it was before the turn.
- If a player has three consecutive turns without scoring, their score is reset to zero or what it was before the turn.
- A variant imposes that points are only valid if they are multiples of 100. Otherwise, the player must reroll.
- A special rule allows a player to predict the score of their remaining dice after scoring with three dice. If they predict correctly, their score is doubled.
    """.trimIndent()
)
private val solitaire = GameModel(
    id = 9,
    name = "Solitaire",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 1,
    maxPlayer = 1,
    goal = "The goal of the game is to create 4 piles of cards (one for each suit) arranged in ascending order from Ace to King.",
    material = "A deck of 52 cards.",
    howToPlay = """
The game begins with 7 columns of cards. Only the last card in each column is visible, while the others are face down. The first column contains one card, the second contains two cards (one face up and one face down), and so on until the seventh column, which has six face-down cards and one face-up card. The rest of the deck forms the stockpile (draw pile).

The goal is to complete four piles (one for each suit: ♠, ♥, ♦, ♣), starting with the Aces and moving up to the King, in ascending order. These piles must be created above the columns.

You can move the visible cards between columns under the following rules:
- A card can be placed on another card if it is of a different color (alternating between red and black) and immediately lower in value. For example, a 7 of hearts can be placed on an 8 of clubs.
- Face-down cards are turned over when the visible card above them is moved.
- If a column becomes empty, a King or a sequence starting with a King can be placed there.

When no more moves can be made between columns, you can use the stockpile. The stockpile deals one card at a time (or three, depending on the variant you choose). Only the top card of the stockpile can be played, either to the piles or the columns.

The goal is to move all the cards into the piles, starting with Aces and following ascending order (Ace, 2, 3, ... up to King) for each suit.

If you're stuck and can’t make any more moves, you can return to the stockpile and keep looking for possible moves until all the cards are placed or no more moves are possible.
    """.trimIndent(),
    durationInMinutes = 15,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
You win the game if you succeed in completing all four piles from Ace to King. However, it’s possible to get stuck with no more moves available, in which case the game ends without a victory.
    """.trimIndent(),
    variants = """
- Single card draw variant: You can choose to play with a stockpile that deals one card at a time rather than three, making the game easier.
- A variant with jokers allows you to use them as wild cards, which can be placed anywhere in the columns or piles.
    """
)

private val elevator = GameModel(
    id = 10,
    name = "Elevator",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 4,
    maxPlayer = 6,
    goal = "The goal is to score the most points by matching the contract announced at the beginning of each round.",
    material = "A deck of 52 cards.",
    howToPlay = """
The game is played over several rounds, where the number of cards dealt increases progressively and then decreases during the following rounds.

The cards are dealt as follows:

Round 1: 1 card
Round 2: 2 cards
…
Round 13: 13 cards (no trump)
Round 14: 12 cards
Round 15: 11 cards
…
Round 25: 1 card

The number of rounds may vary depending on the number of players.

At the beginning of each round, players announce the number of tricks they think they can win. The last player to make their announcement cannot choose a number of tricks that would make the total announcements equal to the number of possible tricks.

Example: if three players have announced 2, 3, and 2 tricks in a round with 8 possible tricks, the last player must announce either more or less than one trick from the total of 7 announced.

After the announcements, the game proceeds with trick-taking:
In a clockwise direction, each player must follow the suit of the first card played, and if they can’t, they may play a trump or any other card. The trump suit is determined by the first card turned from the draw pile after dealing. If a player has no trumps, they can play any other card. The highest card in the suit played or the highest trump wins the trick. The player who wins the trick leads the next.

Example of a trick with a heart trump and 5 cards dealt per player:

The first player leads with a 9 of clubs.
The second player, with no clubs, plays an 8 of hearts (a trump).
The third player, holding an Ace of clubs, must follow suit and plays the Ace of clubs.
The fourth player also has no clubs but plays a Jack of hearts (trump). 
Since hearts are trumps, the Jack of hearts beats all other cards. The fourth player wins the trick and leads the next trick.

During the round where the maximum number of cards is dealt (13 cards to 4 players), there is no trump, and the round is played "no trump."

Each new round is led by a new dealer chosen clockwise.
    """.trimIndent(),
    durationInMinutes = 60,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
Each player scores points based on whether they matched their contract or not. A player who matches their exact number of tricks wins one point more than the number of tricks they took.

Example: if they announce 3 tricks and win 3, they score 4 points.

A player who fails to match their contract loses as many points as the difference between their announcement and the number of tricks taken.

Example: if they announce 4 tricks but win only 2, they lose 2 points.
Example 2: if they announce 2 tricks and win 4, they lose 2 points.

The game ends at the conclusion of the final round, and the player with the most points wins.
    """
)

private val tamalou = GameModel(
    id = 11,
    name = "Tamalou",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "The goal of the game is to score the fewest points by the end of the game.",
    material = "A deck of 54 cards.",
    howToPlay = """
The game is played over several rounds. Each player is dealt 4 cards, which they place face down in a square in front of them. Before the game begins, players look at two of their cards and must remember them. The draw pile is placed in the center with a discard pile next to it.

On each turn, a player can draw a card to either:
- Place it in the discard pile (and use its power if applicable),
- Exchange it with one of their face-down cards, discarding the replaced card.

At any time, a player can discard one, two, or three cards of the same value as the top card of the discard pile, from their cards in play. If several players have a matching card to discard, the fastest one wins; the slowest one returns their card to their game. If a player mismatches a card, they draw a new card and add it to their setup.

Example: If the visible card in the discard pile is a 9. Player 1 has two 9s in front of them, and Player 2 also has a 9. When the 9 is placed in the discard pile, both players can try to discard their matching cards as quickly as possible. Player 1, being faster, discards both their 9s, reducing their cards in play. Player 2, slower, must return their 9 to their game.

If a player mismatches and tries to discard a different value card, such as an 8 instead of a 9, they must immediately draw a new card and add it to their square, increasing their potential score.

Each player aims to minimize the value of their cards throughout the round. When a player believes their card total is 5 or fewer points, they can declare a "Tamalou," triggering a final turn for the other players.

At the end of a round, each player reveals their cards and tallies their points. The player with the fewest points wins the round. If a player declares Tamalou and has 5 points or fewer, they score zero points. If another player has fewer or equal points, they also score zero.

The powers of discarded cards are as follows:
- 7, 8: The player may look at one of their own cards and then replace it face down.
- 9, 10: The player may look at one of their opponent’s cards and then replace it face down.
- Jacks, Queens: The player may swap one of their cards with an opponent’s card without either seeing the cards exchanged.
- Black Kings (♠, ♣): The player may look at one of their opponent’s cards and swap it with one of their own cards.
- Red Kings (♥, ♦): Worth 0 points but with no special power.
- Joker: The player may choose to take an additional card and add it to their game, increasing their risk.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
        The game ends after a pre-determined number of rounds. The player with the fewest accumulated points at the end of all rounds is declared the winner.
    """
)

private val yahtzee = GameModel(
    id = 12,
    name = "Yahtzee",
    tagList = listOf(GameTagModel.DICE),
    minPlayer = 1,
    maxPlayer = 4,
    goal = "The goal of the game is to make the best possible combinations by rolling dice and scoring the most points at the end of 13 rounds.",
    material = "5 dice, a score sheet, a pen.",
    howToPlay = """
Each player has 3 rolls per turn to try to achieve a combination. On the first roll, the player rolls all the dice. After this roll, they can either score immediately or choose to reroll some or all of the dice to improve their result. After the third roll, they must mark their score in a box on the score sheet or cross out a combination. If no combination is possible, they must cross out a box.

The game consists of 13 rounds, each corresponding to one of the combinations on the score sheet. Players score points based on the combinations they achieve and fill in the corresponding boxes on their sheet.

The combinations to achieve are divided into two sections:

Upper section:
- Aces: Score the sum of dice showing 1.
- Twos: Score the sum of dice showing 2.
- Threes: Score the sum of dice showing 3.
- Fours: Score the sum of dice showing 4.
- Fives: Score the sum of dice showing 5.
- Sixes: Score the sum of dice showing 6.
Bonus: If the sum of scores in this section reaches or exceeds 63 points, a bonus of 35 points is awarded.

Lower section:
- Three of a Kind: 3 dice of the same number, score = sum of all 5 dice.
- Four of a Kind: 4 dice of the same number, score = sum of all 5 dice.
- Full House: 3 dice of the same number and 2 dice of another, score = 25 points.
- Small Straight: 4 consecutive dice, score = 30 points.
- Large Straight: 5 consecutive dice, score = 40 points.
- Yahtzee: 5 identical dice, score = 50 points.
- Chance: Sum of all 5 dice, regardless of the combination.

If a player rolls a second Yahtzee (5 identical dice) after already scoring 50 points in the Yahtzee box, they receive a 100-point bonus and must cross out another available box. This bonus can apply multiple times.

The player must fill or cross out a box on the score sheet each turn. If no combination is possible, they must record a zero in a box.
    """.trimIndent(),
    durationInMinutes = 30,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
The game ends when all players have filled or crossed out all the boxes on their score sheets. The points for each player are added up. The winner is the one with the most points, taking into account bonuses and the upper and lower sections.
    """.trimIndent(),
    variants = """
- "Plus and Minus" variant: Instead of the Chance box, two new figures are added. The "plus" figure is the sum of all five dice, while the "minus" figure subtracts the sum from the total score.
- Modified Three of a Kind, Four of a Kind, and Full House: In this variant, Three of a Kind gives 10 points plus the sum of the three identical dice, Four of a Kind gives 20 points plus the sum of the four identical dice, and Full House gives 10 points plus the sum of the five dice.
- "Complex" variant: The player must complete three columns, each with the same figures as in the classic version. The first column must be completed in ascending order, the second in descending order, and the third can be filled freely. A fourth column, called the "dry" column, can be added, where the player is only allowed one roll per turn.
    """
)
private val kems = GameModel(
    id = 13,
    name = "Kems",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TEAM),
    minPlayer = 4,
    maxPlayer = 8,
    goal = "Form a set of 4 identical cards and make your partner guess using a secret sign.",
    material = "A 52-card deck (or 32 cards for 4 players), paper, and a pencil for scorekeeping.",
    howToPlay = """
Kems is played in teams of 2 players. Each team chooses a secret signal at the beginning of the game, which the partners will use to discreetly communicate that they have gathered 4 identical cards.

The dealer distributes 4 cards to each player, then places 4 additional cards in the center of the table. When the dealer says "go", players may exchange their cards with those in the center. They must place a card from their hand before picking one from the center, and they must always keep 4 cards in hand.

The goal is to form a set of 4 identical cards. When a player succeeds, they signal to their partner using the secret sign. If the partner sees the signal, they shout "Kems", and the team earns 1 point. If both partners each have a set of 4 cards, they may shout "Double Kems" for 2 points.

Opponents can shout "Counter-Kems" if they guess the secret signal of a team. If they are correct, the team that shouted "Counter-Kems" earns 1 point. In case of a wrong guess, the player who called "Counter-Kems" must reveal 2 cards and cannot call "Counter-Kems" for the rest of the round.

The game continues in "sweep" phases, where unchosen cards are discarded in a "trash pile" and 4 new cards are placed on the table. When all cards have been used, the cards from the trash pile are shuffled and become the new draw pile.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    end = """
The game ends when a predetermined number of points is reached (e.g., 10 points). The team with the most points wins the game.
    """.trimIndent()
)
private val nightyNine = GameModel(
    id = 14,
    name = "99",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "The goal of the game is to add cards without exceeding 99 or face a penalty!",
    material = "A deck of 52 cards.",
    howToPlay = """
Each player is dealt 2 cards at the start of the game and must always maintain 2 cards throughout. The goal is to bring the total count to 99 without exceeding it.

On each turn, players play a card from their hand and announce the new total. The game continues until a player exceeds the count of 99.

Card values are as follows:
- Cards 2 to 10: Count as their face value.
- Jack: -10 from the total.
- Queen: Changes the direction of play.
- King: Sets the count directly to 70.
- Ace: Counts as 1 or 11, at the player's choice.
- Joker: The player can choose a value between 1 and 9.

Players must draw a new card after each turn to keep 2 cards in hand.

Penalties are applied for certain mistakes:
- If a player forgets to draw a card before the next player plays, they receive a penalty of 2.
- If a player miscalculates the total, they receive a penalty of 2.
- If a player asks what the total is, they receive a penalty of 2.

When the total reaches a multiple of 10 (e.g., 10, 20, 30), the player can assign penalties to opponents based on the tens digit of the total (e.g., 60 = 6 penalties).
    """.trimIndent(),
    durationInMinutes = 15,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
The game ends when a player exceeds the total of 99. The player who exceeds 99 receives 2 penalties plus a number equal to the difference (e.g., if the total is 105, the player receives 2 + 6 = 8 penalties).
    """.trimIndent(),
    variants = """
Other rules can be added to make the game more complex, such as special cards that cancel penalties or variations on card values.
    """
)

private val pyramid = GameModel(
    id = 15,
    name = "Pyramid",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 3,
    maxPlayer = 8,
    goal = "The goal is to avoid receiving too many penalties while dealing out as many as possible during the two phases of the game.",
    material = "A deck of 54 cards.",
    howToPlay = """
The game is divided into two phases:

Phase 1: Base Card Distribution
1. The dealer shuffles the cards and asks each player clockwise, "red or black?" to guess the color of the card they will receive. If the player is wrong, they receive a penalty.
2. In the second round, the dealer asks, "higher or lower?" and players guess whether the next card will be higher or lower than their first. If the player is wrong, they receive a penalty. If the two cards are the same, a new card is dealt.
3. In the third round, the dealer asks, "inside or outside?" Players must guess if the next card will be between the first two or outside the interval. If the player is wrong, they receive a penalty.
4. In the final round, players guess the suit (♠, ♣, ♥, ♦) of the next card. A correct answer allows them to assign 5 penalties to other players, otherwise they receive a penalty.

Phase 2: Pyramid
The dealer builds a pyramid of face-down cards: 5 cards at the base, 4, 3, 2, and 1 at the top.

Players keep their base cards secret. Each time a card is revealed from the pyramid, players can claim they have the same card (whether true or false) and distribute penalties corresponding to the row of the card. If they have two of the same card, they can double the penalties.

Other players may call "liar" if they believe the claim is false. If the player was lying, they receive double the penalties they tried to deal. If the player was truthful, the accusing player receives double penalties.

As the pyramid progresses, penalties increase: 1 penalty for cards in the bottom row, 2 penalties in the next row, up to 5 penalties for the top card.
    """.trimIndent(),
    durationInMinutes = 30,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
The game ends when all cards in the pyramid have been revealed.
    """.trimIndent(),
    variants = """
At the end of the game, you can add an additional step:

Each player, in turn, reveals their cards to all their opponents, announcing the card just before flipping it. A player takes the final penalty if they make a mistake.

Example: Player 1 announces "2♠" and reveals a 2♠. Then they announce "3♦" and reveal a 3♦. They announce "4♣" but flip over a 7♦, making a mistake and receiving the penalty.
    """
)

private val fuckTheDealer = GameModel(
    id = 16,
    name = "Fuck the Dealer",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 3,
    maxPlayer = 8,
    goal = "The goal is to correctly guess the cards to avoid penalties while trying to make the dealer lose.",
    material = "A deck of 52 cards.",
    howToPlay = """
A player is designated as the dealer. The dealer takes the deck face down and asks the first player to guess the top card’s value. The player has two chances to guess correctly:

1st guess: If the player guesses correctly on the first try, the dealer loses and takes a number of penalties equal to the value of the card (e.g., Jack = 11 penalties, Queen = 12 penalties, etc.). If the player is wrong, the dealer tells them whether the true value is higher or lower.

2nd guess: If the player guesses correctly on the second try, the dealer takes penalties equal to half the value of the card (rounded up). If the player guesses wrong again, they take penalties equal to the difference between their guess and the card’s value. 
For example: if the player guesses 7 and the card is a Jack, they take 11 - 7 = 4 penalties.

The used cards are then placed face-up on the table, sorted by value so that all players can see which cards remain in the deck. The turn passes to the next player.

Changing the dealer: The dealer changes depending on the rule set before starting. Some possible rules are:
- The dealer changes after 3 consecutive losses.
- The dealer changes after losing 3 times in total.
- The dealer changes after dealing to each player once.
- The dealer changes after 3 consecutive wins.

Alternatively, you can decide to choose the next dealer randomly or rotate the dealer after each turn based on preferences.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
The game ends when all the cards have been placed face-up on the table.
    """.trimIndent()
)

private val shoshoi = GameModel(
    id = 17,
    name = "Shoshoï",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 4,
    maxPlayer = 8,
    goal = "The goal is to follow the rules defined during the game to avoid penalties.",
    material = "A deck of 52 cards.",
    howToPlay = """
A game master, chosen beforehand, takes the deck and draws cards one by one.

Each card applies an effect to a player.  

The card is then discarded, and the game master draws the next card for the next player.

Example: The game master starts by drawing a card from the deck. For example, they draw the 4♥ and announce the card out loud. Player 1 is chosen for this round and applies the effect corresponding to the drawn card. Once the effect is applied, the card is discarded. The game master draws a new card with an effect for Player 2, and so on.

Card effects:
- Ace to 5 Red: If a player draws a red card (♦ or ♥), they assign penalties equal to the value of the card (e.g., a 2 of ♥ assigns 2 penalties).
- Ace to 5 Black: If a black card (♠ or ♣) is drawn, the player receives a penalty equal to the value of the card.
- 6: The player becomes "SnakeEyes" and retains this status until another player draws a 6. While they are SnakeEyes, anyone who looks them in the eyes receives a penalty.
- 7: The previous player takes a penalty.
- 8: The player chooses a theme (e.g., clothing brands, fruits, sports), says a word in that theme, and other players must say a new word in the theme in turn. The first to fail to find a unique word receives a penalty.
- 9: The player who draws this card must invent a new rule that applies to all players for the rest of the game (e.g., speaking with an accent, adding a phrase at the end of each statement). Each infraction of the rule results in a penalty.
- 10: All players must stand and shout "Shoshoï!" The last player to do so takes a penalty.
- Jack: The player who draws this card can designate another player as their "little brother." The little brother takes a penalty whenever the player who drew the Jack takes one (the reverse is not true). 
Example: (Player 1 draws the Jack and chooses Player 2 as their little brother. If Player 1 receives a penalty, Player 2 must also take one. But if Player 2 receives a penalty, Player 1 does not take one.)
- Queen: The player who draws this card becomes the "Queen of Questions" and retains this title until another player draws a Queen. If a player answers a question from the Queen of Questions, they take a penalty.
- King: For the first three Kings drawn, a penalty is placed in a glass at the center of the table. The player who draws the fourth King must drink the contents of the glass and receives all the accumulated penalties.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
The game ends after all cards have been discarded.
    """.trimIndent()
)

private val sevenAndHalf = GameModel(
    id = 18,
    name = "7.5",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.DRINKS),
    minPlayer = 2,
    maxPlayer = 10,
    goal = "The goal is to reach or come as close as possible to 7.5 without exceeding that total. This game is a variant of Blackjack.",
    material = "A deck of 52 cards.",
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.MEDIUM,
    howToPlay = """
Each player starts with one face-down card. The banker (a designated player) deals with each player one by one.

Card values:
- Cards 1 to 7 retain their numerical value.
- Jacks, Queens, and Kings are worth 0.5 points each.
- The 8 is worth 0.
- The 9 and 10 are removed from the deck.

Turn overview:
The banker offers cards to the players. Players can ask for additional cards one at a time, receiving them face-up. The goal is to approach 7.5 without exceeding it. At any time, a player may choose to stop if they think they are close enough to 7.5.

Once all players have finished requesting cards or stopped, the banker plays.

At the start of the turn, the banker must guess if any players have exceeded 7.5. If the banker suspects a player has exceeded, they point them out. If the player has indeed gone over, they take a penalty and leave the game. If the banker is wrong, they take a penalty.

The banker continues, requesting cards for themselves and stopping when they choose. If the banker exceeds 7.5, they lose against all remaining players and take a penalty for each player they lost to.

Additional rules:
- In the event of a tie between a player and the banker, the banker wins.

Example of a round:

Card distribution: Each player receives one face-down card. Player 1 gets a 4, Player 2 gets a 5, and Player 3 gets a King (worth 0.5).

Player 1’s turn: They request a card and get a 2, bringing their total to 6. They decide to stop.

Player 2’s turn: They request a card and receive a Jack (worth 0.5), bringing their total to 5.5. They request another card and get a 3, bringing their total to 8.5, exceeding 7.5. They stop, but the banker doesn’t know they have exceeded.

Player 3’s turn: They request a card and get a 6, bringing their total to 6.5. They choose to stop.

The banker plays: The banker guesses that Player 2 has exceeded 7.5, which is correct. Player 2 takes a penalty and leaves the game.

The banker continues: The banker starts with a 3 face-down and requests an additional card, receiving a 4, bringing their total to 7. They stop and reveal their total to Players 1 and 3.

Results: Player 1 has 6, Player 3 has 6.5, and the banker has 7. The banker wins against both players, so they each take a penalty.
    """.trimIndent(),
    end = """
The game doesn’t have a definitive end and concludes whenever the players decide.
    """
)
private val threeMan = GameModel(
    id = 19,
    name = "Three Man",
    tagList = listOf(GameTagModel.DICE, GameTagModel.DRINKS),
    minPlayer = 3,
    maxPlayer = 6,
    goal = "The goal is to follow the dice rules and give or take penalties based on the dice rolls.",
    material = "Two six-sided dice.",
    howToPlay = """
Choosing the Three Man:

To start, each player rolls a die. The first player to roll a 3 becomes the "Three Man." This player may wear a distinctive item (like a hat) to signify their role.

On each turn, players roll the dice. As long as the dice produce an effect, the player keeps rolling. If no effect is triggered, the turn passes to the next player.

Dice Effects:

- Three: If the total roll is 3 or if either die shows a 3, the Three Man must take a penalty.
- Seven: If the dice total 7, the player to the left of the roller must take a penalty. If the dice show 3 and 4, the Three Man also drinks.
- Ten: If the total is 10, all players take a penalty ("social").
- Eleven: If the total is 11, the player to the right of the roller takes a penalty.
- Doubles: If a player rolls doubles, they may assign the dice to one or two other players who must roll and follow the results. If the next roll is doubles again, the original roller takes a penalty equal to the dice sum.

Changing the Three Man:

After each player has rolled, including the Three Man, a new Three Man is chosen following the same rules.
    """.trimIndent(),
    durationInMinutes = 20,
    difficultyLevel = GameDifficultyLevelModel.EASY,
    end = """
The game ends whenever the players decide, or when there are no more penalties to assign!
    """.trimIndent()
)

private val rami = GameModel(
    id = 20,
    name = "Rami",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 5,
    goal = "The goal is to discard all your cards by forming combinations before the other players. The player with the fewest points at the end of the game wins.",
    material = "Two decks of 52 cards, including jokers.",
    durationInMinutes = 30,
    howToPlay = """
Each player is dealt 13 cards, one by one, in a counter-clockwise direction. The remaining cards form the draw pile, and the first card is flipped over to start the discard pile.

To start playing their cards, players must have a combination that totals at least 51 points, which includes a "natural sequence" (a run of at least three consecutive cards of the same suit without jokers). There are no rounds; a player must wait until they can place this combination.

Example: If you hold a run like "5♥, 6♥, 7♥" and another combination, such as a set of "8♠, 8♣, 8♦," you can lay them down because the run "5♥, 6♥, 7♥" is a natural sequence. The total of these combinations equals 51 points. However, if your combinations do not total 51 points or you lack a natural sequence, you must keep drawing until you can lay down.

Once this condition is met, on each turn, a player can:
- Draw a card from the draw or discard pile.
- Form valid combinations and lay them down. Valid combinations include:
   - Three-of-a-kind: Three cards of the same value (e.g., 7♠, 7♣, 7♦).
   - Four-of-a-kind: Four cards of the same value (e.g., 5♠, 5♣, 5♦, 5♥).
   - Sequence: Three or more consecutive cards of the same suit (e.g., 3♥, 4♥, 5♥).
- Add cards to combinations already laid down.
- Discard a card to end their turn.
    """.trimIndent(),
    end = """
A round ends when a player discards all their cards. Other players then count the points remaining in their hands. The player with the fewest points wins the game.

- Cards 2 to 10 are worth their face value.
- Face cards (Jack, Queen, King) are worth 10 points.
- The Ace is worth 1 or 11 points depending on its position in a combination.
- The Joker can replace any card and takes on its value.

The game ends when a player reaches or exceeds 1000 points.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

private val crapette = GameModel(
    id = 22,
    name = "Crapette",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 2,
    goal = "The goal is to get rid of all your cards before your opponent by placing them in the central piles or on the tableau, following the placement rules.",
    material = "Two decks of 52 cards with different backs.",
    durationInMinutes = 45,
    howToPlay = """
Crapette is played by two players, each with a deck of 52 cards. Here’s how to set up and play:

Setup:
- Each player shuffles their deck, gives it to their opponent to cut, and then draws the top 13 cards to form a pile called the "Crapette," placed to their right.
- They then deal 4 face-up cards vertically above the Crapette to form the base of their tableau.
- The remaining 35 cards form the Talon, placed below the Crapette.
- Each player turns over the top card of their Crapette, and the player with the highest card starts.

Card Layout:

            Player A
  Crapette      Discard      Talon

      5♣          ♠      ♠          J♠
      9♥          ♥      ♥          Q♥
      K♠          ♦      ♦          A♦
      8♠          ♣      ♣          9♥

   Talon          Discard        Crapette
            Player B


Gameplay:
- The starting player turns over the top card from their Talon and makes as many legal moves as possible.
- The central piles are built by suit and in ascending order (Ace to King).
- Tableau columns are built by alternating colors and in descending order.
- Cards from the Crapette, Talon, or tableau can be moved to the central piles or onto the tableau columns.

Example of two turns:

Turn 1: Player A
- Player A draws a 10♠ from their Talon.
- They place the 10♠ on the J♠ (descending order, alternating color) in their tableau.
- They move the 9♥ onto the 10♠ and discard a card to end their turn.

Turn 2: Player B
- Player B draws an 8♦ from their Talon and places it in their tableau.
- They move the 10♣ from the Crapette to an empty column in the tableau and discard a card to end their turn.

Crapette!:
- If a player misses a possible move, their opponent can call "Crapette!" forcing them to stop playing and pass their turn.
- If a player empties their Crapette, they must immediately play the next card into an empty tableau space.

End of Game:
- The first player to place all their cards on the tableau or in the central piles wins the game.
    """.trimIndent(),
    end = """
The game ends when a player has placed all their cards. The opponent can no longer play, and the first player to finish is declared the winner.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.HARD
)

private val pileOfShit = GameModel(
    id = 23,
    name = "Pile of Shit",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 3,
    maxPlayer = 10,
    goal = "The goal is to get four identical cards and draw the fewest kilos of 'shit.'",
    material = "A deck of 52 cards.",
    durationInMinutes = 30,
    howToPlay = """
Pile of Shit is a fun card game. The objective is to collect four identical cards while drawing as few "kilos of shit" as possible.

Setup:
- Each player receives a number of cards based on the number of participants:
  - 3 players: Kings, Queens, and Jacks are dealt.
  - 4 players: Kings, Queens, Jacks, and Twos are dealt.
  - 5 players: Kings, Queens, Jacks, Twos, and Threes are dealt.
  - 6 players: Kings, Queens, Jacks, Twos, Threes, and Fours are dealt.
  - 7 players: Kings, Queens, Jacks, Twos, Threes, Fours, and Fives are dealt.
  - 8 players: Kings, Queens, Jacks, Twos, Threes, Fours, Fives, and Sixes are dealt.
  - 9 players: Kings, Queens, Jacks, Twos, Threes, Fours, Fives, Sixes, and Eights are dealt.
  - 10 players: Kings, Queens, Jacks, Twos, Threes, Fours, Fives, Sixes, Eights, and Nines are dealt.
- The remaining cards form the "Pile of Shit" in the center of the table.

Gameplay:
- Each player starts with four cards in hand.
- The player with the Queen of Hearts begins by passing a card to the player on their right.
- Each player continues to pass cards to the next player in turn.
- The goal is to obtain four identical cards (same value or suit).
- When a player gets four identical cards, they tap the "Pile of Shit" in the center.
- The other players must tap the pile as quickly as possible after them. The last player to tap must draw a card from the pile.
- The drawn card determines the number of "kilos of shit" the player receives (the card's number corresponds to the kilos).
- Beware: The player with four identical cards must wait until all other players have four cards before tapping the pile.
- It’s possible to bluff by pretending to tap the pile. If another player falls for the trick, they must draw a card from the pile.

Special Rule: The Flush
- If a player draws a 7, they draw the "Flush" card. This card allows them to discard all the "kilos of shit" they’ve collected back into the pile.
    """.trimIndent(),
    end = """
The game ends after a set number of rounds. Each player counts their drawn cards, with each card representing a certain number of kilos of shit:
- 5 = 5 kilos
- Jack = 11 kilos
- Queen = 12 kilos
- King = 13 kilos
- Ace = 100 kilos

The player with the fewest kilos of shit at the end is the winner.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.EASY
)
private val lousy = GameModel(
    id = 24,
    name = "Lousy",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "The goal is to form pairs of cards and avoid being left with the Lousy, a card that cannot be paired.",
    material = "A 52-card deck without the Queen of ♣ or another randomly chosen card.",
    durationInMinutes = 15,
    howToPlay = """
Lousy is played with a deck of 52 cards, with one card removed. The objective is to form pairs and avoid holding the Lousy card.

Setup:
- Shuffle the deck and remove one card (e.g., the Queen of ♣). Then deal the remaining cards to all players.
- Each player examines their hand and removes any pairs (cards of the same value).

Gameplay:
- Players take turns drawing one card at random from the hand of the player to their left.
- If a player forms a new pair, they immediately discard it.
- Play continues until all pairs are discarded except for one card: the Lousy.
    """.trimIndent(),
    end = """
The game ends when all pairs have been formed and discarded, except for the Lousy. The player holding the Lousy is the loser.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.EASY
)

private val fourHundredTwentyOne = GameModel(
    id = 26,
    name = "421",
    tagList = listOf(GameTagModel.DICE, GameTagModel.DRINKS),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "The goal is to achieve the best possible combination with three dice while accumulating the fewest penalties.",
    material = "3 dice.",
    durationInMinutes = 15,
    howToPlay = """
The game of 421 is played with 3 dice, and the objective is to get the best possible combination. The player with the weakest combination at the end of each round receives a penalty.

Gameplay:
- The first player rolls the 3 dice and may choose to re-roll up to three times. They can stop at any time if satisfied with their combination.
- The number of rolls made by the first player determines the number of rolls allowed for the other players.
- After each roll, players can choose to keep one or two dice and re-roll the others.
- The player with the weakest combination after the rolls receives penalties based on the best combinations of the other players.
- Dice are always read from highest to lowest (e.g., 521 instead of 125).

Possible Combinations (from strongest to weakest):
- 421: 8 penalties (best combination possible).
- 111: 7 penalties.
- 666, 116: 6 penalties.
- 555, 115: 5 penalties.
- 444, 114: 4 penalties.
- 333, 113: 3 penalties.
- 222, 112: 2 penalties.
- Straights (e.g., 123, 234, 345, 456): 2 penalties.
- Other combinations (e.g., 322, 331, 664, 665): 1 penalty.
- 221 (called "Nénette"): 1 penalty, weakest combination.
    """.trimIndent(),
    end = """
The player who loses a round becomes the first to roll in the next round. The game ends when players decide or when there are no more penalties to assign!
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

private val eightAmerican = GameModel(
    id = 28,
    name = "Eight American",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "The goal is to get rid of all your cards before the other players. This game is a predecessor to Uno.",
    material = "A 52-card deck (or two decks for 4 or more players).",
    durationInMinutes = 30,
    howToPlay = """
Eight American is a card game where players try to discard all their cards by following specific rules tied to the cards played.

Setup:
- The dealer gives 8 cards to each player. The remaining cards form the draw pile.
- The top card of the draw pile is flipped to start the discard pile.

Gameplay:
- The player to the dealer’s left begins.
- On their turn, each player must place a card matching the color or value of the top card on the discard pile.
- If they can’t play, they must draw a card. If the drawn card can be played, they may do so immediately. Otherwise, their turn ends.
- Some cards have special effects:
  - 8: This is a joker card that can be played at any time, except on a 2. It also allows the player to change the color in play.
  - Ace: All other players must play an Ace (or an 8), or they must draw two cards. Everyone must follow this rule, and the player who played the Ace continues.
  - 2: Forces the next player to draw two cards unless they also play a 2. In this case, the next player draws four cards, and so on.
  - Jack: Reverses the direction of play.
  - 10: Forces the player who plays it to take another turn (if they play another 10, they continue). If the 10 is their last card, they must draw a new card.
  - 7: The next player skips their turn.

When a player has only one card left, they must announce "Card!" and attempt to win by playing it on their next turn.

If using two decks, players can play cards even if it’s not their turn. To do this, they must play the same card that is on top of the discard pile. The game continues from the player who "intercepted" the card.

Penalties:
- A two-card penalty is applied for the following infractions:
  - Playing a card that doesn’t match the discard pile.
  - Forgetting to announce "Card" when down to one card.
    """.trimIndent(),
    end = """
At the end of each round, players count the points of the remaining cards in their hands:
  - 50 points for an 8
  - 25 points for 2 and Ace
  - 10 points for face cards
  - 5 points for other cards

The game ends when a player accumulates 500 points from multiple rounds.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

private val gangsters = GameModel(
    id = 30,
    name = "Gangsters",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.ELIMINATION),
    minPlayer = 4,
    maxPlayer = 6,
    goal = "The goal is to survive 8 rounds and accumulate the most money.",
    material = "Two 52-card decks.",
    durationInMinutes = 45,
    howToPlay = """
In this game, each participant selects 8 cards of the same suit, numbered 6 to King. These cards represent the "bullets" players will use to "load" their fictitious guns by pointing a finger (index) at another player, mimicking a pistol.

The bullets are classified as:
- Numbered cards 6, 7, 8, 9, and 10 are blanks.
- Jacks and Queens are standard bullets.
- Kings are powerful bullets.

The cards numbered Ace to 5 are separated from the rest to form a separate pile. This pile represents the loot the players will divide at the end of each round.

Round Gameplay:
Each round is divided into seven steps:
1. Five cards are drawn from the loot pile and placed face down in the center of the table. After the first round, any remaining loot from previous rounds is added to the new loot.
2. Each player secretly selects a bullet card and places it face down in front of them. This card cannot be reused later.
3. All players count to three and simultaneously point their index finger at another player, indicating their target.
4. After another count to three, each player may decide to fold (place their hand on the table) or remain in the game by shouting "Pitbull!" Those who fold cannot be injured but are excluded from the loot share. If a folded player is targeted, their attacker discards their card without revealing it.
5. Players who chose to play a King reveal their cards. These players fire first, injuring their target. Injured players discard their cards without revealing them and are excluded from the loot share.
6. The remaining players reveal their cards. Jacks and Queens injure their targets. If two players target each other simultaneously with these cards, both are injured. Cards 6, 7, 8, 9, and 10 (blanks) cause no injury.
7. Gangsters who are not folded and not injured share the loot. The loot is divided equally. For example, if 7 cards are to be shared among 3 players, each player picks two cards, and the remaining card is added to the loot for the next round.

Once these steps are completed, a new round begins from step one, for 8 rounds.
    """.trimIndent(),
    end = """
After the eighth round, the remaining players reveal their loot. The player with the most money wins (Kings are worth 1,000$, 2s are worth 2,000$, 3s are worth 3,000$, etc.).
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

private val getaway = GameModel(
    id = 31,
    name = "Getaway",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 3,
    maxPlayer = 8,
    goal = "The goal is to avoid being the last player left with cards in hand.",
    material = "One or two 52-card decks without jokers.",
    durationInMinutes = 30,
    howToPlay = """
Getaway is a trick-taking game where the cards are ranked from 2 to Ace. Here’s how the game is played:

1. All cards are dealt to the players by the dealer, who changes each round.
2. The player with the Ace of Spades begins the game by playing this card. The other players must play a card of the same suit if they have one. If not, they may play a card of any other suit (called "tochoo").
3. The first trick is discarded face down. In the next round, the player with the Ace of Spades starts again, playing any card they choose.
4. If all players play a card of the requested suit, the trick is discarded face down, and the game continues.
5. If a player cannot follow suit, they can play a "tochoo" card. This interrupts the trick, and the following players cannot play.
6. The player who played the highest card of the requested suit (or the last to play a tochoo) wins the trick and adds the cards to their hand.
7. If a player manages to discard all their cards, they enter "Getaway" mode. This player has left the table and cannot lose. However, they cannot discard their last card by winning a trick since they must start the next round. In this case, the player draws a card at random from the discard pile and plays it.

Special Rule:
- Before each new trick, a player may choose to add the hand of the player to their left to their own hand. If that player is already in Getaway, they take the hand of the next player on the left, and so on. The player whose hand was taken enters Getaway.
    """.trimIndent(),
    end = """
The game continues until one player is the last left with cards in hand. This player loses the game, and a new round can start.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

private val gileter = GameModel(
    id = 32,
    name = "Gileter",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 3,
    maxPlayer = 4,
    goal = "The goal is to win the most tricks over 13 rounds, but to win a trick, you need to play the second-highest card.",
    material = "A 52-card deck.",
    durationInMinutes = 45,
    howToPlay = """
Gileter is played with 52 cards for 4 players or 39 cards for 3 players (Hearts are removed). The cards are ranked from 2 to Ace, with Ace being the highest card.

In case of a tie, the suits are ranked as follows: Spades, Clubs, Diamonds, then Hearts. For example, a 9 of Spades beats a 9 of Hearts.

Gameplay:
- The dealer deals 13 cards to each player in stages: first 2 cards, then 4, then 3, and finally 1.
- The dealer starts the round by playing a face-up card on the table. The other players must place a face-down card.
- After all players have placed their cards, they are revealed simultaneously.
- The second-highest card wins the trick. If two cards have the same value, the card from the higher suit wins the round.
- The player with the weakest card in the previous round starts the next one.
- When all 13 tricks are played, each player scores 1 point for each trick they win.
    """.trimIndent(),
    end = """
The game ends when a player accumulates 21 points. If multiple players reach the same score, the player with the highest points wins. If they tie, a new round is played until one player wins.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

private val guess = GameModel(
    id = 33,
    name = "Guess",
    tagList = listOf(GameTagModel.NO_MATERIAL, GameTagModel.TEAM),
    minPlayer = 4,
    maxPlayer = 8,
    goal = "The goal is to make your teammates guess words using the fewest clues possible.",
    material = "No specific material is required.",
    durationInMinutes = 30,
    howToPlay = """
Players are split into two teams. A member of the first team selects a word (this word must not be a proper noun) and secretly communicates it to a player on the opposing team. This word must not be overheard by anyone else. From there, the two players will engage in a duel.

1. The player who received the word announces how many clues they believe it will take for their team to guess the word (e.g., "in 3 clues").
2. The player who gave the word may then challenge them and attempt to make their team guess the word with fewer clues (e.g., "I can do it in 2").
3. The team offering the fewest clues wins the challenge and proceeds to the guessing phase.

During the guessing phase:
- The clue-giver announces the first clue aloud. Their teammates must then guess the word.
- This process repeats until the agreed number of clues is used.

It’s allowed to use adjectives, conjugated verbs, etc., to help guess the word, but compound words (e.g., "top hat") or words sharing the same root are not allowed. However, similarly sounding words are permitted.

If there are more than two players per team, the members must discuss and offer one single answer.

Scoring:
- If a team guesses the word with 4 clues: no points.
- In 3 clues: 1 point.
- In 2 clues: 2 points.
- In 1 clue: 3 points.

Points are awarded based on the initial bid, not the actual number of clues used. For example, if a player bids they can guess in 2 clues but succeeds in 1, their team earns 2 points, not 3.

After each round of guessing, successful or not, the clue-giver selects a new word for a different player on the opposing team (but not the one they just challenged).
    """.trimIndent(),
    end = """
The first team to accumulate 20 points wins the game.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

private val liar = GameModel(
    id = 34,
    name = "Liar",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 4,
    goal = "The goal is to discard all of your cards.",
    material = "A 52-card deck.",
    durationInMinutes = 20,
    howToPlay = """
The game is played as follows:
- All cards are dealt among the players.
- The first player places a card face-up in the center of the table while announcing its suit (e.g., "Hearts").
- The next player must also place a card, face-down, while announcing the same suit. They can choose to tell the truth or lie.
- Each player continues in this manner.

Players can choose to lie about the suit they announce. For example, a player might declare "Hearts" while actually placing a Club face-down.

If a player suspects another of lying, they can call "liar." In this case, the accused player must reveal the card they just placed.

Two outcomes are possible:
- If the accused lied, they must take all the cards in the pile and add them to their hand. They then start the next round by playing a new face-up card of their choice.
- If the accused told the truth, the accuser must take all the cards and start a new round.
    """.trimIndent(),
    end = """
The first player to discard all of their cards wins the game. However, the other players continue playing until one player is left holding all 52 cards. This player is declared the loser.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.EASY
)

private val scopa = GameModel(
    id = 35,
    name = "Scopa",
    tagList = listOf(GameTagModel.CARDS, GameTagModel.TRICKS),
    minPlayer = 2,
    maxPlayer = 6,
    goal = "The goal is to accumulate the most tricks and score points in various categories.",
    material = "A 52-card deck without face cards.",
    durationInMinutes = 30,
    howToPlay = """
Scopa is played with 40 cards numbered 1 to 10. The Ace is the lowest card. The objective is to collect as many tricks as possible to score points.

Gameplay:
- The dealer deals 3 cards to each player and places 4 cards face-up in the center of the table.
- The remaining cards form the draw pile.
- The first player to the dealer’s left begins the round.
- On their turn, players have two options:
   - Take one or more cards from the table if the value of their card equals the sum of certain cards in the center. For example, playing a 3 to capture a 2 and a 1. It is forbidden to place a card if a valid capture is possible.
   - Place a card without capturing if no cards or sum of cards match the value of the played card.
- If a player clears all cards from the center, they score a "Scopa," earning a bonus point. The next player must place a card in the center.
- Once all players have played their 3 cards, the dealer deals 3 more cards to each player. No new cards are added to the center.
- The game continues until all cards have been played.

At the end of the round, the player who captured the last trick takes any remaining cards in the center. The dealer cannot score a Scopa on the last trick, even if their last card would allow it.

Scoring:
At the end of the round, 4 points are awarded for the following categories:
1. The player with the most cards.
2. The player with the most diamond cards.
3. The player with the most 7s.
4. The player holding the 7 of Diamonds.

In case of a tie in any category, no points are awarded for that category.
    """.trimIndent(),
    end = """
The game ends when one player reaches 11 points with a lead of at least 2 points. If the lead is only 1 point, the game continues.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

private val yaniv = GameModel(
    id = 36,
    name = "Yaniv",
    tagList = listOf(GameTagModel.CARDS),
    minPlayer = 2,
    maxPlayer = 8,
    goal = "The goal is to reduce your hand to 7 points or less before the end of the round, and finish with the lowest score at the end of the game.",
    material = "A 52-card deck, plus 2 jokers. For games with 5 or more players, two decks are needed.",
    durationInMinutes = 30,
    howToPlay = """
The game consists of several rounds, with a point tally for each participant at the end of each round.

1. Card values are as follows:
   - Aces are worth 1 point.
   - Number cards from 2 to 10 are worth their face value.
   - Face cards (Jack, Queen, King) are worth 10 points each.
   - Jokers are worth 0 points.

2. The dealer deals 5 cards to each player and places the rest of the deck face-down in the center to form the draw pile.

3. On their turn, a player has two options:
   - Discard one or more cards (in a common discard pile) and then draw a card, either from the draw pile or from the most recently discarded card.
   - Declare "Yaniv" if they believe their total score is 7 or less. This ends the round and the points are counted.

Valid combinations that can be played in one go include:
- Sequences of at least three cards of the same suit (Aces cannot complete sequences with Queens and Kings, only with 2s and 3s).
- Pairs, triplets, or quads of cards with the same value.

Jokers can substitute any card in these combinations.

When drawing from the discard pile:
- You may take a card from the end of a sequence or a triplet/quad (this card can be a joker).
- You may also replace a joker in a sequence if you have the corresponding card (you cannot replace a joker in a triplet or quad).
    """.trimIndent(),
    end = """
Scoring:
- When a player declares Yaniv, they reveal their hand. If another player has a total score equal to or less than the declarer, they may declare "Assaf" and reveal their hand.
- The player with the lowest hand wins the round and earns no points.
- If "Assaf" is declared, the Yaniv declarer receives a penalty: 30 points for one Assaf or 20 points for each Assaf if there are multiple challengers. All other players add the total value of their remaining cards to their score.

Special cases:
- If a player reaches an exact score of 100 or 200 points, their score is reduced (to 50 or 100 points, respectively).
The game ends when a player exceeds 200 points. The player with the lowest score wins.
    """.trimIndent(),
    difficultyLevel = GameDifficultyLevelModel.MEDIUM
)

val gameListInEnglish = listOf(
    barbu,
    thirtyOne,
    corsicaBattle,
    corruption,
    president,
    canasta,
    spikeLady,
    fiveThousand,
    solitaire,
    elevator,
    tamalou,
    yahtzee,
    kems,
    nightyNine,
    pyramid,
    fuckTheDealer,
    shoshoi,
    sevenAndHalf,
    threeMan,
    rami,
    crapette,
    pileOfShit,
    lousy,
    fourHundredTwentyOne,
    eightAmerican,
    gangsters,
    getaway,
    gileter,
    guess,
    liar,
    scopa,
    yaniv
).sortedBy { it.name }
