# Taller_1_Dise-ito
## Descripción del Proyecto

Este proyecto corresponde a un **refactoring** del juego **Space War 2D**, cuyo objetivo principal es aplicar **patrones de diseño creacionales (GoF)** para mejorar:

- La **flexibilidad del código**
- La **extensibilidad** del sistema
- La **separación de responsabilidades**
- El cumplimiento de principios **SOLID**, especialmente **OCP (Open/Closed Principle)**

El refactoring se enfoca principalmente en el **sistema visual del juego**, permitiendo cambiar el **estilo gráfico** (sprites, vectorial, vectorial colorido) **sin modificar la lógica del juego**.


## Solución Aplicada: Factory Method

Se implementó el **patrón Factory Method**, delegando la creación de objetos visuales a **fábricas especializadas**, según el estilo seleccionado por el usuario.

### Beneficios

- El juego **no conoce las clases concretas** que renderizan gráficos.
- Se pueden agregar nuevos estilos visuales **sin tocar el código existente**.
- El cambio de estilo se realiza dinámicamente mediante un **menú de selección**.

### Flujo general:

1. El usuario selecciona un estilo visual en `StyleMenu`
2. `FactoryProvider` retorna la fábrica adecuada
3. La fábrica crea:
   - `PlayerRenderer`
   - `BulletRenderer`
   - `BackgroundRenderer`
4. `Game` utiliza estas abstracciones sin conocer su implementación concreta

---

## Diagrama del Factory Method


                   +--------------------+
                   |   StyleMenu        |
                   +--------------------+
                              |
                              v
                   +--------------------+
                   | FactoryProvider   |
                   +--------------------+
                              |
              -----------------------------------
              |                |               |
              v                v               v
   +----------------+  +----------------+  +-------------------------+
   | SpriteFactory  |  | VectorFactory  |  | ColorfulVectorFactory  |
   +----------------+  +----------------+  +-------------------------+
              |                |               |
      ----------------   ----------------   ----------------
      |      |      |   |      |      |   |      |      |   
      v      v      v   v      v      v   v      v      v
 Player  Bullet  Background  Player  Bullet  Background  Player Bullet Background
Renderer Renderer Renderer  Renderer Renderer Renderer  Renderer Renderer Renderer




### COMO CORRER:
- Acceder a la carpeta correcta con: cd DYAS-GoF-CreationalPatterns-GameRefactoring
- Correr el juego desde la terminal con MAVEN y el comando: mvn exec:java "-Dexec.mainClass=com.balitechy.spacewar.main.Game"
- Se puede acceder al menu de cambio de estilo con la tecla 'M'.


