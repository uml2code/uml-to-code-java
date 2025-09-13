# Getting Started with UML2Code

## Prerequisites

- Java 17+ installed
- Your preferred IDE (IntelliJ, Eclipse, VS Code)
- Git (to clone the repository)

## Installation

Clone the repository:
```
git clone https://github.com/uml2code/uml-to-code-java.git
```

Build the project:

- Maven
    ```
    mvn clean install
    ```

## Basic Usage

- Generate Java code from a UML diagram:
```java
import com.uml2code.generators.javaGenerator.JavaGenerator;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        File umlFile = new File("examples/MyDiagram.puml");

        // Generate Java files in the default folder ./generated
        JavaGenerator.classDiagramToMultipleFiles(umlFile);

        // Or generate in a custom folder
        JavaGenerator.classDiagramToMultipleFiles(umlFile, "output/");
    }
}
```
- Default path:`./generated`
- Supported diagrams: PlantUML class diagrams (XMI support in progress)
