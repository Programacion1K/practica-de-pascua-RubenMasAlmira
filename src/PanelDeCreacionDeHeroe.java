import javax.swing.*;
import java.awt.*;

public class PanelDeCreacionDeHeroe extends JPanel {


    JLabel nombre= new JLabel("Nombre");
    JTextField nombreIntroducido=new JTextField();

    JLabel nombreHeroico= new JLabel("Nombre del Heroe");
    JTextField nombreHeroicoIntroducido=new JTextField();

    JLabel nivelDePoder= new JLabel("Nivel de poder");
    JTextField nivelDePoderIntroducido=new JTextField();



    PanelDeCreacionDeHeroe(){
        setLayout(new GridLayout(3,3));
        add(nombre);
        add(nombreIntroducido);
        add(nombreHeroico);
        add(nombreHeroicoIntroducido);
        add(nivelDePoder);
        add(nivelDePoderIntroducido);
    }
}