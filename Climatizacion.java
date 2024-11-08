
import java.util.List;

public interface Climatizacion {
    public String encendido(boolean estado);
    public String ajusteTemperatura(boolean estado);
    public String modoAutomatico(int temperaturaAmbiente);
    public String nivelVentilacion(int op, int subOp);
    public String modoCalefaccion(int op);
    public String distribucionAire(int op);
    public String desempanador(boolean estado);
    public List<Registro> historialMantenimiento();
}
