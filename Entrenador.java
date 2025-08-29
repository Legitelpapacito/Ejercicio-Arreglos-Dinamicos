import java.util.ArrayList;

class Entrenador {
    private int id;
    private String nombre;
    private String especialidad;
    private ArrayList<Miembro> alumnos;

    public Entrenador(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.alumnos = new ArrayList<>();
    }

    public boolean agregarAlumno(Miembro m) {
        if (m == null) return false;
        if (!alumnos.contains(m)) {
            return alumnos.add(m);
        }
        return false;
    }

    public boolean removerAlumno(Miembro m) {
        return alumnos.remove(m);
    }

    public int contarAlumnos() {
        return alumnos.size();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
