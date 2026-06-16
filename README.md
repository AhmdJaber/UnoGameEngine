# UNO Game Engine

A flexible, extensible UNO game engine built in Java. Designed so that developers can plug in their own rules, cards, colors, and win conditions to build any variation of UNO — without touching the core engine.

---

## What it is

This is an **engine**, not a finished game. It gives you all the building blocks of UNO — cards, players, a deck, game flow — and lets you configure everything through a clean set of rules. Want 3 colors instead of 4? A different win condition? Custom card distribution? You just swap out the rule.

Two example game variants are included to show how it works:

- **BasicGame** — standard 4-player UNO with 7 starting cards, left-to-right direction, and a 500-point win target
- **AttackGame** — a 2-player variant with RGB colors, 5 starting cards, right-to-left direction, and a 200-point win target

---

## Project Structure

```
src/
├── game/          # Core engine (Game, BasicGame, AttackGame)
├── card/          # Card types, action cards, enums (Color, Type)
├── player/        # Player logic and Observer interface
├── rule/          # All pluggable rules:
│   ├── card/      # Card creation, distribution, initial hand size
│   ├── color/     # Color sets (Standard, RGB, RGYB)
│   ├── dealer/    # Who goes first
│   ├── direction/ # Left or right play direction
│   ├── match/     # Card matching logic
│   ├── points/    # Point calculation (positive/negative)
│   ├── shuffle/   # Deck shuffling strategies
│   └── win/       # Win condition
└── utility/       # Shared actions (DrawCards, ChangeColor, PassPlayers, ReverseDirection)
```

---

## How to Run

Open the project in **IntelliJ IDEA**, then run:

```
src/GameDriver.java
```

That launches `AttackGame` by default. Swap it with `BasicGame` or your own custom game class to try different configurations.

---

## Create Your Own Game Variant

Extend `Game` and override the init methods:

```java
public class MyGame extends Game {

    @Override
    public void initPlayers() {
        this.setPlayerCreation(new StandardPlayerCreation(3)); // 3 players
    }

    @Override
    public void initColors() {
        this.setColorInitialization(RGBColorInitialization.getInstance()); // RGB colors
    }

    @Override
    public void initWin() {
        this.setWin(new PositiveWin(300)); // first to 300 points wins
    }

    // ... implement the remaining init methods
}
```

Then call it from `GameDriver`:

```java
Game myGame = new MyGame();
myGame.play();
```

---

## Key Design Patterns Used

- **Template Method** — `Game` defines the game flow; subclasses fill in the rules
- **Strategy** — every rule (shuffle, match, win, points...) is swappable at runtime
- **Factory Method** — card and player creation via `CardCreation` and `PlayerCreation`
- **Singleton** — stateless rule classes (e.g. `RandomShuffle`, `MatchTypeOrColor`) are singletons
- **Observer** — players observe game events through the `Observer` interface

---

## Tech

- Java
- IntelliJ IDEA (`.iml` project file included)
