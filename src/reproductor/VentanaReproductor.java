
package reproductor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;




public class VentanaReproductor extends javax.swing.JFrame {
    PlaySong play; 
    float vol;
    int i=0,iAle2=0;
    long pos=0;
    String listaA="";
    FondoB fondoB= new FondoB();
    int aleN[];
    DefaultListModel cancion = new DefaultListModel();
    public VentanaReproductor() {
        initComponents();
        listSongs.setModel(cancion);
        play = new PlaySong(songsName,repeatB,randomB,listSongs);
        aleN=new int[play.archivo.listFiles().length];
        for(int j=0; j<aleN.length; j++){
            cancion.addElement(play.archivo.listFiles()[j].getName().substring(0, play.archivo.listFiles()[j].getName().length()-4));
            boolean comp=true;
            aleN[j]=(int)(Math.random()*aleN.length);
            do{
                comp=true;
                for(int z=j-1; z>=0; z--){
                    if(aleN[j]==aleN[z]){
                        comp=false;
                        aleN[j]++;
                        if(aleN[j]>aleN.length-1)aleN[j]=0;
                    }
                    if(comp==false)break;
                }
            }while(!comp);
            listaA=listaA+" "+String.valueOf(aleN[j]);
        }
        listaA=listaA+" ";
        play.setAle(listaA);
        this.setLocationRelativeTo(null);
        play.sig();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new FondoB();
        nextSongB = new javax.swing.JButton();
        prevSongB = new javax.swing.JButton();
        stopB = new javax.swing.JButton();
        randomB = new javax.swing.JToggleButton();
        repeatB = new javax.swing.JToggleButton();
        playB = new javax.swing.JToggleButton();
        volumS = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        silenciarVolB = new javax.swing.JToggleButton();
        songsName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSongs = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBotones.setBackground(new java.awt.Color(0, 153, 153));

        nextSongB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancionAdelante.png"))); // NOI18N
        nextSongB.setBorder(null);
        nextSongB.setBorderPainted(false);
        nextSongB.setContentAreaFilled(false);
        nextSongB.setFocusPainted(false);
        nextSongB.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancionAdelanteP.png"))); // NOI18N
        nextSongB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextSongBActionPerformed(evt);
            }
        });

        prevSongB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancionAtras.png"))); // NOI18N
        prevSongB.setBorder(null);
        prevSongB.setBorderPainted(false);
        prevSongB.setContentAreaFilled(false);
        prevSongB.setFocusPainted(false);
        prevSongB.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancionAtrasP.png"))); // NOI18N
        prevSongB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevSongBActionPerformed(evt);
            }
        });

        stopB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/stop.png"))); // NOI18N
        stopB.setBorder(null);
        stopB.setBorderPainted(false);
        stopB.setContentAreaFilled(false);
        stopB.setFocusPainted(false);
        stopB.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/stopP.png"))); // NOI18N
        stopB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBActionPerformed(evt);
            }
        });

        randomB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/AleatorioP.png"))); // NOI18N
        randomB.setBorder(null);
        randomB.setBorderPainted(false);
        randomB.setContentAreaFilled(false);
        randomB.setFocusPainted(false);
        randomB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomBActionPerformed(evt);
            }
        });

        repeatB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/repeatP.png"))); // NOI18N
        repeatB.setBorder(null);
        repeatB.setBorderPainted(false);
        repeatB.setContentAreaFilled(false);
        repeatB.setFocusPainted(false);
        repeatB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatBActionPerformed(evt);
            }
        });

        playB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/playBut.png"))); // NOI18N
        playB.setBorder(null);
        playB.setBorderPainted(false);
        playB.setContentAreaFilled(false);
        playB.setFocusPainted(false);
        playB.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pausaBut.png"))); // NOI18N
        playB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBActionPerformed(evt);
            }
        });

        volumS.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumSStateChanged(evt);
            }
        });

        silenciarVolB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/volumen.png"))); // NOI18N
        silenciarVolB.setBorder(null);
        silenciarVolB.setBorderPainted(false);
        silenciarVolB.setContentAreaFilled(false);
        silenciarVolB.setFocusPainted(false);
        silenciarVolB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silenciarVolBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(repeatB)
                .addGap(18, 18, 18)
                .addComponent(stopB)
                .addGap(18, 18, 18)
                .addComponent(prevSongB)
                .addGap(18, 18, 18)
                .addComponent(playB)
                .addGap(18, 18, 18)
                .addComponent(nextSongB)
                .addGap(18, 18, 18)
                .addComponent(randomB)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(volumS, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(silenciarVolB)
                            .addComponent(jLabel1))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(repeatB)
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prevSongB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(randomB)
                                .addComponent(nextSongB))))
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addComponent(silenciarVolB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volumS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        songsName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        songsName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        listSongs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        listSongs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSongsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSongs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(songsName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(songsName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void playBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBActionPerformed

        if (playB.isSelected()) {
            i=listSongs.getSelectedIndex();
            play.volVal=vol;
            play.setI(i);
            play.setiAle(iAle2);
            play.setPos(pos);
            play.start();
            playB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pausaBut.png")));
        } 
        else {
            iAle2=play.getiAle();
            i=play.getI();
            pos=play.getPos();
            play.pausa();
            vol=play.volVal;
            play= new PlaySong(songsName,repeatB,randomB,listSongs);
            play.setAle(listaA);
            playB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/playBut.png")));
        }
            
    }//GEN-LAST:event_playBActionPerformed

    private void prevSongBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevSongBActionPerformed
        if(playB.isSelected()){
            if(listSongs.getSelectedIndex()==-1&&randomB.isSelected())listSongs.setSelectedIndex(aleN[0]);
            i=play.getI();
            iAle2=play.getiAle();
            play.pausa();
            vol=play.volVal;
            play=new PlaySong(songsName,repeatB,randomB,listSongs);
            play.setAle(listaA);
            i--;
            iAle2--;
            if(iAle2<0)iAle2=0;
            if(i<0&&!repeatB.isSelected())i=0;
            if(i<0&&repeatB.isSelected())i=play.archivo.listFiles().length-1;
            if(randomB.isSelected())
                listSongs.setSelectedIndex(aleN[i]);
            else
                listSongs.setSelectedIndex(i);
            play.setI(i);
            play.setiAle(iAle2);
            pos=0;
            play.volVal=vol;
            play.start();
        }
        else{
            vol=play.volVal;
            iAle2=play.getiAle();
            play=new PlaySong(songsName,repeatB,randomB,listSongs);
            play.setAle(listaA);
            i--;
            iAle2--;
            if(i<0&&!repeatB.isSelected())i=0;
            if(i<0&&repeatB.isSelected())i=play.archivo.listFiles().length-1;
            if(randomB.isSelected())
                listSongs.setSelectedIndex(aleN[i]);
            else
                listSongs.setSelectedIndex(i);
            play.setiAle(iAle2);
            play.setI(i);
            pos=0;
            play.sig();
        }
    }//GEN-LAST:event_prevSongBActionPerformed

    private void repeatBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeatBActionPerformed
        if(repeatB.isSelected()){
            repeatB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/repeat.png")));
        }
        else{
            repeatB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/repeatP.png")));
        }
    }//GEN-LAST:event_repeatBActionPerformed

    private void randomBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomBActionPerformed
        if(randomB.isSelected()){
            randomB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Aleatorio.png")));
        }
        else{
            randomB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/AleatorioP.png")));
        }
    }//GEN-LAST:event_randomBActionPerformed

    private void nextSongBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextSongBActionPerformed

        if(playB.isSelected()){
            i=play.getI();
            iAle2=play.getiAle();
            play.pausa();
            vol=play.volVal;
            play=new PlaySong(songsName,repeatB,randomB,listSongs);
            play.setAle(listaA);
            i++;
            iAle2++;
            if(iAle2>=play.archivo.listFiles().length&&repeatB.isSelected())
                iAle2=0;
            if(iAle2>=play.archivo.listFiles().length&&!repeatB.isSelected()){
                JOptionPane.showMessageDialog(null,"Fin de la playlist");
                iAle2=play.archivo.listFiles().length-1;
            }
            if(iAle2<play.archivo.listFiles().length&&i>=play.archivo.listFiles().length)
                i=0;
            if(i>=play.archivo.listFiles().length&&repeatB.isSelected())
                i=0;
            if(i>=play.archivo.listFiles().length&&!repeatB.isSelected()){
                JOptionPane.showMessageDialog(null,"Fin de la playlist");
                i=play.archivo.listFiles().length-1;
            }
            
            if(randomB.isSelected())
                listSongs.setSelectedIndex(aleN[i]);
            else
                listSongs.setSelectedIndex(i);
            play.setiAle(iAle2);
            play.setI(i);
            play.volVal=vol;
            play.start();
        }
        else{
            vol=play.volVal;
            iAle2=play.getiAle();
            play=new PlaySong(songsName,repeatB,randomB,listSongs);
            play.setAle(listaA);
            i++;
            iAle2++;
            if(iAle2<play.archivo.listFiles().length&&i>=play.archivo.listFiles().length)
                i=0;
            if(iAle2>=play.archivo.listFiles().length&&repeatB.isSelected())
                iAle2=0;
            if(iAle2>=play.archivo.listFiles().length&&!repeatB.isSelected()){
                System.out.println("Entre");
                JOptionPane.showMessageDialog(null,"Fin de la playlist");
                iAle2=play.archivo.listFiles().length-1;
            }
            if(i>=play.archivo.listFiles().length&&repeatB.isSelected())
                i=0;
            if(i>=play.archivo.listFiles().length&&!repeatB.isSelected()){
                JOptionPane.showMessageDialog(null,"Fin de la playlist");
                i=play.archivo.listFiles().length-1;
            }
            if(randomB.isSelected())
                listSongs.setSelectedIndex(aleN[i]);
            else
                listSongs.setSelectedIndex(i);
            play.setiAle(iAle2);
            play.setI(i);
            play.sig();
        }
            
        
    }//GEN-LAST:event_nextSongBActionPerformed

    private void stopBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBActionPerformed
        if(playB.isSelected())
            play.pausa();  
        play=new PlaySong(songsName,repeatB,randomB,listSongs);
        play.setAle(listaA);
        i=0;
        iAle2=0;
        pos=0;
        play.sig();
        playB.setSelected(false);
        playB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/playBut.png")));
        listSongs.setSelectedIndex(0);
    }//GEN-LAST:event_stopBActionPerformed

    private void silenciarVolBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silenciarVolBActionPerformed
        if(silenciarVolB.isSelected()){
            vol=-70;
            play.volVal=vol;
            if(playB.isSelected())
                play.volumen.setValue(vol);
            
            silenciarVolB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mute.png")));
        }
        else{
            if(playB.isSelected())
                cambioVolumen();
            else{
               float val = ((float)volumS.getValue()/100*26)-20;
               vol=val; 
            }
                
            silenciarVolB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/volumen.png")));
        }
    }//GEN-LAST:event_silenciarVolBActionPerformed

    private void volumSStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumSStateChanged
        if(playB.isSelected())
            cambioVolumen();
        else
           vol = ((float)volumS.getValue()/100*26)-20;
    }//GEN-LAST:event_volumSStateChanged

    private void listSongsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSongsMouseClicked
        if(i!=listSongs.getSelectedIndex()&&playB.isSelected()){
            vol=play.volVal;
            play.pausa();
            i=listSongs.getSelectedIndex();
            iAle2=0;
            play = new PlaySong(songsName,repeatB,randomB,listSongs);
            play.volVal=vol;
            play.setI(i);
            play.start();
        }
        else if(i!=listSongs.getSelectedIndex()){
            pos=0;
            iAle2=0;
            i=listSongs.getSelectedIndex();
        }
            
        
    }//GEN-LAST:event_listSongsMouseClicked

    private void cambioVolumen(){
        float val = ((float)volumS.getValue()/100*26)-20;
        play.volumen.setValue(val);
        play.volVal=val;
        vol=val;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaReproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaReproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaReproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaReproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaReproductor().setVisible(true);
            }
        });
    }
    class FondoB extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics dibuja){
            Dimension tam= getSize();
            ImageIcon img=new ImageIcon(getClass().getResource("/Iconos/fondoBotones.png"));
            dibuja.drawImage(img.getImage(),0,0,tam.width,tam.height,this);
            setOpaque(false);
            super.paint(dibuja);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listSongs;
    private javax.swing.JButton nextSongB;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JToggleButton playB;
    private javax.swing.JButton prevSongB;
    private javax.swing.JToggleButton randomB;
    private javax.swing.JToggleButton repeatB;
    private javax.swing.JToggleButton silenciarVolB;
    private javax.swing.JLabel songsName;
    private javax.swing.JButton stopB;
    private javax.swing.JSlider volumS;
    // End of variables declaration//GEN-END:variables
}
