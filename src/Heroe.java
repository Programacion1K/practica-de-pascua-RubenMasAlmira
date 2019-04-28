import java.util.ArrayList;
import java.util.List;

public class Heroe {
    String nombre;
    String nombreHeroico;
    TipoDeHeroe tipo;
    double mediaDeLasEstadisticas;
    List<Integer> estadisticas;

    Heroe(String nombreHeroico,String nombre,TipoDeHeroe tipo){
        if(nombreHeroico==null || nombreIncorrecto(nombreHeroico)){

        }
    }

    private static boolean nombreIncorrecto(String nombre){
         boolean nombreCorrecto=true;
         for(char c:nombre){
             if()
         }
    }

}
enum TipoDeHeroe{
    VELOZ(10,4,2),
    DAÑO(4,10,4),
    SOPORTE(2,7,10);

    private int defensa;
    private int velocidad;
    private int fuerza;

    TipoDeHeroe(int velocidad, int fuerza, int defensa){
        this.velocidad=velocidad;
        this.fuerza=fuerza;
        this.defensa=defensa;
    }
}
