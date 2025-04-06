# Chess

## Overview

This project is a console-based Chess game implemented in Java. Players can input moves using standard chess notation, and the game enforces movement rules for all pieces. The game features Forsyth-Edwards Notation (FEN) for initializing the board and ends when one player's King is captured.

## Features
- **Dynamic Gameplay**: Play a full chess game with move enforcement and turn-taking.
- **FEN Parsing**: Supports board initialization using Forsyth-Edwards Notation for debugging or custom setups.
- **Piece-Specific Logic**: Includes move validation for all chess pieces (King, Queen, Rook, Bishop, Knight, Pawn).
- **Victory Condition**: The game ends when a player's King is captured.
- **Player Turns**: Alternates between White and Black turns with clear prompts for input.

## Technology Stack
- **Language**: Java
- **Core Concepts**:
  - **Object-Oriented Programming (OOP)**: Modular design with classes for each piece and game components.
  - **Data Structures**: 2D arrays for board representation and HashMaps for FEN parsing.
  - **Input Parsing**: Supports structured input for moves.
  - **Unicode Chess Symbols**: Enhances readability of the board state.

## Classes
- **Piece**: Abstract base class for all chess pieces.
- **Pawn, Rook, Knight, Bishop, Queen, King**: Implement specific movement rules for each piece.
- **Board**: Represents the game board as a 2D array, manages piece placement, and handles move validation.
- **Fen**: Parses FEN strings to initialize the board with specific positions.
- **Game**: Entry point for running the chess game and managing player turns.

## How to Play
1. Clone the repository:
   - `git clone https://github.com/tennzzin/chess.git`
   - `cd chess`
2. Compile and run the game:
   - `javac *.java`
   - `java Game`
3. Follow the on-screen prompts:
   - Enter moves in the format `[start row] [start col] [end row] [end col]` (e.g., `1 0 3 0` for moving a pawn forward).
   - Alternate between White and Black turns.

## Skills Demonstrated
- **Algorithm Development**  
  Designed move validation algorithms for all chess pieces.
  
- **Data Parsing**  
  Implemented FEN parsing for initializing complex board states.
  
- **Object-Oriented Design**  
  Modularized game logic into reusable components for scalability and clarity.
  
- **Game Logic**  
  Managed game flow, alternating turns, and enforcing win conditions.

## Authors
- **Tenzin Chonyi** - [LinkedIn](https://www.linkedin.com/in/tenzin-chonyi)
- **Kalden Sopa** - [LinkedIn](https://www.linkedin.com/in/kalden-sopa/)
