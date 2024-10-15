package backend;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ListaMusicas{     
    
    //ATRIBUTOS
    
    private ArrayList<Musica> listaMusicas;
   
    
    //MÉTODOS
    
    public ListaMusicas()
    {
        listaMusicas = new ArrayList<>();
    }
    
    public void adicionar(Musica m)
    {
        listaMusicas.add(m);
    }
    
    public void remover(Musica m)
    {
        listaMusicas.remove(m);
    }
         
    public String listamusicasmus(Musico mus){      //retorna em String as músicas de um determinado músico
        String ret = "";
        for(Musica m : listaMusicas){
            if(m.getseDonosmusica(mus)){
                ret+=m.toString();
                ret+="\n";
            }        
        }
        if(ret=="") ret="Ainda não tem músicas associadas";
        return ret;
    }
    
    public String listartodasasmusicas(){
        String ret = "";
        for(Musica m : listaMusicas){
            ret+=m.toString();
            ret+="\n";             
        }
        if(ret=="") ret="Não tem músicas na editora";
        return ret;
    }   
     
    
    //-----------------------------------------------CÓDIGO REFERENTE A FICHEIROS---------------------------------------------
    
    public void gravarMusicas(String fich) throws IOException
    {
        ObjectOutputStream out = null;
        try {
          out = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream(fich)));
          out.writeObject(listaMusicas);
          out.close();
        }
        catch(Exception e)
         {
            e.printStackTrace();
         }
}
     
     public void lerMusicas(String fich) throws IOException, ClassNotFoundException
    {
       ObjectInputStream in = null;
    try{
        in = new ObjectInputStream(new BufferedInputStream (new FileInputStream(fich))); 
        listaMusicas=(ArrayList <Musica>) in.readObject();
        in.close();
    }
    catch(IOException e)
        {
        }
     
    }
    
}
