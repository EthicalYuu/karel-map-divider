# Karel's Optimized Map Divider

> ⚠️ **Important:** This README provides a high-level overview of the project. For comprehensive details, including architecture, design decisions, and implementation, please refer to the [Project Documentation (PDF)](./Karel%20the%20Robot%20Documentation.pdf).

This project implements an optimized solution for dividing a map into specific regions using **Karel the Robot**. The task involves creating inner chambers as the largest possible equal squares and outer chambers as equal-sized L-shaped regions while adhering to constraints and optimizing resources.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Usage](#setup-and-usage)
- [Optimization Strategies](#optimization-strategies)
- [Future Enhancements](#future-enhancements)

## Description

The project involves dividing a given map into a 4 + 4 structure:
- Inner chambers are the largest possible equal squares.
- Outer chambers are equal-sized L-shaped regions, ensuring they are neither squares nor rectangles.

Constraints and objectives:
1. Karel must use the **lowest number of moves**.
2. Beeper usage must be optimized.
3. Code should be efficient, leveraging reusable functions.
4. Special cases are handled, such as maps too small to divide.

## Features

- Automatically determines map dimensions (width and height).
- Calculates the largest possible inner square and divides the map accordingly.
- Creates efficient reusable functions for:
  - Navigation (e.g., `faceNorth`, `moveTillEnd`).
  - Beeper placement optimization.
  - Handling even and odd map dimensions.
- Handles edge cases with custom methods.
- Tracks Karel’s moves to ensure minimum movements.

## Technologies Used

- **Karel Programming Environment**: A learning environment to teach programming concepts.
- **Java**: Implementation of Karel’s logic.
- **Stanford Karel Library**: For robot navigation and task execution.

## Setup and Usage

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/karel-map-divider.git
   cd karel-map-divider

2.  **Set up Karel's Environment**:
    -   Install the Stanford Karel development tools.
    -   Ensure you have the required libraries for running the `SuperKarel` program.
    
3.  **Run the Program**:
    -   Place `Homework.java` in the appropriate Karel project directory.
    -   Compile and execute the program in the Karel IDE.
    
4.  **Input Requirements**:
    -   Define the map's size and initial setup as per the problem requirements.
    -   Ensure Karel has 1000 beepers in the initial setup.

## Optimization Strategies

1.  **Reusable Functions**:
    -   Example: `faceNorth()`, `moveTillEnd()`, `moveNoSteps()`.
    -   Simplifies logic and minimizes code duplication.
    
2.  **Beepers Optimization**:
    -   Checks for existing beepers before placing new ones to avoid redundancy.
      
3.  **Move Optimization**:
    -   Custom functions like `moveTillEnd()` ensure the minimum number of moves.
  
4.  **Edge Case Handling**:
    -   Maps with odd/even dimensions are handled separately to ensure correct division.

## Future Enhancements

-   Optimize for scenarios with limited beepers.
-   Add visual debugging tools to illustrate Karel's movements and map changes in real-time.
-   Introduce new algorithms to further reduce moves in large maps.

## Documentation

For detailed documentation on the system's architecture, design, and implementation, please refer to the [Project Documentation (PDF)](./Karel%20the%20Robot%20Documentation.pdf).
