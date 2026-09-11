package ni.edu.uam.soporte_tecnico.model;

public class Cliente {

    private String nombre;
    private String correo;
    private String telefono;
    private String tipoCliente;
    private String documento;
    private String directorio;

    public Cliente(String nombre,
            String correo,
            String telefono,
            String tipoCliente,
            String documento,
            String directorio) {

        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
        this.documento = documento;
        this.directorio = directorio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public String getDirectorio() {
        return directorio;
    }
}