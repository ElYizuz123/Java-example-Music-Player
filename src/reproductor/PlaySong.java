
package reproductor;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;


public class PlaySong extends Thread {
    int i=0;
    long pos;
    float volVal=0;
    private int iAle=0;
    FloatControl volumen;
    javax.swing.JList<String> listSongs;
    javax.swing.JLabel songsName;
    javax.swing.JToggleButton randomB;
    javax.swing.JToggleButton repeatB;
    public File archivo = new File("Example of music directory");
    int ale[]=new int[archivo.listFiles().length];
    Clip clip;
    
    public PlaySong(javax.swing.JLabel songsName, javax.swing.JToggleButton repeatB, javax.swing.JToggleButton randomB, javax.swing.JList<String> listSongs){
        this.songsName=songsName;
        this.repeatB=repeatB;
        this.randomB=randomB;
        this.listSongs=listSongs;
    }
    @Override
    public void run(){
        AudioInputStream rutaAudio = null;
        try {
            if(i<0)i=0;
            if(i>=archivo.listFiles().length&&repeatB.isSelected())
                i=0;
            if(i>=archivo.listFiles().length&&!repeatB.isSelected()){
                JOptionPane.showMessageDialog(null,"Fin de la playlist");
                i=archivo.listFiles().length-1;
            }
            if(randomB.isSelected()){
                for (int j = 0; j < ale.length; j++) {
                    if(ale[j]==listSongs.getSelectedIndex())
                        i=j;
                }
                for(;iAle<ale.length;iAle++,i++){
                    
                    rutaAudio = AudioSystem.getAudioInputStream(archivo.listFiles()[ale[i]]);
                    songsName.setText(archivo.listFiles()[ale[i]].getName().substring(0, archivo.listFiles()[ale[i]].getName().length()-4));
                    clip = AudioSystem.getClip();
                    clip.open(rutaAudio);
                    volumen=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                    volumen.setValue(volVal);
                    clip.setMicrosecondPosition(pos);
                    listSongs.setSelectedIndex(ale[i]);
                    clip.start();
                    Thread.sleep((clip.getMicrosecondLength()-pos)/1000);
                    pos=0;
                    if(i==ale.length-1)
                        i=-1;
                    if(iAle==archivo.listFiles().length-1&&repeatB.isSelected())
                        iAle=-1;
                    if(iAle==archivo.listFiles().length-1&&!repeatB.isSelected()){
                        JOptionPane.showMessageDialog(null,"Fin de la playlist");
                        iAle=archivo.listFiles().length-1;
                    }
                    
                }
            }
            else{
                for( ;i<archivo.listFiles().length; i++)
                {
                    rutaAudio = AudioSystem.getAudioInputStream(archivo.listFiles()[i]);
                    songsName.setText(archivo.listFiles()[i].getName().substring(0, archivo.listFiles()[i].getName().length()-4));
                    clip = AudioSystem.getClip();
                    clip.open(rutaAudio);
                    volumen=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                    volumen.setValue(volVal);
                    clip.setMicrosecondPosition(pos);
                    listSongs.setSelectedIndex(i);
                    clip.start();
                    Thread.sleep((clip.getMicrosecondLength()-pos)/1000);
                    pos=0;
                    if(i==archivo.listFiles().length-1&&repeatB.isSelected())
                        i=-1;
                    if(i==archivo.listFiles().length-1&&!repeatB.isSelected()){
                        JOptionPane.showMessageDialog(null,"Fin de la playlist");
                        i=archivo.listFiles().length-1;
                    }
                }
            }
            
            
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,E.getMessage());
        } 
    }
    public void pausa(){
        i=archivo.listFiles().length+1;
        iAle=archivo.listFiles().length+1;
        try {
            clip.stop();
        } catch (Exception ex) {
            Logger.getLogger(PlaySong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sig(){
        if(i>=archivo.listFiles().length&&repeatB.isSelected())
               i = 0;
        if (i >= archivo.listFiles().length && !repeatB.isSelected()) {
            JOptionPane.showMessageDialog(null, "Fin de la playlist");
            i = archivo.listFiles().length - 1;
        }
        if(randomB.isSelected())
            songsName.setText(archivo.listFiles()[ale[i]].getName().substring(0, archivo.listFiles()[ale[i]].getName().length()-4));
        else
            songsName.setText(archivo.listFiles()[i].getName().substring(0, archivo.listFiles()[i].getName().length()-4));
    }

    public void setAle(String listaA){
        String num="";
        int z=0;
        for(int j=0; j<listaA.length(); j++){
            if(listaA.charAt(j)!=' ')num=num+listaA.charAt(j);
            else{
                if(num!=""){
                    ale[z]=Integer.parseInt(num);
                    num="";
                    z++;
                }
            }
        }
    }

    public int getiAle() {
        return iAle;
    }

    public void setiAle(int iAle) {
        this.iAle = iAle;
    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public long getPos() {
        return clip.getMicrosecondPosition();
    }

    public void setPos(long pos) {
        this.pos = pos;
    }
}
