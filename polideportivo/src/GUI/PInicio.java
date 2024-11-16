package GUI;

import data.CaminoCorto;
import data.Grafo;
import data.Nodo;
//import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class PInicio extends javax.swing.JPanel {

    Grafo g;

    public PInicio(Grafo grafo) {
        this.g = grafo;
        minitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /* 
    private void initComponents() {

        jPanelConOpciones = new javax.swing.JPanel();
        jComboOrigen = new javax.swing.JComboBox<>();
        jComboDestino = new javax.swing.JComboBox<>();
        jBEncontrar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelConOpciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 100, 20, 100));
        jPanelConOpciones.setLayout(new java.awt.GridLayout(1, 3));

        jPanelConOpciones.add(jComboOrigen);

        jPanelConOpciones.add(jComboDestino);

        jBEncontrar.setText("Buscar");
        jBEncontrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEncontrarActionPerformed(evt);
            }
        });
        jPanelConOpciones.add(jBEncontrar);

        add(jPanelConOpciones, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    */
    private void jBEncontrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEncontrarActionPerformed

        int origen = jComboOrigen.getSelectedIndex();
        int destino = jComboDestino.getSelectedIndex();
        
         JOptionPane.showMessageDialog(null, CaminoCorto.encontrarCaminoMinimo(g, origen, destino));
        
    }//GEN-LAST:event_jBEncontrarActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imagen = new ImageIcon(".//res/GrafoGimnasio.jpg");
        g.drawImage(imagen.getImage(), 0, 0, imagen.getImage().getWidth(null), imagen.getImage().getHeight(null)+45, null);
       // g.drawImage(imagen.getImage(), 0, 0, null);
        this.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEncontrar;
    private javax.swing.JComboBox<String> jComboDestino;
    private javax.swing.JComboBox<String> jComboOrigen;
    private javax.swing.JPanel jPanelConOpciones;
    // End of variables declaration//GEN-END:variables

    private void minitComponents() {
        jPanelConOpciones = new javax.swing.JPanel();
        jComboOrigen = new javax.swing.JComboBox<>();
        jComboDestino = new javax.swing.JComboBox<>();
        jBEncontrar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelConOpciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 100, 20, 100));
        jPanelConOpciones.setLayout(new java.awt.GridLayout(1, 3));

        jPanelConOpciones.add(jComboOrigen);

        jPanelConOpciones.add(jComboDestino);

        jBEncontrar.setText("Buscar");
        jBEncontrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEncontrarActionPerformed(evt);
            }
        });
        jPanelConOpciones.add(jBEncontrar);

        add(jPanelConOpciones, java.awt.BorderLayout.PAGE_END);
        
        //Nuestras modificaciones:
        
        List<Nodo> salas = g.getHabitaciones();
        
        for (Nodo sala : salas) {
            jComboOrigen.addItem(sala.getNombre());
            jComboDestino.addItem(sala.getNombre());
        }
        
        
        
        
    }
}
