package backend;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ListaUtilizadores {
    
    
    //ATRIBUTOS
    
    private ArrayList<Utilizador> listaUtilizadores;
    
    
    //CONSTRUTOR
    
    public ListaUtilizadores()
    {
        listaUtilizadores = new ArrayList<>();
    }
    
    
    //MÉTODOS
    
    public void adicionarUtilizador(Utilizador u){
        listaUtilizadores.add(u);
    }
    
    public void removerUtilizador(Utilizador u){
        listaUtilizadores.remove(u);
    }
    
    public int getnutilizadores(){
        return listaUtilizadores.size();
}
    
    public int getnmusicos(){
        int nmus=0;
        
        for(Utilizador u : listaUtilizadores){
            if(u instanceof Musico) ++nmus;
        }   
        return nmus;
}
    public int getnprodutores(){
        int nprod=0;
        
        for(Utilizador u : listaUtilizadores){
            if(u instanceof Produtor) ++nprod;
        }    
        return nprod;
}
    
    public String listarusers(){
        String ret = "";
        for(Utilizador u : listaUtilizadores)
        {
            ret+=u.toString();
            ret+="\n";
        }
        return ret;
    }     
    
    public String listarusersprod(){
        String ret = "";
        for(Utilizador u : listaUtilizadores)
        {
            if(u instanceof Produtor){
                ret+=u.toString();
                ret+="\n";
            }  
        }
        return ret;
    }
    
    public String listarusersmus(){
        String ret = "";
        for(Utilizador u : listaUtilizadores)
        {
            if(u instanceof Musico){
                ret+=u.toString();
                ret+="\n";
            }  
        }
        if(ret.equals("")) ret=("Ainda sem músicos adicionados");
        return ret;
    }
    
    public boolean verificauser(String userlogin, String palavrapass)
    {
        for(Utilizador u : listaUtilizadores)
        {
            if(u.getUserlogin().equals(userlogin) && u.getPalavrapasse().equals(palavrapass))
            {
                return true;
            }
        } 
        return false;                             
    }
    
    public Utilizador retornauser(String userlogin, String palavrapass)
    {
        
        for(int i=0; i<listaUtilizadores.size(); i++)
        {
            if(listaUtilizadores.get(i).getUserlogin().equals(userlogin) && listaUtilizadores.get(i).getPalavrapasse().equals(palavrapass))
            {
                return listaUtilizadores.get(i);        //o que faz o get?  retorna 
            }
        } 
       // Musico empty = new Musico();  
        return null;
    }
    
    public Utilizador retornauserporuser(String userlogin){
        
        for(Utilizador u: listaUtilizadores)
        {
            if (u.getUserlogin().equals(userlogin))
            {
                return u;        //o que faz o get?  retorna 
            }
        } 
        return null;
    }
    
    public Musico retornamusporuser(String userlogin){
        
        for(Utilizador u : listaUtilizadores)
        {
            if (u.getUserlogin().equals(userlogin) && u instanceof Musico)
            {
                return (Musico) u;        //o que faz o get?  retorna 
            }
        } 
        return null;
    }
    
    public Produtor retornaprodporuser(String userlogin){
        
        for(Utilizador u : listaUtilizadores)
        {
            if (u.getUserlogin().equals(userlogin) && u instanceof Produtor)
            {
                return (Produtor)u;        //o que faz o get?  retorna 
            }
        } 
        return null;
    }
    
    public boolean verificauserporuser(String userlogin)
    {
        for(Utilizador u : listaUtilizadores)
        {
            if(u.getUserlogin().equals(userlogin))
            {
                return true;
            }
        } 
        return false;                             
    }
    
    public void adicionaalbumprod(Produtor p, Album a){
        
        p.produziralbum(a);
    }
    
    public Musico retornamusico(String s){
        for(Utilizador u : listaUtilizadores)
        {
            if(u.getUserlogin().equals(s) && u instanceof Musico)
            {
                return (Musico)u;
            }
        } 
        return null;
    }
    
    
    //--------------------------------------------------------CÓDIGO REFERENTE A FICHEIROS----------------------------------------------------
    
     public void gravarUtilizadores(String fich) throws IOException
    {
    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream(fich)));
      out.writeObject(listaUtilizadores);
      out.close();
    }
    catch(Exception e)
     {
        e.printStackTrace();
     }
}
     
     public void lerUtilizadores(String fich) throws IOException, ClassNotFoundException
    {
       ObjectInputStream in = null;
    try{
        in = new ObjectInputStream(new BufferedInputStream (new FileInputStream(fich))); 
        listaUtilizadores=(ArrayList <Utilizador>) in.readObject();
        in.close();
    }
    catch(IOException e)
        {
        }
    }
}
