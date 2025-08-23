package Persona;

public class alimento {
    
    // ATRIBUTOS
    private String nombre;
    private String marca;
    private double carbs;
    private double prot;
    private double cals;
    private double peso;

    
    // CONSTRUCTOR
    public alimento() {
        this.nombre = "";
        this.marca = "";
        this.carbs = 0.00;
        this.prot = 0.00;
        this.cals = 0.00;
        this.peso = 0.00;
    }
    public alimento(String nombre, String marca, double carbs, double prot, double cals, double peso) {
        this.nombre = nombre;
        this.marca = marca;
        this.carbs = carbs;
        this.prot = prot;
        this.cals = cals;
        this.peso = peso;
    }
    
    // GETTER & SETTER
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {this.marca = marca;}
    public double getCarbs() {return carbs;}
    public void setCarbs(double carbs) {this.carbs = carbs;}
    public double getProt() {return prot;}
    public void setProt(double prot) {this.prot = prot;}
    public double getCals() {return cals;}
    public void setCals(double cals) {this.cals = cals;}
    public double getPeso() {return peso;}
    public void setPeso(double peso) {this.peso = peso;}    
    
    //METODOS

    
}