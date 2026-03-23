# Sistema de Gestión de Tareas

## Descripción del Proyecto
Este proyecto consiste en el desarrollo de un sistema de gestión de tareas personales implementado en Java, aplicando principios de Programación Orientada a Objetos (POO).

El sistema permite a un usuario administrar sus tareas mediante un calendario personal, donde puede crear, editar, eliminar y consultar tareas según diferentes criterios.

El objetivo principal del proyecto es demostrar la correcta aplicación de conceptos como encapsulamiento, abstracción, composición, agregación y dependencia entre clases dentro de un sistema funcional.

---

## Funcionalidades del Sistema

- Crear nuevas tareas con una descripción y fecha límite  
- Editar tareas existentes  
- Eliminar tareas  
- Marcar tareas como completadas  
- Visualizar todas las tareas registradas  
- Consultar tareas pendientes  
- Filtrar tareas dentro de un rango de fechas  
- Filtrar tareas pendientes dentro de un rango de fechas  

---

## Estructura del Proyecto

### Usuario
Representa al usuario del sistema y contiene:
- Nombre  
- Correo electrónico  
- Contraseña  

Cada usuario posee un calendario propio desde el cual gestiona sus tareas.

---

### Calendario
Encargado de administrar las tareas del usuario:
- Registrar tareas  
- Buscar tareas por ID  
- Actualizar tareas  
- Eliminar tareas  
- Filtrar tareas por rango de fechas  

---

### Tarea
Representa una tarea individual:
- Identificador único  
- Descripción  
- Fecha y hora límite  
- Estado (pendiente o completada)  

---

### Main
Punto de entrada del sistema donde se ejecuta la aplicación.

---

## Conceptos de Programación Orientada a Objetos Aplicados

### Encapsulamiento
Los atributos son privados y se accede a ellos mediante métodos públicos, protegiendo el estado interno.

### Abstracción
Cada clase representa una entidad del sistema con responsabilidades específicas.

### Composición
Existe entre `Usuario` y `Calendario`, ya que el calendario depende del usuario.

### Agregación
Existe entre `Calendario` y `Tarea`, donde el calendario contiene múltiples tareas.

### Dependencia
Las clases utilizan otras para cumplir funciones específicas (ej: Usuario usa Calendario).

---

## Tecnologías Utilizadas

- Java  
- Programación Orientada a Objetos  
- UML  
- Git y GitHub  

---

# Autor

Alexander Gonzalez Castillo

Proyecto desarrollado para el curso de Programación Orientada a Objetos.
