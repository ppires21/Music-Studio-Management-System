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

public class ListaSessoes {
    
    //ATRIBUTOS
    
    private ArrayList<Sessao> listaSessoes;
    private int sessoesconcluidas;
    
    
    //CONSTRUTOR
        
    public ListaSessoes()
    {
        listaSessoes = new ArrayList<>();
        //idsessao=0;
    }
    
    //MÉTODOS
    
    public void adicionar(Sessao m)
    {
        //m.adicionaIdsessao(idsessao);
        
        listaSessoes.add(m);    
         //++idsessao;
    }
    
    public void remover(Sessao m)
    {
        listaSessoes.remove(m);
    }
    
    public Sessao retornasessaoid(int id){
        
        for(Sessao s : listaSessoes){
            if(s.getIdsessao()==id) return s;
        }   
        return null;
    }
    
    public int getlastid(){
        if(listaSessoes.size()!=0) return listaSessoes.get(listaSessoes.size()-1).getIdsessao();
        else return 0;
    }
    
    public void adicionaInstrumento(int id, Instrumento i){
        for(Sessao s: listaSessoes){
            if(s.getIdsessao()==id) s.adicionaInstrumento(i);
        }
    }
    
    
    public int calcsessoesconcluidas(){     //total de sessões concluidas
        sessoesconcluidas=0;
        for(Sessao s : listaSessoes){
            if(s.getEstado()==true) ++sessoesconcluidas;
        }
        return sessoesconcluidas;
    }
                            //POR FAZER
    public int calcsessoesconcluidasmus(Musico m){     //total de sessões concluidas de um dado músico
        sessoesconcluidas=0;
        for(Sessao s : listaSessoes){
            //if(s.getEstado()==true && s.ge) ++sessoesconcluidas;
        }
        return sessoesconcluidas;
    }
    
    public int calcsessoesporconcluir(){        //total de sessões por concluir
        sessoesconcluidas=0;
        for(Sessao s : listaSessoes){
            if(s.getEstado()==false) ++sessoesconcluidas;
        }
        return sessoesconcluidas;
    }
    
    public int calcsessoesconcluidasprod(Produtor m){     //total de sessões concluidas do produtor
        sessoesconcluidas=0;
        for(Sessao s : listaSessoes){
            if(m.getUserlogin().equals(s.getDonosessao()) && s.getEstado()==true) ++sessoesconcluidas;
        }
        return sessoesconcluidas;
    } 
    
    public int calcsessoesporconcluirprod(Produtor m){     //total de sessões concluidas do produtor
        int sessoesporconcluir=0;
        for(Sessao s : listaSessoes){
            if(m.getUserlogin().equals(s.getDonosessao()) && s.getEstado()==false) ++sessoesporconcluir;
        }
        return sessoesporconcluir;
    } 
    
    public int calcsessoesconcluidasmes(int ano, int mes){     //total de sessões concluidas
        sessoesconcluidas=0;
        for(Sessao s : listaSessoes){
            if(s.getEstado()==true && (s.getDatasessao().getDayOfMonth()==mes) && (s.getDatasessao().getDayOfYear())==ano) ++sessoesconcluidas;
        }
        return sessoesconcluidas;
    }
    
    public int calcsessoesporconcluirmes(int ano, int mes){        //total de sessões por concluir
        sessoesconcluidas=0;
        for(Sessao s : listaSessoes){
            if((s.getEstado()==false) && (s.getDatasessao().getDayOfMonth()==mes) && (s.getDatasessao().getDayOfYear())==ano) ++sessoesconcluidas;
        }
        return sessoesconcluidas;
    }
    
    
    public double calcpersessoesconcluidas(){       //% de sessões concluidas
        return (calcsessoesconcluidas()/listaSessoes.size())*100;
    }
    
    public void concluirsessao(Sessao s){
        s.setEstado(true);
    }
    
    public void alterarestado(Sessao s, boolean estado){
        s.setEstado(estado);
    }
       
    public void clear(){
        listaSessoes.clear();
        //idsessao=0;
    }
    
    public String listartodasassessoesadmin(){       
        String ret = "";
        
        for(Sessao s : listaSessoes){
            ret+=s.toString();
            ret+="\n";
        }
        if(ret=="") ret="Ainda não tem sessões";
        return ret;      
    }
    
    public String listarSessoesprod(Produtor p){

        String ret = "";
        
        for(Sessao s : listaSessoes){
        if(s.getuserDonoSessao().equals(p.getUserlogin())) {
                ret+=s.toString();
                ret+="\n";
            }
        } 
        if(ret=="") ret="Ainda não tem sessões associadas";
        return ret;
    }
    
    public String listarSessoespconcluirprod(Produtor p){
        String ret = "";
        
        for(Sessao s : listaSessoes){
            if(s.getuserDonoSessao().equals(p.getUserlogin()) && s.getEstado()==false) {
                ret+=s.toString();
                ret+="\n";
            }
        }       
        if(ret=="") ret="Não tem sessões por concluir";
        return ret;
    }
    
    public String listarsessoesparadia(LocalDate d){
        String ret = "";
        
        for(Sessao s : listaSessoes){
            if(s.getDatasessao().equals(d)) {
                ret+=s.toString();
                ret+="\n";
            }
        }
        if(ret=="") ret="Ainda não tem sessões a data inserida";
        return ret;
    }

    public Sessao getUltimaSessao(){
        return listaSessoes.get(listaSessoes.size() - 1);
    }    
    
    public void adicionarMusicoSessaopId(int id, Musico m){
        for(Sessao s : listaSessoes){
            if(s.getIdsessao()==id) s.adicionamusico(m);
        }
    }
  
    
    //-----------------------------------------------CÓDIGO REFERENTE A FICHEIROS--------------------------------------------
    
    public void gravarSessoes(String fich) throws IOException
    {
    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream(fich)));
      out.writeObject(listaSessoes);
      out.close();
    }
    catch(Exception e)
     {
        e.printStackTrace();
     }
}
     
     
     //Ler
     public void lerSessoes(String fich) throws IOException, ClassNotFoundException
    {
       ObjectInputStream in = null;
    try{
        in = new ObjectInputStream(new BufferedInputStream (new FileInputStream(fich))); 
        listaSessoes=(ArrayList <Sessao>) in.readObject();
        in.close();
    }
    catch(IOException e)
        {
        }
     
    }
     
}   //pertence à class


