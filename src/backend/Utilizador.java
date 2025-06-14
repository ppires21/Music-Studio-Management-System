package backend;
public abstract class Utilizador implements java.io.Serializable{
    
 
    //ATRIBUTOS 
    
    private String userlogin;
    private String palavrapasse;
    private String nomeverdadeiro;
    
    
    //CONSTRUTORES

    public Utilizador(){
        nomeverdadeiro="Empty name";
        palavrapasse="Empty pass";
        userlogin="Empty username";
    }
    
    public Utilizador(String userlogin, String palavrapasse, String nomeverdadeiro) {
        this.userlogin = userlogin;
        this.palavrapasse = palavrapasse;
        this.nomeverdadeiro = nomeverdadeiro;
    }
    
    
    //MÉTODOS

    public String toString (){
        String ret = "";
        if(this instanceof Administrador)ret="User: "+userlogin+" | Nome: "+nomeverdadeiro+" | Tipo: Administrador";
        else if(this instanceof Produtor) ret="User: "+userlogin+" | Nome: "+nomeverdadeiro+" | Tipo: Produtor";
        else if(this instanceof Musico) ret="User: "+userlogin+" | Nome: "+nomeverdadeiro+" | Tipo: Musico";
        return ret;
    }
    
    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    public String getPalavrapasse() {
        return palavrapasse;
    }

    public void setPalavrapasse(String palavrapasse) {
        this.palavrapasse = palavrapasse;
    }

    public String getNomeverdadeiro() {
        return nomeverdadeiro;
    }

    public void setNomeverdadeiro(String nomeverdadeiro) {
        this.nomeverdadeiro = nomeverdadeiro;
    } 
    
    /*public void AdicionaSessaoaoMusico(Album a){
        for(Musico m : listamusicos)
            if(a.getMusicosassociados().contains((Musico)))
        }
   
    
} }*/
}
