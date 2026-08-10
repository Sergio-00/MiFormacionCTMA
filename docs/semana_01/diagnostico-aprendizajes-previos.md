## 5.1 Parte A · Autopercepción

| Enunciado                                        | Nunca | Con apoyo | Autónomo | Podría explicarlo |
|--------------------------------------------------|-------|-----------|----------|-------------------|
| Puedo describir qué hace una aplicación móvil    |       | X         |          |                   |
| He usado un IDE y sé interpretar un error        |       |           |          | X                 |
| Puedo crear variables, condicionales y funciones |       |           |          | X                 |
| He utilizado Git para registrar cambios          |       |           | X        |                   |
| Distingo frontend, lógica y datos                |       | X         |          |                   |

---

## 5.2 Parte B · Preguntas de comprensión

### 1. ¿Qué diferencia práctica encuentras entre una aplicación móvil y una página web?

Una aplicación móvil puede acceder a funciones del dispositivo como cámara o almacenamiento y normalmente se instala en el sistema operativo. Una página web se ejecuta principalmente desde un navegador.

### 2. ¿Qué función cumple un sistema operativo como Android?

Android administra el hardware del dispositivo, la memoria, los permisos y permite ejecutar aplicaciones móviles.

### 3. ¿Qué es una variable? Escribe un ejemplo relacionado con una actividad formativa.

Es un espacio en memoria para almacenar información que puede utilizarse durante la ejecución del programa.

**Ejemplo:**

```kotlin
val actividad = "Configurar Android Studio"
```

### 4. ¿Qué estructura usarías para decidir si una actividad está vencida?

Usaría una condición `if` o `when`.

### 5. ¿Qué resultado esperas de una lista que almacena actividades?

Esperaría poder almacenarlas y recorrerlas para mostrarlas, filtrarlas o contarlas.

### 6. ¿Para qué sirve un sistema de control de versiones?

Permite registrar cambios, recuperar versiones anteriores y colaborar con otras personas.

### 7. ¿Qué información nunca debería subirse a un repositorio público?

Contraseñas, tokens, claves privadas, archivos de firma y datos personales sensibles.

### 8. ¿Qué harías primero si una aplicación se cierra inesperadamente?

Revisaría el mensaje de error que aparezca para identificar la causa y solucionarla.

### 9. Explica con tus palabras qué significa “probar” una aplicación.

Asegurarse de que funciona correctamente en diferentes situaciones, incluso si llegan a haber errores.

### 10. Identifica dos riesgos de privacidad en una app que almacena datos de aprendices.

* Exposición de datos personales de aprendices.
* Acceso no autorizado a evidencias o información académica.

---

## 5.3 Parte C · Mini-reto

### Respuesta del pseudocódigo:

* Si `progreso = 100`: se mostrara **"Actividad completada"**.
* Si `progreso = 60`: se mostrara **"Actividad pendiente"**.

### Mejora para un progreso inválido:

```text
si progreso < 0 o progreso > 100 entonces
    mostrar "Progreso inválido"
si no si progreso >= 100 entonces
    mostrar "Actividad completada"
si no
    mostrar "Actividad pendiente"
```

---

## 5.4 Cierre del diagnóstico

### Temas en los que necesito apoyo

* Manejo de componentes en Android.
* Organización de proyectos.

### Tema en el que podría apoyar

* Conceptos básicos de programación y lógica.
