package backend;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Requisicao implements java.io.Serializable{
    
    //ATRIBUTOS REQUISIÇÃO INSTRUMENTOS
    private boolean tiporeq;        //true- INSTRUMENTO, false- ALBUM
    private String nomeinstrumento;
    private int quantidade;
    private int idrequisiçao;
    //private static int idrequisiçaost;
    private int estado=0;                               // 0- pendente, 1- atribuido, -1 recusado
    private Musico musicoquefez;
    private Sessao sessaoassociada;

   
    //ATRIBUTOS REQUISIÇÃO ALBUNS
    
    private Album albumreqq;
    private String albumreq;
    private LocalDate datarequisiçao;    //data da possível sessão - PARA ALBUNS
    private Produtor prodquefez;
    private String tipo;
    
  
    //  CONSTRUTORES
    
    public Requisicao(){}
    
      
    //  MÉTODOS CONSTRUTORES
    
    public void construtorimprovisadoalb(String albumreq, String tipo, Produtor prodquefez, LocalDate datarequisiçao){
        //idrequisiçao=idrequisiçaost;
        this.albumreq=albumreq;
        this.tipo=tipo;
        this.prodquefez=prodquefez;
        this.datarequisiçao=datarequisiçao;
        this.sessaoassociada=sessaoassociada;
        estado=0;
        tiporeq=false;
       ++idrequisiçao;
    }
        
    public void construtorimprovisadoinstr(String nomeinstrumento, int quantidade, Musico musicoquefez, Sessao sessaoassociada) {
        //idrequisiçao=idrequisiçaost;
        this.nomeinstrumento=nomeinstrumento;
        this.quantidade=quantidade;
        this.sessaoassociada=sessaoassociada;
        estado=0;
        tiporeq=true; 
        ++idrequisiçao;
        //++idrequisiçaost;
    }
    
    //  MÉTODOS
    
    public int getIdrequisiçao() {
        return idrequisiçao;
    }
    
    public void setIdrequisiçao(int idrequisiçao){
        this.idrequisiçao=idrequisiçao;
    }
    
     public Sessao getSessaoassociada() {
        return sessaoassociada;
    }

    public void setSessaoassociada(Sessao sessaoassociada) {
        this.sessaoassociada = sessaoassociada;
    }
    
    
    public String getAlbumreq(){
        return albumreq;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public Produtor getProdquefez(){
        return prodquefez;
    }
    
    
    
    public String getNomeinstrumento(){
        return nomeinstrumento;
    }

    public void setSessaoemsi(int idrequisiçao) {
        this.idrequisiçao = idrequisiçao;
    }

    public Musico getMusicoquefez() {
        return musicoquefez;
    }

    public void setMusicoquefez(Musico musicoquefez) {
        this.musicoquefez = musicoquefez;
    }

    public LocalDate getDatarequisição() {
        return datarequisiçao;
    }

    public void setDatarequisição(LocalDate datarequisiçao) {
        this.datarequisiçao = datarequisiçao;
    }
    
    public int getEstado(){
        return estado;
    }
    
    public void aceita(){
        estado=1;
    }
    
    public void recusa(){
        estado=-1;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public boolean getTiporeq(){
        return tiporeq;
    }
    
    public Album getAlbum(){        //para quando for aceite e quisermos colocar na lista de albuns
        return albumreqq;
    }
    
    public String traduzEstado(){
        String ret="";
        if(estado==0) ret ="Pendente";
        else if (estado==1) ret="Aceite";
        else if(estado==-1) ret="Recusado";
        return ret;
    }
    
    public String toStringinstrumento(){
        String ret="";
        ret= "Id: " +idrequisiçao+" | Instrumento: "+ nomeinstrumento+ " | Requisitado por: " + musicoquefez.getNomeverdadeiro()+" | Estado: "+traduzEstado();
        return ret;
    }
    
    public String toStringalbum(){
        String ret = "Id: "+idrequisiçao+" | Album: "+albumreq + " | Produtor: "+prodquefez.getNomeverdadeiro()+" | Data: "+datarequisiçao.toString()+" | Estado: "+traduzEstado();
        return ret;
    }
    
    
    /*
    public void gravarRequisiçao(String fich) throws IOException
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
        listaRequisiçoes=(ArrayList <Requisiçao>) in.readObject();
        in.close();
       }
        catch(IOException e){}
     
    }
    
    */
}
