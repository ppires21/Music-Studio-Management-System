package backend;

import java.util.Date;
import java.util.ArrayList;

public class Musico extends Utilizador implements java.io.Serializable{
    
    
    // ATRIBUTOS
    
    private Date datanascimento;
    private String morada;
    private double nbilheteidentidade;
    private ArrayList <Album> albunsassociados;
    private ArrayList <Musica> musicasquetoca;
    private ArrayList <Sessao> sessoesaquepertence;
    private ArrayList <Instrumento> instrumentosmusico;
    
    
    // CONSTRUTORES
    
    public Musico()
    {
        super("Empty user name", "Empty pass", "Empty name");
        albunsassociados = new ArrayList<>();
        musicasquetoca= new ArrayList<>();
        sessoesaquepertence= new ArrayList<>();
        instrumentosmusico= new ArrayList<>();
    }

    
    // MÉTODO CONSTRUTOR

    public void construtorimprovisado(String userlogin, String palavrapasse, String nomeverdadeiro){
        super.setNomeverdadeiro(nomeverdadeiro);
        super.setUserlogin(userlogin);
        super.setPalavrapasse(palavrapasse);
    }
    
    
    //MÉTODOS
    
    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public double getNbilheteidentidade() {
        return nbilheteidentidade;
    }

    public void setNbilheteidentidade(double nbilheteidentidade) {
        this.nbilheteidentidade = nbilheteidentidade;
    }
  
    public ArrayList getAlbunsAssociados(){
        return albunsassociados;
    }
    
    public void adicionaalbum(Album a){
        albunsassociados.add(a);
    }
    
    public void adicionaMusicaaoMusico(Musica m){
        musicasquetoca.add(m);
    }
    
    public String getMusicasdoMusico(){
        String ret="";
        for(Musica mm : musicasquetoca){
            ret+=mm.toString();
            ret+="\n";
        }
        return ret;
    }
    
    public void adicionamussessao(Musico m, int id){
        //sessoesaquepertence.get(sessoesaquepertence.size()).adicionamusico(m);
        if(sessoesaquepertence != null){
        for(Sessao s : sessoesaquepertence){
            if(s.getIdsessao()==id) s.adicionamusico(m);
        }
        }
    }
    
    public void adicionaSessaoaoMusico(Sessao s){
        sessoesaquepertence.add(s);
    }
    
    public String getSessoesdoMusico(){
        String ret="";
        for(Sessao ss : sessoesaquepertence){
            ret+=ss.toString();
            ret+="\n";
        }
        return ret;
    }
    
    public String listarSessoesmus(){       //isto provavelmente está mal
        String ret = "";
        
        for(Sessao s : sessoesaquepertence){
            ret+=s.toString();
            ret+="\n";
         
        }
        if(ret=="") ret="Não tem sessões associadas";
        return ret;
    }
    
    public void adicionaInstrumentoMusico(Instrumento m){
        instrumentosmusico.add(m);
    }
    
    public String listarInstrumentosmus(){
        String ret ="";
        
        for(Instrumento i: instrumentosmusico){
            ret+="Instrumento: "+i.getNomeinstrumento(); 
            ret+="\n";
        }
        if(ret=="") ret="Não tem instrumentos associados";
        return ret;
    }
    
    public int nsessoesconcluidas(){
        int ret =0;
        for(Sessao s : sessoesaquepertence)
        {
            if(s.getEstado()==true) ++ret;
        }
        return ret;
    }
    /*
    public void adicionaDaSessãoaoMusico(Sessao s){ //sessao com músicos do album
        albunsassociados.add(s.getAlbumasergravado());
        musicasquetoca.addAll(s);
    }
   */
     
    
}
