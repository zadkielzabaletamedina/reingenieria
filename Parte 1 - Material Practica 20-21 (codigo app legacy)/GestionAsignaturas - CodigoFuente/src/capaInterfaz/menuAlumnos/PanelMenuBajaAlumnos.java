
package capaInterfaz.menuAlumnos;

import capaInterfaz.JButtonOp;
import capaInterfaz.JDialogOperacionFail;
import capaInterfaz.listados.ListadoAlumno;
import capaInterfaz.menuPrincipal.FrameMenuPrincipal;
import capaInterfaz.menuPrincipal.PanelMenuPrincipal;
import capaLogicaNegocio.Alumno;
import capaLogicaNegocio.GrupoClase;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/** Clase que gestiona el panel de baja de alumnos.
 *
 * @author Confiencial
 */
public class PanelMenuBajaAlumnos extends JPanel implements ActionListener{
    private static final int MENU_PRINCIPAL = 1;
    private static final int MENU_ALUMNOS = 3;
    private static final int  LISTADO_BAJA_ALUMNOS = 321;

    private JTextField campo_dni = new JTextField();
    private JTextField campo_n_mat = new JTextField();


    /** Crea e inicializa un nuevo PanelMenuBajaAlumnos.
     *
     * @param ancho nº de pixels de anchura del panel.
     * @param alto nº de pixels de altura del panel.
     */
    public PanelMenuBajaAlumnos(int ancho,int alto){
        this.setLayout(null);
        this.setBounds(0,0, ancho, alto);

        this.cargarElementos();
    } // fin del constructor

    private void cargarElementos() {
        JLabel ruta = new JLabel("MENU PRINCIPAL>Alumnos>Baja");
        ruta.setBounds(20,20,400,70);

        JLabel introduzca_n_mat = new JLabel("Nº matrícula");
        introduzca_n_mat.setBounds(150,150,200,70);
        Font auxFont = introduzca_n_mat.getFont();
        introduzca_n_mat.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));

        JLabel introduzca_dni = new JLabel("D.N.I.");
        introduzca_dni.setBounds(150,200,200,70);
        auxFont = introduzca_dni.getFont();
        introduzca_dni.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));


        campo_n_mat.setBounds(300,175, 150, 20);
        campo_dni.setBounds(300,225, 150, 20);

        JButtonOp botonSearch = new JButtonOp("Buscar",LISTADO_BAJA_ALUMNOS);
        botonSearch.setBounds(500, 200, 80, 30);
        botonSearch.addActionListener(this);

        ImageIcon img_home = new ImageIcon(getClass().getResource("/capaInterfaz/images/home_icon.jpg"));
        JButtonOp botonHome = new JButtonOp("",
                                            img_home,
                                            MENU_PRINCIPAL);
        botonHome.setBounds(670, 30, 80, 30);
        botonHome.addActionListener(this);

        JButtonOp botonBack = new JButtonOp("Atrás",MENU_ALUMNOS);
        botonBack.setBounds(670, 500, 80, 30);
        botonBack.addActionListener(this);

        this.add(ruta);
        this.add(introduzca_n_mat);
        this.add(introduzca_dni);
        this.add(campo_n_mat);
        this.add(campo_dni);
        this.add(botonSearch); 
        this.add(botonHome);
        this.add(botonBack);
    } // fin del método cargarElementos


    /** Método que captura los eventos del panel baja de alumnos
     *  y ejecuta el código correspondiente a cada evento.
     *
     * @param e evento capturado.
     */
    public void actionPerformed(ActionEvent e) {
        JButtonOp b = (JButtonOp) e.getSource();
        int ancho = FrameMenuPrincipal.ancho;
        int alto = FrameMenuPrincipal.alto;
        switch(b.getNumOperacion()){
            case MENU_PRINCIPAL:
                PanelMenuPrincipal pSubmenuPrincipal = new PanelMenuPrincipal(ancho,alto);
                FrameMenuPrincipal.getFramePrincipal().setContentPane(pSubmenuPrincipal);
                FrameMenuPrincipal.getFramePrincipal().setVisible(true);
                break;
            case MENU_ALUMNOS:
                PanelMenuAlumnos pSubmenuAlumnos = new PanelMenuAlumnos(ancho,alto);
                FrameMenuPrincipal.getFramePrincipal().setContentPane(pSubmenuAlumnos);
                FrameMenuPrincipal.getFramePrincipal().setVisible(true);
                break;
            case LISTADO_BAJA_ALUMNOS:                
                String num_matricula = campo_n_mat.getText();
                String dni = campo_dni.getText();
                GrupoClase grupo = new GrupoClase(null);
                Alumno alumno = new Alumno(num_matricula, dni);

                try {
                    
                    List<ListadoAlumno> resultado = alumno.consultarAlumno(grupo);

                    PanelResultadoBajaAlumnos pResultadoBajaAlumnos = new PanelResultadoBajaAlumnos(ancho,alto);
                    JScrollPane pResultadoBajaAlumnosConScroll = new JScrollPane(pResultadoBajaAlumnos);
                    pResultadoBajaAlumnosConScroll.setHorizontalScrollBar(null);
                    FrameMenuPrincipal.getFramePrincipal().setContentPane(pResultadoBajaAlumnosConScroll);
                    pResultadoBajaAlumnos.mostrarResultados(resultado);
                    FrameMenuPrincipal.getFramePrincipal().setVisible(true);

                } catch (RuntimeException e1) {
                   JDialogOperacionFail jDialogFail = new JDialogOperacionFail(FrameMenuPrincipal.getFramePrincipal(),
                                                                               e1.getMessage(),true);
                   jDialogFail.setVisible(true);
                }
                break;
        }
    } // fin del método actionPerformed

} // fin de la clase PanelMenuBajaAlumnos