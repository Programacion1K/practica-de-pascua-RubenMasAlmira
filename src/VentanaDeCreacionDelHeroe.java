import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDeCreacionDelHeroe extends JFrame {
    private JFrame salida=new JFrame("Nuevo Heroe");
    private JPanel panel=new PanelDeCreacionDeHeroe();
    JButton crear=new JButton("Crear Heroe");
    private Heroe heroeCreado;

    VentanaDeCreacionDelHeroe() {
        salida.setLayout(new BorderLayout());
        salida.setSize(405, 193);
        salida.setResizable(false);
        salida.setLocationRelativeTo(null);
        salida.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        salida.add(panel, BorderLayout.CENTER);
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        salida.add(crear,BorderLayout.SOUTH);
        salida.setVisible(true);
    }

    public Heroe getHeroeCreado() {
        return heroeCreado;
    }
}
