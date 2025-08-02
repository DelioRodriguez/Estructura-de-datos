Sistema de Control de Estudiantes
Objetivo
El objetivo de esta práctica fue crear una aplicación en Java que permita a un docente llevar el control de estudiantes y sus calificaciones por asignatura y grupo. Para ello, se aplicaron los conceptos de herencia, polimorfismo, encapsulamiento y uso de colecciones (ArrayList).

Desarrollo
Se implementó un menú interactivo en consola que permite:

Crear asignaturas

Agregar grupos a una asignatura

Agregar estudiantes (presenciales o a distancia)

Registrar calificaciones (examen y práctica)

Ver las notas de cada grupo

Calcular el porcentaje de estudiantes aprobados

El sistema no usa base de datos, todo se guarda en memoria mientras se ejecuta.

Estructura del código
Se crearon varias clases:

Student (abstracta): clase base para los estudiantes.

OnCampusStudent y RemoteStudent: extienden Student y calculan la nota final según el tipo.

Group: representa un grupo de estudiantes dentro de una asignatura.

Subject: representa una asignatura con sus grupos.

OperationResult: clase para manejar respuestas exitosas o con errores.

El código está dividido en archivos y organizado en carpetas (src/models), siguiendo buenas prácticas básicas de programación orientada a objetos.
