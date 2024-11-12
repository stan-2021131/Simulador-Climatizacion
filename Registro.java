
import java.util.Date;

public class Registro {
    String cambio;
    Date fechaCambio;

    public Registro() {
    }

    public Registro(String cambio, Date fechaCambio) {
        this.cambio = cambio;
        this.fechaCambio = fechaCambio;
    }
    public Date getFechaCambio() {
        return fechaCambio;
    }
    public String getCambio() {
        return cambio;
    }
    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
}
