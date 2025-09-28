# 🐍 Snake Game in Java  

A classic **Snake Game** implemented in Java with customizable features such as colors, difficulty levels, and speed. The game includes a scoring system, high scores tracking, and smooth gameplay mechanics.  

---

## ✨ Features  

- Classic snake gameplay with collision detection  
- High score tracking (`HighScores.java`)  
- Difficulty settings (`Setdifficulce.java`, `Speed.java`)  
- Customizable game colors:  
  - Snake body (`SetSnakeColor.java`)  
  - Snake head (`SetHeadColor.java`)  
  - Food (`SetFoodColor.java`)  
  - Walls (`SetWallColor.java`)  
  - Background (`SetBackgroundColor.java`)  
- Map rendering (`Map.java`)  
- Multi-threaded snake movement (`SnakeThread.java`)  
- Object-oriented design with modular classes  

---

## 📂 Project Structure  

```
├── Game.java               # Main game loop and entry point
├── HighScores.java         # High score management
├── Map.java                # Game map rendering and layout
├── Node.java               # Snake body node structure
├── Oursnake.java           # Snake logic (growth, collisions, movement)
├── Snake.java              # Main snake class with attributes and methods
├── SnakeThread.java        # Thread handling snake movement and updates
├── Speed.java              # Speed control for different difficulty levels
├── SetBackgroundColor.java # Background color customization
├── SetSnakeColor.java      # Snake body color customization
├── SetHeadColor.java       # Snake head color customization
├── SetFoodColor.java       # Food color customization
├── SetWallColor.java       # Wall color customization
├── Setdifficulce.java      # Difficulty settings (easy, medium, hard)
```

---

## 🖥️ Requirements  

- **Java JDK 8+**  
- Works on Windows, Linux, and macOS  
- Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or terminal with `javac`  

---

## ▶️ How to Run  

1. Clone or download the repository:  
   ```bash
   git clone https://github.com/your-username/snake-game-java.git
   cd snake-game-java
   ```

2. Compile all Java files:  
   ```bash
   javac *.java
   ```

3. Run the game:  
   ```bash
   java Game
   ```

---

## 🎮 Controls  

- **Arrow Keys** → Move the snake (Up, Down, Left, Right)  
- **Esc / Q** → Quit the game  

---

## 🏆 High Scores  

- Scores are tracked via `HighScores.java`.  
- Top scores are displayed after each game session.  
- Can be extended to save scores to a file or database.  

---

## ⚙️ Customization  

This project allows you to **customize** various aspects of the game:  

- **Difficulty** → `Setdifficulce.java` (Easy, Medium, Hard)  
- **Speed** → `Speed.java` (snake movement speed)  
- **Colors** →  
  - Snake (`SetSnakeColor.java`, `SetHeadColor.java`)  
  - Food (`SetFoodColor.java`)  
  - Walls (`SetWallColor.java`)  
  - Background (`SetBackgroundColor.java`)  

---

## 📸 Screenshots (Optional)  

_Add screenshots or gameplay GIFs here_  

---

## 🛠️ Future Improvements  

- Add sound effects and background music  
- Power-ups (e.g., speed boost, bonus food)  
- Save/load game state  
- Multiplayer mode (local or networked)  

---

## 🤝 Contributing  

Contributions are welcome!  

1. Fork the repository  
2. Create a feature branch (`git checkout -b feature-name`)  
3. Commit changes (`git commit -m "Add feature"`)  
4. Push to your branch (`git push origin feature-name`)  
5. Open a Pull Request  

---

## 📜 License  

This project is licensed under the **MIT License** – free to use, modify, and distribute.  
