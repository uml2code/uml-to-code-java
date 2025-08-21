# UML2Code Library

**UML2Code** is an open-source library that transforms UML diagrams into code skeletons.  
It is designed to be educational and lightweight, helping students and developers quickly move from design to implementation.

---

## Features
- Parse **UML Class Diagrams** (PlantUML, XMI in progress).
- Generate **code skeletons** in multiple languages:
  - Java
  - C#
  - Python
- Extensible architecture:
  - Add your own parsers for other UML notations.
  - Add new code generators for other languages.

---

## Project Structure
```
├──uml2code-lib/
│ ├── src/
│ │   └── main/
│ │       ├── java/
│ │       │   └── com/uml2code/
│ │       │       ├── model/                 
│ │       │       │   ├── classdiagram/  
│ │       │       │   ├── sequence/        
│ │       │       │   └── usecase/        
│ │       │       │
│ │       │       ├── parsers/              
│ │       │       │   ├── UmlParser.java
│ │       │       │   ├── classdiagram/
│ │       │       │   │   ├── PlantUmlClassParser.java
│ │       │       │   │   └── Helpers.java
│ │       │       │   ├── sequence/   
│ │       │       │   └── usecase/          
│ │       │       │
│ │       │       ├── generators/    
│ │       │       │   ├── CodeGenerator.java
│ │       │       │   ├── java/       
│ │       │       │   │   └── JavaClassGenerator.java
│ │       │       │   ├── csharp/      
│ │       │       │   │   └── CSharpClassGenerator.java
│ │       │       │   └── python/      
│ │       │       │       └── PythonClassGenerator.java
│ │       │       │
│ │       │       └── utils/               
│ │       │           └── FileUtils.java
│ │       │
│ │       └── resources/
│ │           └── templates/      
│ │
│ └── src/test/
│     └── java/
│         └── com/uml2code/
│             ├── parsers/  
│             |   ├── classdiagram/
│             |   ├── sequence/  
│             └── generators/  
├──examples/       # Example UML diagrams and generated code
├──docs/           # Documentation and tutorials
```

---

## Contributing
Contributions are welcome!
You can help by:
- Adding new UML parsers
- Adding new code generators
- Improving documentation

---

## License
This project is licensed under the MIT License.

