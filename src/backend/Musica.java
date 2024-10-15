package backend;

import java.util.ArrayList;
import java.io.*;

public class Musica extends Album implements java.io.Serializable{
       
    //ATRIBUTOS
    
    private double tempomusica=0;
    private String nomemusica;
    private ArrayList<Musico> donosmusica;  
    private Produtor donomusica;
    private Album associado;
   
    
   // CONSTRUTORES
    
    public Musica()
    {
        donosmusica = new ArrayList<>();
    }

    
   // MÉTODOS

    public void construtorimprovisado(String nomemusica, double tempomusica, Musico donomusica, Album associado){
        this.nomemusica = nomemusica;
        this.tempomusica = tempomusica;
        //this.donomusica = donomusica;
        this.associado=associado;
    }    
    
    public double getTempomusica() {
        return tempomusica;
    }

    public void setTempomusica(double tempomusica) {
        this.tempomusica = tempomusica;
    }

    public String getNomemusica() {
        return nomemusica;
    }

    public void setNomemusica(String nomemusica) {
        this.nomemusica = nomemusica;
    }

    public ArrayList getDonosmusica() {     //retorn um arraylist
        return donosmusica;
    }

    public void setDonosMusica(ArrayList donosmusica){
        this.donosmusica=donosmusica;
    }
     
    public void adicionaDonoMusica(Musico m) {
        donosmusica.add(m);
    }
    
    public String toString(){
        String ret="";
        
        ret="Nome: "+nomemusica+" | Duração: "+tempomusica+" | Album: "+associado.getNomealbum()+" | Artistas: "+nomesartistas();
        
        return ret;
    }
    
    public Album getAssociado(){
        return associado;
    }
    
    public boolean getseDonosmusica(Musico m){
        for(Musico mm : donosmusica){
            if(mm.getUserlogin().equals(m.getUserlogin())) return true;
        }
        return false;
    }
    
    public String nomesartistas(){
        String ret="";
        
        for(Musico m : donosmusica){
            ret+=m.getNomeverdadeiro()+", ";
        }
        return ret;
    }  
}
