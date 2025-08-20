
package Persona;


public class Persona {
    
     // ATRIBUTOS
      private String dni;
    private String nombres;
    private String apellidos;
    private int edad;
    private int altura;
    private double peso;
    
    //CONSTRUCTOR
     public Persona() {
        this.dni = "";
        this.nombres = "";
        this.apellidos = "";
        this.edad = 0;
        this.altura = 0;
        this.peso = 0.00;
    }
  
    public Persona(String dni, String nombres, String apellidos, int edad, int altura, double peso) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
    }

    //GETEER & SETTER
    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}
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
    
    
    
}
