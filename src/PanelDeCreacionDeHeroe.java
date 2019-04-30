import javax.swing.*;
import java.awt.*;

public class PanelDeCreacionDeHeroe extends JPanel {


    private JLabel nombre= new JLabel("Nombre");
    private JTextField nombreIntroducido=new JTextField();

    private JLabel nombreHeroico= new JLabel("Nombre del Heroe");
    private JTextField nombreHeroicoIntroducido=new JTextField();

    private JLabel nivelDePoder= new JLabel("Nivel de poder");
    private JTextField nivelDePoderIntroducido=new JTextField();



    PanelDeCreacionDeHeroe(){
        setLayout(new GridLayout(3,3));
        add(nombre);
        add(nombreIntroducido);
        add(nombreHeroico);
        add(nombreHeroicoIntroducido);
        add(nivelDePoder);
        add(nivelDePoderIntroducido);
    }
    public JTextField getNombre(){
        return nombreIntroducido;
    }

    public JTextField getNombreHeroico(){
        return nombreHeroicoIntroducido;
    }

    public JTextField getNivelDePoder(){
        return nivelDePoderIntroducido;
    }
}