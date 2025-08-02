import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Subject> subjects = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Sistema de Control de Calificaciones ===");
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                1. Crear asignatura
                2. Agregar grupo
                3. Agregar estudiante
                4. Registrar calificaciones
                5. Mostrar notas por grupo
                6. Calcular % de aprobación
                0. Salir
                """);
            switch (scanner.nextLine()) {
                case "1" -> createSubject();
                case "2" -> addGroup();
                case "3" -> addStudent();
                case "4" -> registerGrades();
                case "5" -> showGrades();
                case "6" -> showApprovalRate();
                case "0" -> exit = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }

    static Subject findSubject(String name) {
        return subjects.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private static void createSubject() {
        System.out.print("Nombre de la asignatura: ");
        String name = scanner.nextLine();
        subjects.add(new Subject(name));
        System.out.println("Asignatura creada.");
    }

    private static void addGroup() {
        System.out.print("Asignatura: ");
        String subjectName = scanner.nextLine();
        Subject s = findSubject(subjectName);
        if (s == null) {
            System.out.println("Asignatura no encontrada.");
            return;
        }
        System.out.print("Nombre del grupo: ");
        String groupName = scanner.nextLine();
        s.createGroup(groupName);
        System.out.println("Grupo creado.");
    }

    private static void addStudent() {
        System.out.print("Asignatura: ");
        String subjectName = scanner.nextLine();
        Subject s = findSubject(subjectName);
        if (s == null) {
            System.out.println("Asignatura no encontrada.");
            return;
        }
        System.out.print("Grupo: ");
        String groupName = scanner.nextLine();
        Group g = s.getGroups().stream().filter(gr -> gr.getGroupName().equalsIgnoreCase(groupName)).findFirst().orElse(null);
        if (g == null) {
            System.out.println("Grupo no encontrado.");
            return;
        }
        System.out.print("Tipo (1-Presencial, 2-Distancia): ");
        String type = scanner.nextLine();
        System.out.print("ID del estudiante: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();

        Student student = type.equals("1") ? new OnCampusStudent(id, name) : new RemoteStudent(id, name);
        g.addStudent(student);
        System.out.println("Estudiante agregado.");
    }

    private static void registerGrades() {
        System.out.print("Asignatura: ");
        Subject s = findSubject(scanner.nextLine());
        if (s == null) return;
        System.out.print("Grupo: ");
        String groupName = scanner.nextLine();
        Group g = s.getGroups().stream().filter(gr -> gr.getGroupName().equalsIgnoreCase(groupName)).findFirst().orElse(null);
        if (g == null) return;
        for (Student st : g.students) {
            System.out.printf("Notas para %s (%s):\n", st.name, st.id);
            System.out.print("  Examen: ");
            double exam = Double.parseDouble(scanner.nextLine());
            System.out.print("  Práctica: ");
            double practice = Double.parseDouble(scanner.nextLine());
            st.setScores(exam, practice);
        }
    }

    private static void showGrades() {
        System.out.print("Asignatura: ");
        Subject s = findSubject(scanner.nextLine());
        if (s == null) return;
        for (Group g : s.getGroups()) {
            g.printGrades();
        }
    }

    private static void showApprovalRate() {
        System.out.print("Asignatura: ");
        Subject s = findSubject(scanner.nextLine());
        if (s == null) return;
        for (Group g : s.getGroups()) {
            System.out.printf("Grupo %s - Aprobados: %.2f%%\n", g.getGroupName(), g.getApprovalRate());
        }
    }
}
