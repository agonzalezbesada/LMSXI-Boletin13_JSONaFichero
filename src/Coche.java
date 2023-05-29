public class Coche {

    public String matricula;

    public String marca;

    public Coche() {

    }

    public Coche(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    public void funcionado() {
        System.out.println("Funció "+marca);
    }
}
