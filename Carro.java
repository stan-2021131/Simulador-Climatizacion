
import java.util.List;

public class Carro implements Climatizacion{
    boolean encendido = false;
    int temperaturaVentilacion = 22; // temperatura por defecto en grados Celsius
    int temperaturaAsientos = 1; // nivel de 1 a 3
    short nivelVentilacion = 1; // nivel de ventilación de 1 a 3
    short nivelVentilacionAsiento = 1; // nivel de 1 a 3
    String ventilacionDireccional = "Frontal"; // flujo inicial
    boolean ecoVentilacion = false;
    boolean desempanador = false;

    public boolean getEncendido(){
        return encendido;
    }public int getTemperaturaVentilacion(){
        return temperaturaVentilacion;
    }public int getTemperaturaAsientos(){
        return temperaturaAsientos;
    }public short getNivelVentilacion(){
        return nivelVentilacion;
    }public short getNivelVentilacionAsiento(){
        return nivelVentilacionAsiento;
    }public String getVentilacionDireccional(){
        return ventilacionDireccional;
    }public boolean getEcoVentilacion(){
        return ecoVentilacion;
    }public boolean getDesempanador(){
        return desempanador;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }public void setTemperaturaVentilacion(int temperaturaVentilacion) {
        this.temperaturaVentilacion = temperaturaVentilacion;
    }public void setTemperaturaAsientos(int temperaturaAsientos) {
        this.temperaturaAsientos = temperaturaAsientos;
    }public void setNivelVentilacion(short nivelVentilacion) {
        this.nivelVentilacion = nivelVentilacion;
    }public void setNivelVentilacionAsiento(short nivelVentilacionAsiento) {
        this.nivelVentilacionAsiento = nivelVentilacionAsiento;
    } public void setVentilacionDireccional(String ventilacionDireccional) {
        this.ventilacionDireccional = ventilacionDireccional;
    }public void setEcoVentilacion(boolean ecoVentilacion) {
        this.ecoVentilacion = ecoVentilacion;
    }public void setDesempanador(boolean desempanador) {
        this.desempanador = desempanador;
    }


    @Override
    public String encendido(boolean estado) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.encendido = estado;
        return encendido ? "Sistema de climatización encendido." : "Sistema de climatización apagado.";
    }

    @Override
    public String ajusteTemperatura(boolean estado) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (!encendido) return "Error: el sistema de climatización está apagado.";
        temperaturaVentilacion += estado ? 1 : -1;
        if (temperaturaVentilacion < 16) temperaturaVentilacion = 16; // mínimo realista
        if (temperaturaVentilacion > 30) temperaturaVentilacion = 30; // máximo realista
        return "Temperatura ajustada a: " + temperaturaVentilacion + "°C.";
    }

    @Override
    public String modoAutomatico(int temperaturaAmbiente) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (!encendido) return "Error: el sistema de climatización está apagado.";
        int diferencia = temperaturaAmbiente - 22; // balance hacia 22°C
        temperaturaVentilacion = Math.max(16, Math.min(30, 22 - diferencia / 2));
        return "Modo automático ajustado. Temperatura equilibrada a: " + temperaturaVentilacion + "°C.";
    }

    @Override
    public String nivelVentilacion(int op, int subOp) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (!encendido) return "Error: el sistema de climatización está apagado.";
        if (op < 1 || op > 3) return "Nivel de ventilación inválido. Seleccione entre 1 y 3.";
        this.nivelVentilacion = (short) op;
        switch (subOp) {
            case 1: ventilacionDireccional = "Parabrisas"; break;
            case 2: ventilacionDireccional = "Frontal"; break;
            case 3: ventilacionDireccional = "Pies"; break;
            default: return "Opción de distribución inválida.";
        }
        return "Nivel de ventilación ajustado a: " + nivelVentilacion + "Distribución de aire ajustada a: " + ventilacionDireccional;
    }

    @Override
    public String modoCalefaccion(int op) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (!encendido) return "Error: el sistema de climatización está apagado.";
        if (op < 1 || op > 3) return "Nivel de calefacción inválido. Seleccione entre 1 y 3.";
        this.temperaturaAsientos = op;
        return "Temperatura de asientos ajustada a nivel: " + op;
    }

    @Override
    public String distribucionAire(int op) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (!encendido) return "Error: el sistema de climatización está apagado.";
        switch (op) {
            case 1: ventilacionDireccional = "Parabrisas"; break;
            case 2: ventilacionDireccional = "Frontal"; break;
            case 3: ventilacionDireccional = "Pies"; break;
            default: return "Opción de distribución inválida.";
        }
        return "Distribución de aire ajustada a: " + ventilacionDireccional;
    }

    @Override
    public String desempanador(boolean estado) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (!encendido) return "Error: el sistema de climatización está apagado.";
        this.desempanador = estado;
        return desempanador ? "Desempañador activado." : "Desempañador desactivado.";
    }

    @Override
    public List<Registro> historialMantenimiento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}