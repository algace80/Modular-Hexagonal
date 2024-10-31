# Modular Hexagonal Architecture with Spring Boot

## Descripción

Este proyecto implementa una **arquitectura hexagonal** utilizando **Spring Boot** en un entorno **Maven**. La estructura modular del proyecto está diseñada para separar las diferentes capas de la arquitectura, lo que facilita la escalabilidad, el mantenimiento y las pruebas del código. Además, la aplicación está implementada bajo el patrón **CQRS** (Command Query Responsibility Segregation), que permite una gestión más eficiente de las operaciones de lectura y escritura.

## Estructura del Proyecto

El proyecto está dividido en varios módulos, cada uno representando una capa de la arquitectura hexagonal:

- **bootloader**: Contiene la clase `ModularHexagonalArchitectureMavenApplication`, que utiliza la anotación `@SpringBootApplication`. Esta clase es el punto de entrada para arrancar la aplicación.

- **application**: Esta capa contiene la lógica de aplicación y los casos de uso. Aquí se definen los servicios que orquestan la interacción entre el dominio y la infraestructura.

- **domain**: La capa de dominio encapsula la lógica de negocio y las reglas del dominio. Esta es la parte central de la aplicación, donde se definen los modelos y las entidades.

- **infrastructure**: En esta capa se implementan las interacciones con sistemas externos, como bases de datos, servicios web y otros componentes de infraestructura. Actúa como un adaptador entre el dominio y el entorno externo.

## Patrón CQRS

El patrón CQRS se utiliza en este proyecto para separar las operaciones de comando (escritura) y consulta (lectura). Esto permite optimizar el rendimiento y la escalabilidad al gestionar las operaciones de manera independiente, facilitando la implementación de diferentes estrategias de almacenamiento y consulta.

## ¿Por qué usar Arquitectura Hexagonal?

La arquitectura hexagonal, también conocida como **arquitectura de puertos y adaptadores**, ofrece varias ventajas:

1. **Desacoplamiento**: Permite separar las reglas de negocio de la infraestructura, facilitando la evolución del código y la implementación de cambios sin afectar otras partes de la aplicación.

2. **Facilidad de Pruebas**: Cada módulo se puede probar de manera independiente, simplificando la creación de pruebas unitarias y de integración.

3. **Flexibilidad**: Facilita la adición, modificación o reemplazo de adaptadores (como bases de datos o servicios externos) sin afectar la lógica del dominio.

4. **Escalabilidad**: Permite la expansión del proyecto mediante la incorporación de nuevos módulos o capas sin complicar la estructura existente.

## Colección de Insomnia

Se ha incluido una colección de Insomnia, que permite probar los servicios de la aplicación de manera sencilla. Puedes importar esta colección en Insomnia para interactuar con las diferentes APIs disponibles.

## Cómo Ejecutar el Proyecto

Para ejecutar la aplicación, sigue estos pasos:

1. Clona este repositorio:
   ```bash
   git clone https://github.com/algace80/Modular-Hexagonal.git
   ```

2. Navega a la carpeta del proyecto:
   ```bash
   cd Modular-Hexagonal
   ```

3. Ejecuta el proyecto utilizando Maven:
   ```bash
   mvn spring-boot:run
   ```

4. Accede a la aplicación en [http://localhost:8080](http://localhost:8080).

## Contribuciones

Las contribuciones son bienvenidas. Si tienes alguna sugerencia o mejora, no dudes en abrir un issue o enviar un pull request.
