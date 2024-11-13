import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main{
    public static void main(String[] args) {
        List<Registro> registros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        Carro carro =new Carro();
        while (continuar) {
            if (!carro.getEncendido()) {
                System.out.println("La climatizacion esta apagada\nDesea encenderla (SI/NO)");
                String opencender =scanner.nextLine();
                if (opencender.equals("SI")) {
                    System.out.println(carro.encendido(true));
                }else if (opencender.equals("NO")) {
                    System.out.println("Saliendo del programa");
                    continuar = false;
                    return;
                }else{System.out.println("Ingrese una opcion valida");
                return;}
            }
            System.out.println();
            System.out.println("-----CARRO ACTUALMENTE-----");
            System.out.println("-Temperatura: "+ carro.getTemperaturaVentilacion()+ "°C\n-Calefaccion de Asientos: nivel "+ carro.getTemperaturaAsientos());
            System.out.println("-Ventilacion: nivel "+ carro.getNivelVentilacion()+" con direccion "+ carro.getVentilacionDireccional()+ "la ecoVentilacion esta "+ carro.getEcoVentilacion());
            System.out.println("Desempañador: "+ carro.getDesempanador());
            System.out.println();
            System.out.println("-----MANTENIMIENTO-----");
            System.out.println(recordatorio(registros));
            System.out.println("Configuracion de Climatizacion");
            System.out.println("1) Apagar climatizacion\n2) Temperatura\n3) Modo Automatico\n4) Ventilacion\n5) Calefaccion\n6) Desempañador\n7) Programar mantenimiento\n8) Historial de mantenimiento\n9) Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println(carro.encendido(false));
                    break;
                case 2:/*Temperatura, subir y bajar */
                    System.out.println("---Temperatura---");
                    System.out.println("1) Subir temperatura(+1°C)\n2) Bajar temperatura(-1°C) ");
                    int optemp =scanner.nextInt();
                    scanner.nextLine();
                    switch (optemp) {
                        case 1:
                            System.out.println(carro.ajusteTemperatura(true));
                            break;
                        case 2:
                            System.out.println(carro.ajusteTemperatura(false));
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Activando modo Automatico de ventilacion, ingrese la temperatura externa");
                    int tempexterna = scanner.nextInt();
                    System.out.println(carro.modoAutomatico(tempexterna));

                    break;
                case 4:

                    break;
                case 5:/*Calefaccion */
                    System.out.println("---Calefaccion de Asientos---");
                    System.out.println("Ingrese el nivel de calefaccion que desea (1 a 3)");
                    int opcalefaccion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(carro.modoCalefaccion(opcalefaccion));
                    break;
                case 6:/*Desempañador */
                    System.out.println("Desea\n1) Encender desempañador\n2) Apagar desempañador");
                    int opdesemp = scanner.nextInt();
                    scanner.nextLine();
                    switch (opdesemp) {
                        case 1:
                            System.out.println(carro.desempanador(true));
                            break;
                        case 2:
                            System.out.println(carro.desempanador(true));
                            break;
                        default:
                            System.out.println("Ingrese una opcion valida");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Ingrese la fecha de mantenimiento: (dd/MM/yyyy)");
                    String f = scanner.nextLine();
                    System.out.println("Ingrese el cambio por hacer");
                    String c = scanner.nextLine();
                    System.out.println(programarRegistro(f, c, registros));        
                    break;
                case 8:
                    System.out.println("-----HISTORIAL DE MANTENIMIENTOS-----");
                    for(Registro r: registros){
                        System.out.println(carro.historialMantenimiento(r));
                    }
                    break;
                case 9:
                    System.out.println("Saliendo del programa");
                    continuar = false;
                    return;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
        scanner.close();
    }

    public static String programarRegistro(String fecha, String cambio, List<Registro> registros){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        long dias = 7;
        try {
            Date newFecha = dateFormat.parse(fecha);
            Registro newRegistro = new Registro(cambio, newFecha);
            for( Registro r : registros){
                long difMil = Math.abs(newFecha.getTime() - r.getFechaCambio().getTime());
                long difD = TimeUnit.DAYS.convert(difMil, TimeUnit.MILLISECONDS);
                if(difD <= dias)
                    return "No se puede agregar este registro ya que hay uno para los próximos días.";
            }
            registros.add(newRegistro);
            return "Registro agregado exitosamente.";
        } catch (ParseException e) {
            System.out.println("Ha ocurrido un problema al agregar la fecha. Revise si fue ingresada en el formato indicado.");
        }
        return "Ha ocurrido un error al agregar el registro";
    }


    public static String recordatorio(List<Registro> registros){
        Date date = new Date();
        Registro prox = null;
        long minDias = Long.MAX_VALUE;
        for(Registro r : registros){
            Date fecha = r.getFechaCambio();
            long difMil = fecha.getTime() - date.getTime();
            if(difMil > 0){
                long difDias = TimeUnit.DAYS.convert(difMil, TimeUnit.MILLISECONDS);
                if(difDias < minDias){
                    minDias = difDias - 1;
                    prox = r;
                }
            }
        }
        if(prox != null){
            return "El proximo mantenimiento será dentro de " + minDias + " días.\nEl mantienimiento consiste en " + prox.getCambio();
        }
        else {
            return "No hay mantenimientos próximos.";
        }
    }
}