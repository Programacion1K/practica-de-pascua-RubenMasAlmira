import java.io.File;
import java.util.Objects;

public class Heroe implements Utilizable{
    private final String nombre;
    private final String nombreHeroico;
    //El nivel de poder se corresponde a un número superior a 0 y inferior a 100
    private double nivelDePoder;
    Heroe(String nombreHeroico,String nombre,double nivelDePoder){
        if(nombreHeroico==null || nombreIncorrecto(nombreHeroico)){
            throw new IllegalArgumentException("El nombre introducido para el heroe es incorrecto");
        }else{
            this.nombreHeroico=nombreHeroico;
        }

        if(nombre==null || nombreIncorrecto(nombre)){
            throw new IllegalArgumentException("El nombre introducido es incorrecto");
        }else{
            this.nombre=nombre;
        }

        if(nivelDePoder<0 || nivelDePoder>100){
            throw new IllegalArgumentException("El nivel de poder indicado para el heroe es incorrecto");
        }else{
            this.nivelDePoder=nivelDePoder;
        }
    }
    private static boolean nombreIncorrecto(String nombre){
         boolean nombreCorrecto=true;
         try {
             for (char c : nombre.toCharArray()) {
                 Integer.parseInt(c+"");
             }
         }catch (NumberFormatException nfe){
             nombreCorrecto=false;
         }
         return nombreCorrecto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreHeroico() {
        return nombreHeroico;
    }

    public double getNivelDePoder() {
        return nivelDePoder;
    }

    public void setNivelDePoder(double nivelDePoder) {
        this.nivelDePoder = nivelDePoder;
    }

    @Override
    public String toString() {
        return nombre+"{"+nombreHeroico+"-"+nivelDePoder+"}";
    }

    public String info() {

        return nombre+"{\nAlias:"+nombreHeroico+"\n Nvl poder:"+nivelDePoder+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heroe)) return false;
        Heroe heroe = (Heroe) o;
        return Objects.equals(nombre, heroe.nombre) &&
                Objects.equals(nombreHeroico, heroe.nombreHeroico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nombreHeroico);
    }

    @Override
    public String muestraTodos() {
        return null;
    }

    @Override
    public void leeDeFichero(File fichero) {

    }

    @Override
    public void guardaEnFichero(File fichero) {

    }

    @Override
    public void pideYAnyade() {

    }
}

