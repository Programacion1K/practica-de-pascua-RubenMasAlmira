public class Heroe {
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
}

