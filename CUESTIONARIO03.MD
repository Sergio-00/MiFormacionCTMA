# Cierre Metacognitivo - Semana 03: Desarrollo de Aplicaciones Móviles Android (SENA - CTMA)

### 1. ¿Qué dato de Semana 2 fue más difícil de convertir en una decisión visual y por qué?

**Respuesta:** El dato más complejo de representar visualmente fue el cálculo derivado del estado de urgencia de la actividad (basado en la propiedad `diasRestantes` y la prioridad). Traducir un valor numérico negativo o cercano a cero en un indicador gráfico intuitivo requirió definir reglas claras de diseño (como el uso de etiquetas dinámicas en el `DetalleActividadDialog` e indicadores de color condicionales) para evitar saturar al usuario con texto explicativo innecesario y mantener la claridad según los principios de Material Design 3 (Android Developers, 2024).

---

### 2. ¿Qué recomposición observaste y qué la provocó?

**Respuesta:** Se observó la recomposición de la lista de actividades (`LazyColumn` / `LazyVerticalGrid`) en el momento en que el usuario interactuó con el campo de texto `OutlinedTextField` o con el `FilterChip` de actividades urgentes. Esta recomposición fue provocada por la actualización de las variables de estado `textoBusqueda` y `soloUrgentes`, modificadas mediante los eventos `onValueChange` y `onClick`. Al estar estas variables vinculadas con el cálculo del estado `actividadesFiltradas`, Compose detectó la lectura de un estado modificado y reejecutó únicamente las funciones composables afectadas (Android Developers, 2024).

---

### 3. ¿Qué barrera de accesibilidad detectaste antes de que la detectara un usuario?

**Respuesta:** Se identificó la falta de descripciones textuales explícitas en los contenedores de listas cuando el resultado de la búsqueda es vacío (`EstadoVacio`). Antes de agregar la propiedad `semantics { contentDescription = "No hay actividades disponibles" }`, las herramientas de asistencia como TalkBack no lograban comunicar adecuadamente a usuarios con discapacidad visual que la búsqueda no había arrojado resultados, dejando el lector en silencio o enfocando elementos genéricos sin contexto.

---

### 4. ¿Qué componente será reutilizable en la Semana 4?

**Respuesta:** El componente `TarjetaActividad` y el diálogo `DetalleActividadDialog` serán altamente reutilizables. Al estar diseñados mediante el patrón de elevación de estado (*State Hoisting*), dependen exclusivamente de parámetros de entrada (`ActividadFormativa`) y eventos pasados como lambdas (`onClick`, `onDismiss`). Esto permitirá conectarlos directamente a la siguiente capa de persistencia de datos (como una base de datos local con Room o la integración de ViewModel) en la Semana 4 sin necesidad de modificar su estructura interna (Martin, 2018).

---

### 5. ¿Qué deuda técnica queda registrada y no debe ocultarse?

**Respuesta:** La principal deuda técnica registrada es el uso de datos en memoria generados de forma estática en la clase `DatosEjemplo`. Aunque esto facilitó el desarrollo de la interfaz gráfica y las pruebas unitarias en `ReglasActividadTest.kt`, la aplicación aún carece de un repositorio de datos asíncrono y de persistencia local o remota. Esta limitación deberá resolverse en las siguientes iteraciones integrando componentes como `ViewModel` y bibliotecas de persistencia.

---

## Referencias Bibliográficas

- Android Developers. (2024). *Recomposition in Jetpack Compose*. Google Developers. https://developer.android.com/develop/ui/compose/mental-model#recomposition
- Android Developers. (2024). *Accessibility in Jetpack Compose*. Google Developers. https://developer.android.com/develop/ui/compose/accessibility
- Martin, R. C. (2018). *Clean Architecture: A Craftsman's Guide to Software Structure and Design*. Prentice Hall.