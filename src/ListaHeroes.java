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
            List<String> cadenaDelHeroeEnCreacion=new ArrayList<>();

            String nombreDelHeroeEnCreacion;
            String nombreHeroicoDelHeroeEnCreacion;
            double nvlDePoderDelHeroeEnCreacion;
            do{
                cadenaDelHeroeEnCreacion.add(leido.get(1));
                cadenaDelHeroeEnCreacion.add(leido.get(2));
                cadenaDelHeroeEnCreacion.add(leido.get(3));
                leido.remove(1);
                leido.remove(2);
                leido.remove(3);

                nombreDelHeroeEnCreacion = cadenaDelHeroeEnCreacion.get(1);
                nombreHeroicoDelHeroeEnCreacion = cadenaDelHeroeEnCreacion.get(2).substring(cadenaDelHeroeEnCreacion.get(2).indexOf(':'));
                nvlDePoderDelHeroeEnCreacion = Double.parseDouble(cadenaDelHeroeEnCreacion.get(3).substring(cadenaDelHeroeEnCreacion.get(3).indexOf(':')));

                lista.add(new Heroe(nombreDelHeroeEnCreacion,nombreHeroicoDelHeroeEnCreacion,nvlDePoderDelHeroeEnCreacion));


            }while(!leido.isEmpty());


        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null,"No se ha podido leer el fichero correctamente","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void guardaEnFichero(File fichero) {
        try (PrintWriter salida = new PrintWriter(fichero)) {
            for (Heroe h:lista) {
                salida.print(h.info()+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void pideYAnyade() {
        JFrame salida=new JFrame("Nuevo Heroe");
        JPanel panel=new PanelDeCreacionDeHeroe();
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
                    String nombre = ((PanelDeCreacionDeHeroe) panel).getNombre().getText();
                    String nombreHeroico = ((PanelDeCreacionDeHeroe) panel).getNombreHeroico().getText();
                    double nivelDePoder = Double.parseDouble(((PanelDeCreacionDeHeroe) panel).getNivelDePoder().getText());
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
