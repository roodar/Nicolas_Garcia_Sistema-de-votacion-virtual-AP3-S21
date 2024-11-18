package conectar;

public class UsuarioGlobal {

    private static UsuarioGlobal instancia;
    private String nombre;

    private UsuarioGlobal() {
    }

    public static UsuarioGlobal getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioGlobal();
        }
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
