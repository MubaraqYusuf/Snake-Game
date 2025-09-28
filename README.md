# 🐍 SuperSnake

**SuperSnake** is a classic Snake game implemented in **Java**. It uses the **Apache Ant** build system and is structured for use with **NetBeans** or any IDE that supports Ant-based Java projects.

---

## 📋 Features

- Classic snake gameplay  
- Increasing difficulty as the snake grows  
- Score tracking  
- Simple and lightweight  
- Built with pure Java (no external dependencies)

---

## 🧰 Requirements

- **Java JDK** 8 or later  
- **Apache Ant** (if building manually)  
- (Optional) **NetBeans IDE** or any IDE that supports Ant projects

---

## ⚙️ Build & Run Instructions

### 🔨 Using Ant

1. Open a terminal in the project directory.
2. To **build** the project:
   ```bash
   ant build
   ```
3. To **run** the project:
   ```bash
   ant run
   ```

### 🧱 Using NetBeans

1. Open NetBeans.
2. Go to **File → Open Project**.
3. Select the project folder (containing `build.xml`).
4. Click **Run** ▶️ to start the game.

---

## 📦 Project Structure

```
SuperSnake/
├── build.xml        # Ant build script
├── manifest.mf      # Manifest file for JAR packaging
├── SuperSnake.txt   # Game source code or data file
├── dist/            # (Generated) compiled JAR files
└── nbproject/       # NetBeans project metadata
```

> Note: If your source files are in a different folder, ensure `build.xml` points to the correct `src` directory.

---

## 🕹️ How to Play

1. Run the game.
2. Use **arrow keys** (⬆️⬇️⬅️➡️) to move the snake.
3. Eat the food 🍏 to grow longer and score points.
4. Avoid hitting the walls or yourself.
5. Try to get the highest score!

---

## 📄 License

This project is for educational and personal use. You may modify and distribute it under your preferred open-source license.

---

## 👨‍💻 Author

Developed by [Your Name]
