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

```text
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
```




### COMO CORRER:
- Acceder a la carpeta correcta con: cd DYAS-GoF-CreationalPatterns-GameRefactoring
- Correr el juego desde la terminal con MAVEN y el comando: mvn exec:java "-Dexec.mainClass=com.balitechy.spacewar.main.Game"
- Se puede acceder al menu de cambio de estilo con la tecla 'M'.


## Parte II – Sistema de Fabricación de Pizzas (Fábrica Abstracta)

Adicionalmente, se implementó un sistema de fabricación automática de pizzas, cuyo objetivo es desacoplar la lógica del proceso principal (preparar una pizza) de las variantes concretas de fabricación (tipo de masa).

Para esta parte se aplicó el patrón **Fábrica Abstracta**, ya que:

- La secuencia del proceso de preparación de la pizza es siempre la misma.
- Los detalles de bajo nivel (amasar, moldear y hornear) cambian según el tipo de pizza.
- Se espera que en el futuro puedan existir nuevas variantes sin modificar la lógica principal.

### Tipos de pizza implementados

- Pizza de masa delgada  
- Pizza de masa gruesa  
- Pizza de masa integral  

Cada tipo de pizza cuenta con sus propias implementaciones de:

- Amasador  
- Moldeador  
- Horneador  

### Funcionamiento general

El sistema central (**PreparadorPizza**) no conoce las clases concretas de amasado, moldeado u horneado.  
En su lugar, depende de una abstracción (**PizzaFactory**), que es la encargada de crear los objetos necesarios según el tipo de pizza seleccionado.

De esta forma:

- Cambiar el tipo de pizza no requiere modificar la lógica del preparador.
- Agregar un nuevo tipo de pizza solo implica crear nuevas clases concretas y su respectiva fábrica.

### Diagrama – Fábrica Abstracta (Pizzería)

```text
                 +----------------------+
                 |   PreparadorPizza   |
                 +----------------------+
                             |
                             v
                    +----------------+
                    | PizzaFactory  |  <<abstract>>
                    +----------------+
                      /        |        \
                     /         |         \
        +----------------+ +----------------+ +--------------------+
        | PizzaDelgada   | | PizzaGruesa   | | PizzaIntegral      |
        | Factory        | | Factory       | | Factory            |
        +----------------+ +----------------+ +--------------------+
             |     |     |     |     |     |     |     |     |
             v     v     v     v     v     v     v     v     v
         Amasador Moldeador Horneador  Amasador Moldeador Horneador  Amasador Moldeador Horneador
          Delgada  Delgada  Delgada    Gruesa   Gruesa   Gruesa    Integral Integral Integral
```
### Conclusión

Con la aplicación de los patrones Factory Method y Fábrica Abstracta, el proyecto logra:

- Un alto desacoplamiento entre la lógica principal y las implementaciones concretas.
- Facilidad para extender el sistema sin modificar código existente.
- Un diseño alineado con buenas prácticas de ingeniería de software y principios SOLID.

