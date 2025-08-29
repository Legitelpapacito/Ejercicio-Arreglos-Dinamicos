import java.util.Scanner;
public class Principal {
    private Gimnasio gimnasio;

    public Principal() {
        gimnasio = new Gimnasio();
    }

    public void mostrarMenu() {
        System.out.println("==== MENÚ GIMNASIO ====");
        System.out.println("1. Agregar miembro");
        System.out.println("2. Agregar entrenador");
        System.out.println("3. Agregar rutina");
        System.out.println("4. Asignar entrenador a miembro");
        System.out.println("5. Asignar rutina a miembro");
        System.out.println("6. Consultar rutina más popular");
        System.out.println("7. Consultar entrenador con más alumnos");
        System.out.println("0. Salir");
    }

    public void ejecutarOpcion(int opcion, Scanner sc) {
        try {
            switch(opcion) {
                case 1:
                    System.out.print("ID: "); int idM = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Edad: "); int edad = sc.nextInt(); sc.nextLine();
                    System.out.print("Tipo de membresía: "); String tipo = sc.nextLine();
                    gimnasio.agregarMiembro(new Miembro(idM, nombre, edad, tipo));
                    break;
                case 2:
                    System.out.print("ID: "); int idE = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nE = sc.nextLine();
                    System.out.print("Especialidad: "); String esp = sc.nextLine();
                    gimnasio.agregarEntrenador(new Entrenador(idE, nE, esp));
                    break;
                case 3:
                    System.out.print("ID: "); int idR = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nR = sc.nextLine();
                    System.out.print("Dificultad: "); String dif = sc.nextLine();
                    System.out.print("Objetivo: "); String obj = sc.nextLine();
                    gimnasio.agregarRutina(new Rutina(idR, nR, dif, obj, true));
                    break;
                case 6:
                    Rutina popular = gimnasio.rutinaMasPopular();
                    System.out.println("Rutina más popular: " + (popular != null ? popular.getId() : "Ninguna"));
                    break;
                case 7:
                    Entrenador top = gimnasio.entrenadorConMasAlumnos();
                    System.out.println("Entrenador con más alumnos: " + (top != null ? top.getNombre() : "Ninguno"));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            p.mostrarMenu();
            System.out.print("Opción: ");
            op = sc.nextInt();
            p.ejecutarOpcion(op, sc);
        } while(op != 0);
        sc.close();
    }
}