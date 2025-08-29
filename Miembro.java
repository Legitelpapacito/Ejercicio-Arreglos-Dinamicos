class Miembro {
    private int id;
    private String nombre;
    private int edad;
    private String tipoMembresia;
    private Entrenador entrenador;
    private Rutina rutinaActiva;

    public Miembro(int id, String nombre, int edad, String tipoMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoMembresia = tipoMembresia;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setRutinaActiva(Rutina rutina) {
        this.rutinaActiva = rutina;
    }

    public Rutina getRutinaActiva() {
        return rutinaActiva;
    }

    public int getId() {
        return id;
    }

    // Getters/setters omitidos
}