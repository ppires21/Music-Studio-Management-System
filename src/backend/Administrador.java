package backend;

public class Administrador extends Utilizador implements java.io.Serializable{
   
    //construtores
    public Administrador(String userlogin, String palavrapasse, String nomeverdadeiro){
        super(userlogin, palavrapasse, nomeverdadeiro);
    }
}
