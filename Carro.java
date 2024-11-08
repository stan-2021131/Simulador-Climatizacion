
import java.util.List;

public class Carro implements Climatizacion{
    boolean encendido;
    int temperaturaVentilacion;
    int temperaturaAsientos;
    short nivelVentilacion;
    short nivelVentilacionAsiento;
    String ventilacionDireccional;
    boolean ecoVentilacion;
    boolean desempanador;

    @Override
    public String encendido(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String ajusteTemperatura(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String modoAutomatico(int temperaturaAmbiente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String nivelVentilacion(int op, int subOp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String modoCalefaccion(int op) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String distribucionAire(int op) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String desempanador(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Registro> historialMantenimiento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
