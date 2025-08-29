import java.util.ArrayList;
class Rutina {
    private int id;
    private String nombre;
    private String dificultad;
    private String objetivo;
    private boolean activa;
    private ArrayList<Ejercicio> ejercicios;

    public Rutina(int id, String nombre, String dificultad, String objetivo, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.objetivo = objetivo;
        this.activa = activa;
        this.ejercicios = new ArrayList<>();
    }

    public boolean agregarEjercicio(Ejercicio e) {
        if (e == null) return false;
        return ejercicios.add(e);
    }

    public boolean removerEjercicio(Ejercicio e) {
        return ejercicios.remove(e);
    }

    public int contarEjercicios() {
        return ejercicios.size();
    }

    public boolean isActiva() {
        return activa;
    }

    public int getId() { return id; }

    // Getters/setters restantes omitidos por brevedad
}