# Space War 2D

Juego 2D de naves espaciales desarrollado en Java con AWT/Swing, refactorizado para aplicar el **Principio de Inversión de Dependencias (DIP)** y el patrón de diseño **Abstract Factory**.

## Descripción

El objetivo de este proyecto es desacoplar la lógica del juego del estilo de visualización de sus elementos. Esto permite intercambiar estilos visuales de forma transparente, sin modificar el núcleo del juego, cambiando únicamente un archivo de configuración.

### Estilos visuales soportados

| Estilo | Descripción |
|--------|-------------|
| **Sprite** | Renderizado con imágenes/sprites (estilo original) |
| **Vector** | Renderizado con primitivas gráficas: triángulos, rectángulos y círculos (estilo retro) |

## Requisitos

- Java 8 o superior
- Maven 3.x

## Compilar y ejecutar

### 1. Compilar el proyecto

```bash
mvn clean install
```

### 2. Ejecutar el juego

```bash
java -cp target/2dgame-1.0-SNAPSHOT.jar com.balitechy.spacewar.main.Game
```

### 3. Cambiar el estilo visual

Editar el archivo `src/main/resources/config.properties`:

```properties
# Opciones: sprite, vector
visual.style=sprite
```

Cambiar a `vector` para el estilo retro. Luego recompilar con `mvn clean install` y ejecutar de nuevo.

## Controles

| Tecla | Acción |
|-------|--------|
| ← → | Mover horizontalmente |
| ↑ ↓ | Mover verticalmente |
| Espacio | Disparar |

## Arquitectura

Se aplicaron los siguientes principios y patrones:

### Principio de Inversión de Dependencias (DIP)

Las clases del juego (`Game`, `Player`, `Bullet`) dependen de **interfaces** (abstracciones), no de implementaciones concretas:

- `PlayerRenderer` — interfaz para renderizar la nave
- `BulletRenderer` — interfaz para renderizar las balas
- `GameBackgroundRenderer` — interfaz para renderizar el fondo

### Patrón Abstract Factory

La interfaz `GameElementFactory` define la creación de todos los renderers. Cada estilo visual tiene su fábrica concreta:

- `SpriteElementFactory` → crea `SpritePlayerRenderer`, `SpriteBulletRenderer`, `BitmapBackgroundRenderer`
- `VectorElementFactory` → crea `VectorPlayerRenderer`, `VectorBulletRenderer`, `VectorBackgroundRenderer`

### Diagrama de clases

```
                    ┌──────────────────────┐
                    │  GameElementFactory   │ (interfaz)
                    │──────────────────────│
                    │ createPlayerRenderer()│
                    │ createBulletRenderer()│
                    │ createBackgroundR()   │
                    └──────────┬───────────┘
                    ┌──────────┴───────────┐
          ┌─────────┴──────┐     ┌─────────┴──────┐
          │SpriteElement   │     │VectorElement   │
          │Factory         │     │Factory         │
          └────────────────┘     └────────────────┘

          PlayerRenderer (interfaz)
          ├── SpritePlayerRenderer
          └── VectorPlayerRenderer

          BulletRenderer (interfaz)
          ├── SpriteBulletRenderer
          └── VectorBulletRenderer

          GameBackgroundRenderer (interfaz)
          ├── BitmapBackgroundRenderer
          └── VectorBackgroundRenderer
```

### Extensibilidad

Para agregar un nuevo estilo visual en el futuro:

1. Crear las 3 implementaciones de renderers (`NuevoPlayerRenderer`, `NuevoBulletRenderer`, `NuevoBackgroundRenderer`)
2. Crear una nueva fábrica (`NuevoElementFactory`)
3. Agregar el nuevo valor en `config.properties`

**No es necesario modificar ninguna clase existente del juego.**

## Estructura del proyecto

```
src/main/java/com/balitechy/spacewar/main/
├── Game.java                    # Clase principal del juego
├── Player.java                  # Lógica del jugador
├── Bullet.java                  # Lógica de las balas
├── BulletController.java        # Controlador de balas
├── InputHandler.java            # Manejo de teclado
├── SpritesImageLoader.java      # Utilidad para cargar sprites
├── GameElementFactory.java      # Abstract Factory (interfaz)
├── SpriteElementFactory.java    # Fábrica concreta (sprites)
├── VectorElementFactory.java    # Fábrica concreta (vectorial)
├── PlayerRenderer.java          # Interfaz de renderizado del jugador
├── BulletRenderer.java          # Interfaz de renderizado de balas
├── GameBackgroundRenderer.java  # Interfaz de renderizado del fondo
├── SpritePlayerRenderer.java    # Jugador con sprites
├── SpriteBulletRenderer.java    # Balas con sprites
├── BitmapBackgroundRenderer.java# Fondo con imagen
├── VectorPlayerRenderer.java    # Jugador vectorial (triángulo)
├── VectorBulletRenderer.java    # Balas vectoriales (rectángulo)
└── VectorBackgroundRenderer.java# Fondo vectorial (círculo)

src/main/resources/
└── config.properties            # Configuración del estilo visual
```

## Autor

Carlos Andres Diaz Mendez | Maria Jose Palomino | Manuel Carreño
