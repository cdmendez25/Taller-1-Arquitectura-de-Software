# Space War 2D

Juego 2D de naves espaciales con dos estilos visuales: sprites y vectorial retro.

## Requisitos

- Java 8 o superior
- Maven 3.x

## Compilar

```bash
mvn clean install
```

## Ejecutar

```bash
java -cp target/2dgame-1.0-SNAPSHOT.jar com.balitechy.spacewar.main.Game
```

## Cambiar estilo visual

Editar `src/main/resources/config.properties`:

- **Sprites (imágenes):** `visual.style=sprite`
- **Vectorial (figuras):** `visual.style=vector`

Después de cambiar el estilo, recompilar con `mvn clean install` y ejecutar de nuevo.

## Controles

| Tecla | Acción |
|-------|--------|
| ← → ↑ ↓ | Mover la nave |
| Espacio | Disparar |

## Autor

Carlos Díaz | Maria Jose Palomino | Manuel Carreño
