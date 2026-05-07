# Quick Release - Bowling Tournament System

## Overview
Quick Release is a Java console application that allows users to create and manage bowling leagues and tournaments. Users can register, log in, and join tournament waitlists. The system simulates real bowling event management including oil patterns and difficulty levels.

---

## Features

### User System
- User registration and login
- Stored using a Map for fast lookup
- View all registered users

### League System
- Create leagues with custom oil patterns
- View all leagues
- Sorted by difficulty (oil ratio)

### Tournament System
- Create tournaments with oil patterns
- View all tournaments
- Sorted by difficulty (oil ratio)

### Oil Pattern System
Each league/tournament includes:
- Pattern name
- Length (32–60 feet)
- Oil volume (ml)
- Lane ratio (difficulty level)

### Tournament Waitlist (Queue)
- Users can join tournament waitlist
- FIFO system (first in, first out)
- Serve next player in order

### Action History (Stack)
- Tracks system actions
- View recent actions
- Undo last action

---

## Data Structures Used

- List → storing leagues and tournaments
- Map → storing users by username
- Queue → tournament waitlist system
- Stack → action history / undo system
- Comparable → sorting leagues and tournaments by difficulty

---

## Sorting
Leagues and tournaments are sorted by oil pattern ratio:
- Lower ratio = harder conditions
- Higher ratio = easier conditions

---

## How to Run

1. Open project in IntelliJ / VS Code
2. Ensure Java 8+ is installed
3. Run `Main.java`
4. Use console menu to interact

---

