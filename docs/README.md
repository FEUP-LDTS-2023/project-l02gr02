## LDTS_T02_G02 - BomberMania

BomberMania is a thrilling 2-player game where the goal is to outsmart and blast your friends with bombs for victory. Unleash superpowers to upgrade your bombs, adding an extra layer of strategy to the explosive mayhem

> This project was made by Afonso Machado (up202207611@up.pt), Guilherme Coelho (up202000141@up.pt) and Luís Arruda (up202206970@up.pt) for LDTS 2023/2024

### IMPLEMENTED FEATURES

#### Main Menu
- Start Game - Allows the player to start the game.
- Exit - Closes the game.

![img](gifs/menu.gif)

### PLANNED FEATURES

- Placing bombs:
  
![img](gifs/drop.gif)

- Death for bomb explosion:
  
![img](gifs/death.gif)

- Breaking wall with bombs (explosion trail stops in unbreakable walls):
  
![img](gifs/breakingWall.gif)

- 2-Player Mode - Engage in a head-to-head gameplay with a friend.
- Push Bomb - Strategically shove bombs to trap and outmaneuver opponents.
- Portal - Transports the hero and triggered bombs to another location.
- Mega Explosion Bomb - Unleash a colossal explosion radius for maximum impact.
- Chain Reaction Bomb - Imediatlly explodes a nearly bomb
- Directional Explosion Bomb - Explodes in the same direction it is placed.
- Select map - Allows the player to choose between multiple maps.

#### Core Game
- Health - The player's hit points, enables the player to take damage, and on reaching 0, finishes the game.
- Bomb - Enables the player to deploy explosive devices strategically.
- Collision - Ensures the player cannot pass through undesired elements within the game environment.
- Movement - Allows the player to move the hero character.

### DESIGN

#### Separate the advancement of in-game time from both user input and processor speed.

**Problem in Context**

In BomberMania, multiple players, bombs, and power-ups coexist in the game world, and they need to interact seamlessly. For instance, managing the timing of bomb explosions, resolving collisions between players and obstacles, and handling the dynamic movement of both playersrequire careful synchronization. 

**The Pattern**

We have applied the **Game Loop** pattern. A game loop operates continuously throughout gameplay. With each iteration, it handles user input without causing delays, updates the game state, and renders the current game frame. It also keeps track of time to regulate the pace of gameplay.

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![Screenshot_from_2023-11-26_23-41-08](https://github.com/FEUP-LDTS-2023/project-l02gr02/assets/145804792/f90edeb6-eaa3-48a1-8905-df37068fbfc1)

#### KNOWN CODE SMELLS

In our development process, we actively utilized the "errorprone" plugin to detect known code smells as we progressed with the project. This tool served as a valuable aid in identifying and addressing common issues, allowing us to maintain a high level of code quality. By leveraging the errorprone plugin, we proactively identified potential code smells, fostering a more robust and maintainable codebase throughout the development lifecycle. This comprehensive approach has ensured that, as a result, our codebase is free from known code smells.

### TESTING

The testing strategy for "BomberMania" primarily relied on unit testing, leveraging JUnit and Jqwik to validate individual components.
The approach emphasized Property Based Testing, systematically validating functions across diverse inputs. 
Additionally, Mocks were strategically used in draw methods to confirm executions. 
This focused strategy aimed to deliver a robust test suite, showcasing the team's commitment to thorough validation and ensuring the resilience of the codebase.

### SELF-EVALUATION

- Afonso Machado: 1/3
- Guilherme Coelho: 1/3
- Luís Arruda: 1/3
