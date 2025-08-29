
class Ejercicio {
    private String nombre;
    private String grupoMuscular;
    private int series;
    private int repeticiones;
    private int tiempoSeg;
    private String equipo;

    public Ejercicio(String nombre, String grupoMuscular, int series, int repeticiones, int tiempoSeg, String equipo) {
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticiones = repeticiones;
        this.tiempoSeg = tiempoSeg;
        this.equipo = equipo;
    }

    public boolean esPorTiempo() {
        return tiempoSeg > 0;
    }

}