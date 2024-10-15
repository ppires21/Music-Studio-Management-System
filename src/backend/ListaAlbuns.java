package backend;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class ListaAlbuns implements Serializable{

    //ATRIBUTOS
    
    private ArrayList<Album> listaAlbuns;
   
    
    //CONSTRUTOR
    
    public ListaAlbuns()
    {
        listaAlbuns = new ArrayList<>();
    }
    
    
    //MÉTODOS
    
    public void adicionar(Album m)
    {
        m.setEstado(false);
        listaAlbuns.add(m);
    }
     
    public void remover(Album m)
    {
        listaAlbuns.remove(m);
    }
    
    public void clear(){
        listaAlbuns.clear();
    }
    
    public Album get(int i){
        return listaAlbuns.get(i);
    }
    
    public int calcemedicao(){      //Se for boolean alterar
        
    int emedicao=0;        
    for(Album a : listaAlbuns){
        if(a.getEstado() ==false) ++emedicao;
    }
    return emedicao;
}
    
    public int calcemediçaomes(int ano, int mes){
         
      int emedicao=0;        
      for(Album a : listaAlbuns){
          if(a.getDataalbum().getDayOfMonth()==mes && a.getDataalbum().getDayOfYear()==ano){
           if(a.getEstado() ==false) ++emedicao;
          }
    }
    return emedicao;
      
  }
    
    public int calcconcluido(){     //Se for boolean alterar
        int concluido=0;
        for(Album a : listaAlbuns){
        if(a.getEstado() == true) ++concluido;
    }
        return concluido;
}
    
    public int calcconcluidomes(int ano, int mes){     //Se for boolean alterar
        int concluido=0;
        for(Album a : listaAlbuns){
            if(a.getDataalbum().getDayOfMonth()==mes && a.getDataalbum().getDayOfYear()==ano){            
                if(a.getEstado() == true) ++concluido;
            }
    }
        return concluido;
}
      
    public double calcmedpercsessconclmes(int ano, int mes){
        double mediatodososalbuns=0;
        for(Album a: listaAlbuns){
            
            mediatodososalbuns+=a.calcmedsessoesgravacaomes(ano, mes);
        }
        mediatodososalbuns=mediatodososalbuns/listaAlbuns.size();
        return mediatodososalbuns;
    }
    
    public double tempototal(Album alb){
        double ttotal=0;
        for(int i=0; i<alb.getAlbum().size(); i++){            
        }             
        return ttotal;
    }
    
    public Album getAlbum(String nomealbum){
        for(Album a : listaAlbuns){
            if(nomealbum.equals(a.getNomealbum())) return a;
        }
        return null;
    }
    
    public String listarAlbuns(){
        String ret = "";
        
        for(Album a : listaAlbuns){
            ret+=a.toString();
            ret+="\n";
        }
        if(ret=="") ret="Ainda não tem albuns";
        return ret;
    }
    
    public String listarAlbunsprod(Produtor prod){      //listar os albuns de determinado produtor
        String ret = "";
       
        for(Album a : listaAlbuns){
            if(a.getOqueproduziu().getUserlogin().equals(prod.getUserlogin()))
            {
                ret+=a.toString();
                ret+="\n";
            }
        }
        return ret;
    }
    
    public String listarAlbunsemprodprod(Produtor prod){      //listar os albuns de determinado produtor
        String ret = "";
       
        for(Album a : listaAlbuns){
            if(a.getOqueproduziu().getUserlogin().equals(prod.getUserlogin()) && a.getEstado()==false)
            {
                ret+=a.toString();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não tem albuns associados";
        return ret;
    }
    
    public String listarAlbunsprodporiniciar(Produtor prod){      //listar os albuns de determinado produtor
        String ret = "";
       
        for(Album a : listaAlbuns){
            if(a.getOqueproduziu().getUserlogin().equals(prod.getUserlogin()) && a.getNsessoes()==0)
            {
                ret+=a.toString();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não tem albuns por iniciar";
        return ret;
    }
    
    public int numAlbunsprodprod(Produtor p){
        int ret = 0;
        
        for(Album a : listaAlbuns){
            if(a.getOqueproduziu().getUserlogin()==p.getUserlogin() && a.getEstado()==true)
            {
                ++ret;
            }
        }
        return ret;
    }
    
    public void setnSessoesAlbum(Album b, int n){
        b.setNsessoes(n);
    }
    
    public int numAlbunsemprodprod(Produtor p){
        int ret = 0;
        
        for(Album a : listaAlbuns){
            if(a.getOqueproduziu().getUserlogin()==p.getUserlogin() && a.getEstado()==false)
            {
                ++ret;
            }
        }
        return ret;
    }
    
    public String listarAlbunsmus(Musico mus){      //listar os albuns de determinado produtor
        String ret = "";
        
        for(Album a : listaAlbuns){
            if(a.encontraAssociado(mus)==true)
            {
                ret+=a.toString();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não tem albuns associados";
        return ret;
    }
    
    public String listarAlbunsprodpen(Produtor prod){       //listar os albuns pendentes de determinado produtor
        String ret = "";
        
        for(Album a : listaAlbuns){
            if(a.getOqueproduziu().getUserlogin()==prod.getUserlogin() && a.getEstado() ==false)
            {
                ret+=a.toString();
                System.out.println(); 
            }
        }
        if(ret=="") ret="Não tem albuns pendentes";
        return ret;
    }
    
    public void adicionaSessaoAlbum(String nomealbum, Sessao s){
        for(Album a : listaAlbuns){
            if(a.getNomealbum()==nomealbum) a.adicionassessaoAlbum(s);
        }
    }
    
    public int size(){
        return listaAlbuns.size();
    }
    
    public void setEstado(boolean estado, String al){
        getAlbum(al).setEstado(estado);   
    }
    
    public void setTipoalbum(String album, String tipo){
        getAlbum(album).setTipodealbum(tipo);
    }
    
    public ArrayList getsessoesalbum(Album a){
        
        return a.getSessoesgravacao();
        }
    
    public void removesessaoaoalbum(Album a, int id){
        a.removesessaoAlbum(id);
    }
    
    public void setEstadosessaoAlbum(Album a, Sessao ss, boolean estado){
        a.setEstadosessao(ss, estado);
    }
    
    public void setDatasessaoAlbum(Album a, Sessao ss, LocalDate data){
        a.setDatasessao(ss, data);
    }
    
    public void setDescriçãosessaoAlbum(Album a, Sessao ss, String descrição){
        a.setDescriçãosessao(ss, descrição);
    }
 
    public void trocasessao (Album inicio, Album fim, Sessao s){
        fim.adicionassessaoAlbum(s);
        inicio.retirasessaoAlbum(s);
    }
    
    public double calcmedpercessconcluidas(){                //percentagem de sessões concluidas para todos os albuns (média)
       double medpersessconcl=0;
       
       for(Album a : listaAlbuns){
           medpersessconcl+=a.calcpersessconcl();
       }       
       medpersessconcl=medpersessconcl/listaAlbuns.size();
       return medpersessconcl;     
   }
    
    
     
     //--------------------------------------------------------------CÓDIGO REFERENTE A FICHEIROS---------------------------------------------------
     public void gravarAlbuns(String fich) throws IOException
    {
    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream(fich)));
      out.writeObject(listaAlbuns);
      out.close();
    }
    catch(Exception e)
     {
        e.printStackTrace();
     }
}
     
     public void lerAlbuns(String fich) throws IOException, ClassNotFoundException
    {
       ObjectInputStream in = null;
    try{
        in = new ObjectInputStream(new BufferedInputStream (new FileInputStream(fich))); 
        listaAlbuns=(ArrayList <Album>) in.readObject();
        in.close();
    }
    catch(IOException e)
        {
        }
     
    }
     
     
   } //pertence à classe

    
   
    //String fich = lu.retornauser(user, pass).getUserlogin()+"albuns.dat";
        //la.gravarAlbuns(fich); 

