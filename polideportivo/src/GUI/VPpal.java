
package GUI;

import data.Grafo;
import data.Main;
import javax.swing.JPanel;


public class VPpal extends javax.swing.JFrame {

    /**
     * Creates new form VPpal
     */
    public VPpal(String titulo) {
        super(titulo);
        initComponents();
       
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
        Grafo g = Main.obtenerGrafo();
        JPanel panelMapa = new PInicio(g);
        
        this.setContentPane(panelMapa);
        this.revalidate();
    }

    
        private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }
}
