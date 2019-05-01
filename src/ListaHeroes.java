import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ListaHeroes implements Utilizable{
    private List<Heroe> lista=new ArrayList<>();

    @Override
    public String muestraTodos() {
        String salida="";
        for (Heroe h:lista) {
            salida+=h.info()+"\n";
        }
        return salida;
    }

    @Override
    public void leeDeFichero(File fichero) {
        try {
            List<String> leido= Files.readAllLines(fichero.toPath());

            String nombreDelHeroeEnCreacion;
            String nombreHeroicoDelHeroeEnCreacion;
            double nvlDePoderDelHeroeEnCreacion;
            for (String heroeActual : leido) {
                nombreDelHeroeEnCreacion = heroeActual.substring(0, heroeActual.indexOf('{'));
                nombreHeroicoDelHeroeEnCreacion = heroeActual.substring(heroeActual.indexOf('{') + 1, heroeActual.indexOf('-'));
                nvlDePoderDelHeroeEnCreacion = Double.parseDouble(heroeActual.substring(heroeActual.indexOf('-') + 1, heroeActual.indexOf('}')));
                lista.add(new Heroe(nombreDelHeroeEnCreacion, nombreHeroicoDelHeroeEnCreacion, nvlDePoderDelHeroeEnCreacion));
            }


        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null,"No se ha podido leer el fichero correctamente","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void guardaEnFichero(File fichero) {
        try (PrintWriter salida = new PrintWriter(fichero)) {
            for (Heroe h:lista) {
                salida.print(h.toString()+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void pideYAnyade() {
        JFrame salida=new JFrame("Nuevo Heroe");
        PanelDeCreacionDeHeroe panel=new PanelDeCreacionDeHeroe();
        JButton anyadirALaLista=new JButton("Crear Heroe");


        salida.setLayout(new BorderLayout());
        salida.setSize(405, 193);
        salida.setResizable(false);
        salida.setLocationRelativeTo(null);
        salida.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        salida.add(panel, BorderLayout.CENTER);
        anyadirALaLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre =  panel.getNombre().getText();
                    String nombreHeroico = panel.getNombreHeroico().getText();
                    double nivelDePoder = Double.parseDouble(panel.getNivelDePoder().getText());
                    lista.add(new Heroe(nombre, nombreHeroico, nivelDePoder));
                    salida.dispose();

                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        salida.add(anyadirALaLista,BorderLayout.SOUTH);
        salida.setVisible(true);

    }
}
