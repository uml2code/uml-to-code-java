# UML2Code Java Library

**UML2Code** is an open-source library that converts UML diagrams into ready-to-use code skeletons.  
Designed for development teams and software architects, it accelerates the transition from design to implementation, ensures consistency across projects, and reduces boilerplate coding.  
With its lightweight and extensible architecture, UML2Code adapts to different workflows and programming languages.

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
│ │       │       ├── generators/    
│ │       │       │   ├── CodeGenerator.java
│ │       │       │   └── javaGenerator/       
│ │       │       │       ├── JavaClassGenearator.java
│ │       │       │       ├── JavaGenearator.java
│ │       │       │       ├── JavaGenearatorHelper.java
│ │       │       │       └── JavaKeywords.java
│ │       │       ├── model/                 
│ │       │       │   ├── classdiagram/  
│ │       │       │   │   ├── UmlAttribute.java
│ │       │       │   │   ├── UmlClass.java
│ │       │       │   │   ├── UmlMethod.java
│ │       │       │   │   ├── UmlParameter.java
│ │       │       │   │   └── Visibility.java
│ │       │       │   ├── sequence/        
│ │       │       │   └── usecase/        
│ │       │       ├── parsers/              
│ │       │       │   ├── UmlParser.java
│ │       │       │   ├── classdiagram/
│ │       │       │   │   ├── PlantUmlClassParser.java
│ │       │       │   │   └── Helpers.java
│ │       │       │   ├── sequence/   
│ │       │       │   └── usecase/          
│ │       │       └── module-info.java
│ │       └── resources/
│ │           └── templates/      
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
This project is licensed under the Apache-2.0 License.

