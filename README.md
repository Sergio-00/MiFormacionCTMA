# MiFormacionCTMA

## Definición Inicial del Producto

### Problema

Los aprendices suelen gestionar múltiples actividades, evidencias y fechas de entrega durante su proceso formativo. Esto puede dificultar el seguimiento de compromisos importantes y aumentar el riesgo de olvidar tareas pendientes. MiFormacionCTMA busca ofrecer una solución sencilla que permita organizar actividades académicas, consultar fechas relevantes y mantener un mejor control del progreso formativo desde un dispositivo móvil.

### Tipos de Usuario

#### Aprendiz

**Necesidad:** Consultar actividades y fechas de entrega para organizar su proceso formativo.

#### Instructor

**Necesidad:** Realizar seguimiento al avance de las actividades de los aprendices.

### Historias de Usuario

#### Historia 1

> Como aprendiz, quiero visualizar mis actividades formativas para conocer las tareas pendientes.

**Criterio de aceptación:** Al ingresar a la aplicación, se muestra una sección con las actividades registradas.

---

#### Historia 2

> Como aprendiz, quiero consultar las fechas de entrega de mis evidencias para cumplir oportunamente con los compromisos formativos.

**Criterio de aceptación:** Cada actividad muestra una fecha límite visible para el usuario.

---

#### Historia 3

> Como instructor, quiero visualizar el estado de las actividades para realizar seguimiento al progreso de los aprendices.

**Criterio de aceptación:** Cada actividad muestra un estado identificable como pendiente o completada.

---

## Reto Adicional: Ordenamiento de Actividades (Semana 2)

Se implementó un ordenamiento personalizado para las actividades aplicando varios criterios mediante un comparador.

El primer criterio coloca las actividades vencidas al inicio de la lista. Para ello se comprueba el estado de cada actividad utilizando la función `estadoActividad()`, dando prioridad a aquellas cuyo estado sea `VENCIDA`.

El segundo criterio ordena las actividades según su prioridad, colocando primero las de prioridad `ALTA`, después las de prioridad `MEDIA` y finalmente las de prioridad `BAJA`.

El último criterio se aplica cuando dos actividades tienen la misma prioridad. En ese caso se ordenan por el número de días restantes (`diasRestantes`), mostrando primero las actividades con menos días disponibles, ya que tienen una fecha límite más cercana.

El comparador utilizado combina `compareBy`, `thenByDescending` y `thenBy` dentro de `sortedWith` para aplicar los criterios en el orden indicado por la guía. `compareBy` establece el criterio principal, `thenByDescending` agrega un criterio secundario de forma descendente y `thenBy` agrega un último criterio ascendente si los anteriores son iguales.

---

## Componentes, Filtrado Dinámico y Accesibilidad (Semana 3)

### Arquitectura de la Solución

El proyecto sigue los principios de Clean Architecture y la separación de responsabilidades en las siguientes capas:

1. **Capa de Modelo (`model`):** Define entidades inmutables como `ActividadFormativa`, `Prioridad` y `EstadoActividad`.
2. **Capa de Dominio (`domain`):** Contiene la lógica de negocio pura desacoplada de la interfaz gráfica (`ReglasActividad`).
3. **Capa de Interfaz de Usuario (`ui`):** Organizada en `components` (`EncabezadoFormacion`, `TarjetaActividad`, `DetalleActividadDialog`) y `screens` (`PantallaActividades`), adoptando el patrón de elevación de estado (*State Hoisting*).

### Funcionalidades e Interacción

- **Búsqueda Dinámica:** Filtrado de actividades en tiempo real mediante `OutlinedTextField`.
- **Filtrado por Urgencia:** Selección rápida de actividades con días restantes menores o iguales a 3 mediante `FilterChip`.
- **Cuadrícula y Lista Adaptable:** Renderizado responsivo con `LazyColumn` o `LazyVerticalGrid` según las dimensiones de la pantalla.
- **Detalle de Actividad:** Cuadro de diálogo modal (`AlertDialog`) activado al interactuar con cualquier tarjeta de actividad.

### Pruebas Unitarias

Se diseñó la suite de pruebas unitarias en `ReglasActividadTest.kt` utilizando JUnit 4 para la validación automatizada de los métodos `promedioProgreso` y `actividadesUrgentes`.

### Soporte de Accesibilidad y Temas

Se implementó soporte semántico para lectores de pantalla mediante modificadores de Compose, además de la adaptación automática entre **Modo Claro** y **Modo Oscuro** a través del esquema de colores centralizado en `MiFormacionCTMATheme`.

---

## Referencias Bibliográficas

- Android Developers. (2024). *State hoisting in Jetpack Compose*. Google Developers. https://developer.android.com/develop/ui/compose/state-hoisting
- Android Developers. (2024). *Testing in Jetpack Compose*. Google Developers. https://developer.android.com/develop/ui/compose/testing
- Martin, R. C. (2018). *Clean Architecture: A Craftsman's Guide to Software Structure and Design*. Prentice Hall.