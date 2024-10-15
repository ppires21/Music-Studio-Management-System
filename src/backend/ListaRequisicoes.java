package backend;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaRequisicoes{
    
    //ATRIBUTOS
    
    private ArrayList<Requisicao> listaRequisiçoes;
    //private int idrequisiçao;
    
    //CONSTRUTOR
    
    public ListaRequisicoes()
    {
        
        listaRequisiçoes = new ArrayList<>();
        //idrequisiçao=0;
    }
        
    //MÉTODOS
    
    public void adicionar(Requisicao m)
    {
        //m.setIdrequisiçao(getlastid() + 1);        
        listaRequisiçoes.add(m);
        //++idrequisiçao;
    }
      
    public void remover(Requisicao m)
    {
        listaRequisiçoes.remove(m);
    }
    
    public int getnumrequisições(){   
        return listaRequisiçoes.size();
    }
    
    
    
    public Musico getmusRequisiçao(int idd){
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==idd) {
                return r.getMusicoquefez();       
            }
        }
        return null;
    }
    
    public void aceitarRequisiçao(int idd){
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==idd) {
                
                r.aceita();
                
            }
        }
    }
    
    public void recusarRequisiçao(int idd){
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==idd) r.recusa();
        }
    }
    
    public Requisicao getRequisiçao(int idd){
        for(Requisicao r : listaRequisiçoes)
        {
            if(r.getIdrequisiçao()==idd) return r;
        }
        return null;
    }
    
    public String getAlbumreq(int id){
        String ret="";
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==id){
                ret=r.getAlbumreq();
                return ret;           
            }
        }
                return null;
    }
    
    public int getlastid(){
        if(listaRequisiçoes.size()!=0)
            return listaRequisiçoes.get(listaRequisiçoes.size()-1).getIdrequisiçao();
        
        else 
            return 0;
    }
    
    public String getTipo(int id){
        String ret="";
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==id) {
                ret=r.getTipo();
                return ret;
            }
        }
        return null;
    }
    
    public Produtor getProdquefez(int id){
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==id) return r.getProdquefez();
        }
        return null;
    }
    
    public LocalDate getDatarequisição(int id){
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==id) return r.getDatarequisição();
        }
        return null;
    }
    
    
    public String listartodasreq(){
        
        String ret = "";
        for(Requisicao r : listaRequisiçoes){
            ret+=r.toString();
            ret+="\n";
        }
        if(ret=="") ret="Não foram encontradas requisições";
        return ret;
    }
    
    public String listarreqinst(){
        String ret = "";
        for(Requisicao r : listaRequisiçoes){
            if(r.getTiporeq()==true) {
                ret+=r.toStringalbum();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não foram encontradas requisições";
        return ret;
    }
    
    public String listarreqalb(){
        String ret = "";
        for(Requisicao r : listaRequisiçoes){
            if(r.getTiporeq()==false) {
                ret+=r.toStringalbum();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não foram encontradas requisições";
        return ret;    
    }
    
    public String listarreqpendentesinst(){
        String ret = "";
        for(Requisicao r : listaRequisiçoes){
            if(r.getEstado()==0 && r.getTiporeq()==true){
                ret+=r.toStringinstrumento();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não foram encontradas requisições pendentes";
        return ret;
    }
    
    public String listarreqpendentesalb(){
        String ret = "";
        for(Requisicao r : listaRequisiçoes){
            if(r.getEstado()==0 && r.getTiporeq()==false){
                ret+=r.toStringalbum();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não foram encontradas requisições pendentes";
        return ret;
        
    }
    
    public String listarreqaceitesinst(){
        String ret = "";
        for(Requisicao r : listaRequisiçoes){
            if(r.getEstado()==1 && r.getTiporeq()==true){
                ret+=r.toStringinstrumento();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não foram encontradas requisições aceites";
        return ret;
    }
    
    public String verificaseexiste(int id){
        String ret="";
        
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==id) ret="Id existente";
            else ret="Id inexistente";
        }
        return ret;
    }
    
    
    public String listarreqrecusadasinst(){
        String ret = "";
        for(Requisicao r : listaRequisiçoes){
            if(r.getEstado()==-1 && r.getTiporeq()==true){
                ret+=r.toStringinstrumento();
                ret+="\n";
            }
        }
        if(ret=="") ret="Não foram encontradas requisições recusadas";
        return ret;
    }
    
    public String getNomeinstrumento(int id){
        String ret="";
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==id) ret=r.getNomeinstrumento();
        }
        return ret;
    }
    
    
    public String getNomealbum(int id){
        String ret="";
        for(Requisicao r : listaRequisiçoes){
            if(r.getIdrequisiçao()==id) ret=r.getNomeinstrumento();
        }
        return ret;
    }
 
    public void gravarRequisiçoes(String fich) throws IOException
    {
        ObjectOutputStream out = null;
        try {
          out = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream(fich)));
          out.writeObject(listaRequisiçoes);
          out.close();
        }
        catch(Exception e)
         {
            e.printStackTrace();
         }
}
     
     
     //Ler
     public void lerRequisiçoes(String fich) throws IOException, ClassNotFoundException
    {
       ObjectInputStream in = null;
       try{
        in = new ObjectInputStream(new BufferedInputStream (new FileInputStream(fich))); 
        listaRequisiçoes=(ArrayList <Requisicao>) in.readObject();
        in.close();
       }
        catch(IOException e){}
     
    }
}
