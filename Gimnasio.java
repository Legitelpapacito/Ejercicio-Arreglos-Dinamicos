import java.util.ArrayList;
class Gimnasio {
    private ArrayList<Miembro> miembros;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Rutina> rutinas;

    public Gimnasio() {
        miembros = new ArrayList<>();
        entrenadores = new ArrayList<>();
        rutinas = new ArrayList<>();
    }

    // ---- Miembros ----
    public boolean agregarMiembro(Miembro m) throws Exception {
        if (buscarMiembroPorId(m.getId()) != null) {
            throw new Exception("Error: ID de miembro duplicado.");
        }
        return miembros.add(m);
    }

    public Miembro buscarMiembroPorId(int id) {
        for (Miembro m : miembros) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    // ---- Entrenadores ----
    public boolean agregarEntrenador(Entrenador e) throws Exception {
        if (buscarEntrenadorPorId(e.getId()) != null) {
            throw new Exception("Error: ID de entrenador duplicado.");
        }
        return entrenadores.add(e);
    }

    public Entrenador buscarEntrenadorPorId(int id) {
        for (Entrenador e : entrenadores) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    // ---- Rutinas ----
    public boolean agregarRutina(Rutina r) throws Exception {
        if (buscarRutinaPorId(r.getId()) != null) {
            throw new Exception("Error: ID de rutina duplicado.");
        }
        return rutinas.add(r);
    }

    public Rutina buscarRutinaPorId(int id) {
        for (Rutina r : rutinas) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    // ---- Asignaciones ----
    public boolean asignarEntrenador(int idMiembro, int idEntrenador) throws Exception {
        Miembro m = buscarMiembroPorId(idMiembro);
        Entrenador e = buscarEntrenadorPorId(idEntrenador);
        if (m == null || e == null) {
            throw new Exception("Error: Miembro o Entrenador no encontrado.");
        }
        m.setEntrenador(e);
        e.agregarAlumno(m);
        return true;
    }

    public boolean asignarRutinaActiva(int idMiembro, int idRutina) throws Exception {
        Miembro m = buscarMiembroPorId(idMiembro);
        Rutina r = buscarRutinaPorId(idRutina);
        if (m == null) throw new Exception("Error: Miembro no encontrado.");
        if (r == null) throw new Exception("Error: Rutina no encontrada.");
        if (!r.isActiva()) throw new Exception("Error: La rutina está inactiva.");
        m.setRutinaActiva(r);
        return true;
    }

    public boolean desactivarRutinaMiembro(int idMiembro) throws Exception {
        Miembro m = buscarMiembroPorId(idMiembro);
        if (m == null) throw new Exception("Error: Miembro no encontrado.");
        if (m.getRutinaActiva() == null) throw new Exception("Error: El miembro no tiene rutina activa.");
        m.setRutinaActiva(null);
        return true;
    }

    // ---- Consultas ----
    public Rutina rutinaMasPopular() {
        Rutina popular = null;
        int max = 0;
        for (Rutina r : rutinas) {
            int count = 0;
            for (Miembro m : miembros) {
                if (m.getRutinaActiva() == r) count++;
            }
            if (count > max) {
                max = count;
                popular = r;
            }
        }
        return popular;
    }

    public int totalRutinasActivas() {
        int total = 0;
        for (Rutina r : rutinas) {
            if (r.isActiva()) total++;
        }
        return total;
    }

    public Entrenador entrenadorConMasAlumnos() {
        Entrenador top = null;
        int max = 0;
        for (Entrenador e : entrenadores) {
            if (e.contarAlumnos() > max) {
                max = e.contarAlumnos();
                top = e;
            }
        }
        return top;
    }
}