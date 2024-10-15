package backend;

import backend.Album;
import backend.Utilizador;
import java.util.ArrayList;

public class Produtor extends Utilizador implements java.io.Serializable{
    
    //ATRIBUTOS
    
    private ArrayList <Album> albunsproduzidos;
    private int nalbunsproduzidos;
    
    //CONSTRUTOR
    public Produtor()
    {
        albunsproduzidos = new ArrayList<>();
    }
    
    
    //MÉTODOS
    
    public void construtorimprovisado(String userlogin, String palavrapasse, String nomeverdadeiro){
        super.setPalavrapasse(palavrapasse);
        super.setNomeverdadeiro(nomeverdadeiro);
        super.setUserlogin(userlogin);
    }

    public ArrayList getAlbunsproduzidos() {
        return albunsproduzidos;
    }

    public void setAlbunsproduzidos(ArrayList albunsproduzidos) {
        this.albunsproduzidos = albunsproduzidos;
    }
    
    public void produziralbum(Album a){
        
        albunsproduzidos.add(a);
    }
    
    public void retiraralbum(Album a){
        albunsproduzidos.remove(a);
    }
    
    public int nalbunsproduzidos(){
        return nalbunsproduzidos;
    }
    
    
}
