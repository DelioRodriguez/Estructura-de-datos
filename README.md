# Sistema de Control de Estudiantes

## Objetivo

El objetivo de esta práctica fue crear una aplicación en Java que permita a un docente llevar el control de estudiantes y sus calificaciones por asignatura y grupo. Para ello, se aplicaron los conceptos de **herencia**, **polimorfismo**, **encapsulamiento** y uso de colecciones (`ArrayList`).

---

## Desarrollo

Se implementó un menú interactivo en consola que permite:

- Crear asignaturas
- Agregar grupos a una asignatura
- Agregar estudiantes (presenciales o a distancia)
- Registrar calificaciones (examen y práctica)
- Ver las notas de cada grupo
- Calcular el porcentaje de estudiantes aprobados

> El sistema no utiliza base de datos. Todos los datos se almacenan en memoria durante la ejecución.

---

## Estructura del Código

El sistema está dividido en clases, cada una con una responsabilidad específica:

| Clase                | Descripción                                                                 |
|----------------------|------------------------------------------------------------------------------|
| `Student`            | Clase abstracta base para todos los estudiantes.                             |
| `OnCampusStudent`    | Hereda de `Student`, representa a estudiantes presenciales.                  |
| `RemoteStudent`      | Hereda de `Student`, representa a estudiantes a distancia.                   |
| `Group`              | Representa un grupo de estudiantes dentro de una asignatura.                 |
| `Subject`            | Representa una asignatura que contiene uno o varios grupos.                  |
| `OperationResult`    | Modelo para manejar respuestas exitosas o con errores en las operaciones.   |

---

## Organización de Carpetas

```bash
src/
├── Main.java
└── models/
    ├── Student.java
    ├── OnCampusStudent.java
    ├── RemoteStudent.java
    ├── Group.java
    ├── Subject.java
    └── OperationResult.java
