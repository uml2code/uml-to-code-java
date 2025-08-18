# UML → Code Framework

An **open source** educational tool that transforms **UML diagrams** into **code skeletons**.  
Initial support: **Java**, with planned extensions for **C#** and **Python**.

---

## Purpose
Help students, teachers, and developers to:
- Visualize their UML diagrams.
- Quickly generate project skeletons in multiple languages.
- Save time during project setup.

---

## Features
- Import UML diagrams (PlantUML, XMI).
- Code generation (Java, C#, Python).
- Export generated projects as `.zip` files.
- Simple web interface (React + Spring Boot API).

---

## Project Structure
- `backend/` → REST API built with **Spring Boot** (Java).
- `frontend/` → **React.js** web application.
- `generators/` → Code generation templates (Java, C#, Python).
- `parsers/` → UML parsing modules (PlantUML, XMI, etc.).
- `examples/` → Sample UML files and generated code.
- `docs/` → Technical documentation and tutorials.


### Generate Code
1. Import your UML diagram (PlantUML or XMI).
2. Select your target language (Java, C#, Python).
3. Download the generated project as a `.zip` file.

---

## Contributing
Contributions are welcome! See the [`docs/`](docs/) folder for guidelines and tutorials.

---

## License
This project is licensed under the MIT License.

