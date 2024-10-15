package backend;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class ListaInstrumentos implements java.io.Serializable{
    
    //ATRIBUTOS
    
    private ArrayList<Instrumento> listaInstrumentos;
    
    //CONSTRUTOR
    
    public ListaInstrumentos()
    {
        listaInstrumentos = new ArrayList<>();
    }
    
    //MÉTODOS
    
    public void adicionar(Instrumento m)
    {
        listaInstrumentos.add(m);
    }
    
    public void remover(Instrumento m)
    {
        listaInstrumentos.remove(m);
    }
    
    public void alterarquantidade(Instrumento x, int qtd){
        x.setQuantidade(qtd);
    }
        
    public ArrayList getListaInstrumentos(){
        return listaInstrumentos;
    }
    
    public String listarInstrumentos(){
        String ret="";
        for(Instrumento i : listaInstrumentos){
            ret+=i.toString();
            ret+="\n";
        }
        if(ret=="") ret="Ainda não tem instrumentos";
        return ret;
    }
    
    public void instrumentoreqaceite(Musico quemrequisitou, String nomeinstrumento)
    {
        getInstrumento(nomeinstrumento).adicionamusicosinstrumento(quemrequisitou);
    }
    
    public boolean encontraInstrumento(String nome)
    {
        for(Instrumento i : listaInstrumentos){
            if(i.getNomeinstrumento().equals(nome)) return true;
        }
        return false;
    }
    
    public Instrumento getInstrumento(String nome){
        for(Instrumento i : listaInstrumentos){
            if(i.getNomeinstrumento().equals(nome)) return i;
        }
        return null;
    }
    
    public void incrementaQuantidade(Instrumento i){
        int novaqt;
        int novadp;
        novaqt=i.getQuantidade()+1;
        novadp=i.getQuantidadedisponivel()+1;
        i.setQuantidade(novaqt);
        i.setQuantidadedisponivel(novadp);
    }
    
    public void decrementaQuantidade(Instrumento i){
        int novaqt;
        int novadp;
        
        if(i.getQuantidade()==1) remover(i);   
        else{
                novaqt=i.getQuantidade()-1;
                i.setQuantidade(novaqt);
                novadp=i.getQuantidadedisponivel()-1;
                i.setQuantidadedisponivel(novadp);
        }       
    }
    
    
 
    //-----------------------------------------------------------CÓDIGO REFETENTE A FICHEIROS---------------------------------------------
    public void gravarInstrumentos(String fich) throws IOException
    {
    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream(fich)));
      out.writeObject(listaInstrumentos);
      out.close();
    }
    catch(Exception e)
     {
        e.printStackTrace();
     }
}
     
     
     //Restaurar
     public void lerInstrumentos(String fich) throws IOException, ClassNotFoundException
    {
       ObjectInputStream in = null;
    try{
        in = new ObjectInputStream(new BufferedInputStream (new FileInputStream(fich))); 
        listaInstrumentos=(ArrayList <Instrumento>) in.readObject();
        in.close();
    }
    catch(IOException e)
        {
        }
     
    }
    
}
