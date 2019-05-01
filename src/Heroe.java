import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Heroe {
    private final String nombre;
    private final String nombreHeroico;
    //El nivel de poder se corresponde a un número superior a 0 y inferior a 100
    private double nivelDePoder;
    Heroe(String nombre,String nombreHeroico,double nivelDePoder){
        if(nombreHeroico==null ){
            throw new IllegalArgumentException("El nombre introducido para el heroe es incorrecto");
        }
        this.nombreHeroico=nombreHeroico;

        if(nombre==null){
            throw new IllegalArgumentException("El nombre introducido es incorrecto");
        }
        this.nombre = nombre.substring(0,1).toUpperCase()+nombre.substring(1).toLowerCase();


        if(nivelDePoder<0 || nivelDePoder>100){
            throw new IllegalArgumentException("El nivel de poder indicado para el heroe es incorrecto.\n(Recuerde que el nivel de poder es un número entero o decimal compendido entre 0 y 100,siendo 0 el más bajo y 100 el más alto.)");
        }
        this.nivelDePoder=nivelDePoder;

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
        return nombre+"\nAlias:"+nombreHeroico+"\nNvl poder:"+nivelDePoder;
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

    public static void main(String[] args) {
        List<String> leido=new ArrayList<>();
        leido.add("1{1m-23.0}");
        String nombreDelHeroeEnCreacion;
        String nombreHeroicoDelHeroeEnCreacion;
        String nvlDePoderDelHeroeEnCreacion;

        nombreDelHeroeEnCreacion=leido.get(0).substring(0,leido.get(0).indexOf('{'));
        nombreHeroicoDelHeroeEnCreacion=leido.get(0).substring(leido.get(0).indexOf('{')+1,leido.get(0).indexOf('-'));
        nvlDePoderDelHeroeEnCreacion=leido.get(0).substring(leido.get(0).indexOf('-')+1,leido.get(0).indexOf('}'));
        System.out.println(nombreDelHeroeEnCreacion);
        System.out.println(nombreHeroicoDelHeroeEnCreacion);
        System.out.println(nvlDePoderDelHeroeEnCreacion);
    }

}

