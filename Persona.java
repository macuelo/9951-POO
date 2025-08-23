package Persona;
import java.util.ArrayList;
import java.util.Scanner;
public class Persona {

 // ATRIBUTOS
      private int dni;
    private String nombres;
    private String apellidos;
    private int edad;
    private int altura;
    private double peso;
    private String sexo;
    private String actividad;
    
    
    //CONSTRUCTOR
     public Persona() {
        this.dni = 0;
        this.nombres = "";
        this.apellidos = "";
        this.edad = 0;
        this.altura = 0;
        this.peso = 0.00;
        this.sexo = "";
        this.actividad = "";
    }
  
    public Persona(int dni, String nombres, String apellidos, int edad, int altura, double peso, String sexo, String actividad) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.actividad = actividad;
    }

    //GETEER & SETTER
    public int getDni() {return dni;}
    public void setDni(int dni) {this.dni = dni;}
    public String getNombres() {return nombres;}
    public void setNombres(String nombres) {this.nombres = nombres;}
    public String getApellidos() { return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public int getAltura() {return altura;}
    public void setAltura(int altura) {this.altura = altura;}
    public double getPeso() {return peso;}
    public void setPeso(double peso) {this.peso = peso;}
    public String setSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}
    public String getActividad() {return actividad;}
    public void setActividad(String actividad) {this.actividad = actividad;} 

    //METODOS
    
    // MOSTRAR DATOS DEL CLIENTE
    public void mostrarClientes() {
        System.out.println("----- Datos del Cliente -----");
        System.out.println("DNI: " + dni);
        System.out.println("Nombres: " + nombres);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.println("Sexo: " + sexo);
        System.out.println("Actividad: " + actividad);
        System.out.println("-----------------------------");
    }
    //  REGISTRAR CLIENTE  
    public static Persona registrarCliente(Scanner teclado) {
        Persona nuevo = new Persona();
        System.out.print("DNI: ");
        nuevo.setDni(teclado.nextInt());
        teclado.nextLine();

        System.out.print("Nombres: ");
        nuevo.setNombres(teclado.nextLine());

        System.out.print("Apellidos: ");
        nuevo.setApellidos(teclado.nextLine());

        System.out.print("Altura: ");
        nuevo.setAltura(teclado.nextInt());

        System.out.print("Peso: ");
        nuevo.setPeso(teclado.nextDouble());

        System.out.print("Sexo: ");
        nuevo.setSexo(teclado.nextLine());

        System.out.print("Actividad: ");
        nuevo.setActividad(teclado.nextLine());        

        System.out.println("Cliente registrado exitosamente.");
        nuevo.mostrarClientes();
        return nuevo;
    }
    
    
    
    /* 
    calculo gasto energetico basal
      HOMBRES  66+(13.7*peso)+(5*altura)-(6,8*edad)
      MUJERES  655+(9.6*peso)+(1.8*altura)-(4.7*edad)
    
    calculo gasto energitico diario
    case 1 actividad = sedentario 1.2
    case 2 actividad =  ligera actividad 1.375
    case 3 actividad =  moderada 1.5
    case 4 actividad =  alta 1.725
    case 5 actividad =  muy alta 1.9
    multiplicar por GEB
    
    calculo de nutrientes
    carbs = 45%-65%*ged
    proteinas 10%-35%*ged
    grasas = 20-35%ged
    
    
    
    
    */

    
}