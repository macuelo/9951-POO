package app;
import java.util.ArrayList;
import java.util.Scanner;
import Persona.Persona;
public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Persona> Personas = new ArrayList<>();
        
        int opcionPrincipal;
        do {
            System.out.println("""
                MENÚ PRINCIPAL
                1. Módulo de Clientes
                2. Módulo de Alimentos
                3. 
                4. 
                0. Salir
                """);
            opcionPrincipal = teclado.nextInt();
            teclado.nextLine();

        
        switch (opcionClientes) {
                case 1 -> {
                    int opC;
                    do {
                        System.out.println("""
                            CLIENTES 
                            1. Registrar
                            2. Buscar por DNI
                            3. Modificar datos
                            4. Eliminar
                            0. Volver
                            """);
                        opC = teclado.nextInt();
                        teclado.nextLine();
                        switch (opC) {
                            case 1 -> Personas.add(Persona.registrarCliente(teclado));
                            case
                        
                        
                        }
                                  
                    } while (opcionClientes != 0);  
          }
                
        } 
        }while (opcionPrincipal != 0);        
        
    }
}