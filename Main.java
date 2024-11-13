import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
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

                    break;

                case 8:

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
}