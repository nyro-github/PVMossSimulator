# PV Window & Moss Energy Output Simulator

![image](https://github.com/user-attachments/assets/1b7f2f6b-95d7-491d-a01f-3abf2d17d231)

## 🌱 Project Overview

This is a Java-based simulation tool I developed to estimate the daily energy contribution of a **double-skin façade** that combines:
- **Photovoltaic (PV) windows** as the outer layer
- A **moss-insulated bio-layer** on the inner side

The goal is to explore how such a façade could contribute to the Net-Zero ambitions of the TU/e campus by 2030. The simulator allows real-time manipulation of environmental parameters, shows dynamic output, and helps visualize how different conditions impact energy generation.

This project was part of the **CBL: Net Zero TU/e Campus 2030** challenge, and developing this application was **my primary responsibility** in the group.

---

## ⚙️ Features

- 🖥️ Interactive GUI built in Java Swing
- 📦 Modular codebase (parameters, output calculators, UI logic)
- 🔧 User-controllable parameters:
  - Sunlight level
  - Cloud cover
  - Façade temperature
  - Total façade area
  - PV window angle
  - Moss moisture & humidity
- 🎛️ Preset scenarios (e.g. “Spring Morning”, “Cloudy Winter”)
- 🔋 Output includes:
  - Solar energy input
  - Energy captured by PV windows
  - Moss-based bioenergy estimation
  - Combined system energy output
  - Status of moss (“Thriving”, “Dormant”, etc.)

---

## 🔬 Scientific Scope

The simulation relies on simplified yet physically plausible models:

### ☀️ PV Energy
- Assumes 1000 W/m² peak irradiance
- Adjusts for angle of incidence, cloudiness, and temperature
- Uses a 10% efficiency typical for semi-transparent PV glass

### 🌿 Moss Energy
- Based on moisture/humidity-driven biomass growth
- Converts biomass to energy with a 0.005 kWh/g rate
- Includes temperature response factor

This creates a balanced, realistic simulation suited for early-stage design analysis and conceptual testing.

---

## 📸 Screenshots

<details>
<summary>☀️ Spring Morning with Clear Skies</summary>

![image](https://github.com/user-attachments/assets/16087e8f-6284-431b-9c92-645bf6249795)

</details>

<details>
<summary>🌥️ Cloudy Winter Morning</summary>

![image](https://github.com/user-attachments/assets/92d86d08-9481-4a30-a45e-c9a6c9adeb5b)


</details>

<details>
<summary>💧 High Humidity, Low Sunlight Scenario</summary>

![image](https://github.com/user-attachments/assets/23fc67e4-9875-4506-b8a4-51b0ce3a46af)

</details>

---

## 🧑‍💻 About the Code

I built this entire simulator from the ground up as my main contribution to our CBL project. I was responsible for:
- Designing and programming the GUI
- Creating the parameter management system
- Implementing the energy calculation logic
- Integrating presets and control logic
- Handling real-time feedback and output formatting

The architecture is modular and easy to expand, making it suitable for further refinement or adaptation to other façade-based technologies.

---

## 🚀 How to Run

1. Ensure you have **Java 21** installed.
2. Clone or download the repository.
3. Open the project in your IDE.
4. Run the main GUI class (`MainFrame.java`) inside the `gui` package.

---

## 📄 License

This application was created for academic purposes as part of the CBL 4CBLW00 course at TU/e. For reuse or collaboration, please contact me directly.

