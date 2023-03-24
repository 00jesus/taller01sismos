import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu () {
        Scanner entrada = new Scanner(System.in);
        int resp = -1;
        double [][] sismos = crearMatriz();          //al llamar al metodo mostrar matriz, se muestran los dias en filas y cada celda en las columnas
        while (resp!=0) {
            textoMenu();
            System.out.print("Ingrese opcion: ");
            resp = entrada.nextInt();

            if (resp == 1) mostrarMatriz(sismos);
            if (resp == 2) llenarMatrizRandom(sismos);
            if (resp == 3) buscarSismoMayorMagnitud(sismos);
            if (resp == 4) contarSismosMayores5(sismos);
            if (resp == 5) enviarSMS(sismos);
            else {
                System.out.println(" ");
            }
            }
        }
    public static void textoMenu () {
        String t = """
                1| Mostrar sismos
                2| Ingresar datos de los sismos
                3| Mostrar sismo de mayor magnitud
                4| Contar sismos mayores o iguales a 5.0
                5| Enviar SMS por sismos mayores a 7.0
                0| Salir""";
        System.out.println(t);
    }
    public static void enviarSMS (double [][] matriz) {
        double aux;
        int contador = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                aux = matriz [i][j];
                if (aux >= 7.0) {
                    System.out.println("ALERTA, sismo mayor a 7.0");
                    contador = contador +1;
                }
            }
        }
        System.out.println("Cantidad de alertas: "+contador);
    }
    public static void contarSismosMayores5 (double [][] matriz ) {
        int contador = 0;
        double aux;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                aux = matriz[i][j];
                if (aux >= 5) {
                    contador = contador +1;
                }
            }
        }
        System.out.println("Han habido "+ contador + " sismos de magnitud mayor a 5");
    }
    public static void buscarSismoMayorMagnitud (double [][] matriz) {
        double mayor = 0;
        double aux;
        int indice = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                aux = matriz[i][j];
                if (aux > mayor) {
                    mayor = aux;
                    indice = i+1;
                }
            }
        }
        System.out.println("El sismo de mayor magnitud fue de: "+mayor+" y fue el dia "+ indice);
    }
    public static double[][] crearMatriz() {
        return new double[7][10];
    }

    public static void llenarMatrizRandom(double[][] matriz) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = (double) (Math.random() * 10);
            }
        }
    }
public static void mostrarMatriz (double [][] matriz) {
    for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.print(matriz[i][j]+", ");
        }
        System.out.println(" ");
    }
}

}