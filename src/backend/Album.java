package backend;

import java.time.LocalDate;
import java.util.ArrayList;


public class Album implements java.io.Serializable{
    
    //ATRIBUTOS
    
    private ArrayList <Musica>  album;
    private ArrayList <Sessao>  sessoesgravacao;
    private ArrayList <Musico> musicosassociados;
    private String nomealbum;
    private float duraçãototal=0;
    private boolean single;
    private String tipodealbum;
    private LocalDate dataalbum;
    private Produtor oqueproduziu;
    private boolean estado;     //true- concluido false- não concluido
    private int nsessoes, nsessoesconc, nsessoespconc;

  
    // CONSTRUTORES
    
   public Album()
   {
       album = new ArrayList<>(); 
       sessoesgravacao = new ArrayList<>(); 
       musicosassociados = new ArrayList<>(); 
   
   }

       
    // MÉTODO CONSTRUTOR

    public void construtorimprovisado(String nomealbum, String tipodealbum, Produtor oqueproduziu, LocalDate dataalbum){
        this.nomealbum = nomealbum;
        single=false;
        this.tipodealbum = tipodealbum;
        this.oqueproduziu = oqueproduziu;
        this.dataalbum=dataalbum;
        nsessoes=0;
        nsessoesconc=0;
        nsessoespconc=0;
        estado=false;
  }
    
    
    //MÉTODOS

    public String getNomealbum() {
        return nomealbum;
    }

    public void setNomealbum(String nomealbum) {
        this.nomealbum = nomealbum;
    }

    public int getNumeromusicas() {
        return album.size();
    }

    public void setEstadosessao(Sessao ss, boolean estado){
        for(Sessao s : sessoesgravacao){
            if(ss.getIdsessao()==s.getIdsessao()) s.setEstado(estado);
        }        
    }

    public void setDatasessao(Sessao ss, LocalDate data){
        for(Sessao s : sessoesgravacao){
            if(ss.getIdsessao()==s.getIdsessao()) s.setDatasessao(data);
        }        
    }
    
    public void setDescriçãosessao(Sessao ss, String descrição){
        for(Sessao s : sessoesgravacao){
            if(ss.getIdsessao()==s.getIdsessao()) s.setDescrição(descrição);
        }    
    }
    
    public void setsessporconcl(){
        ++nsessoespconc;
    }
    
    public float getDuraçãototal() {
        return duraçãototal;
    }
    public float calcDuraçãototal() {       //colocar mais cenas nesta
        duraçãototal=0;
        for(Album a : album){
            duraçãototal+=duraçãototal;
        }
        return duraçãototal;
    }

    public void adicionamusicosasessao(){
        for(Sessao s : sessoesgravacao){
            s.musassociados().addAll(getMusicosassociados());
        }
    }
    
    public void setDuraçãototal(float duraçãototal) {
        this.duraçãototal = duraçãototal;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public String getTipodealbum() {
        return tipodealbum;
    }

    public void setTipodealbum(String tipodealbum) {
        this.tipodealbum = tipodealbum;
    }

    public ArrayList getSessoesgravacao(){
        return sessoesgravacao;
    }
    
    public LocalDate getDataalbum() {
        return dataalbum;
    }

    public void setDataalbum(LocalDate dataalbum) {
        this.dataalbum = dataalbum;
    }

    public Produtor getOqueproduziu() {
        return oqueproduziu;
    }

    public void setOqueproduziu(Produtor oqueproduziu) {
        this.oqueproduziu = oqueproduziu;
    }
    
    public ArrayList getAlbum() {
        return album;
    }
    
    public ArrayList getMusicosassociados(){
        return musicosassociados;
    }
    
    public void setSessoesgravacao (ArrayList sessoesgravacao) {
        this.sessoesgravacao = sessoesgravacao;
        
    }
    
    public void setEstado(boolean estado){ 
        if(estado==true && this.estado!=true){
            nsessoesconc++;
        }
        if(estado==false && this.estado!=false)  nsessoesconc--;
        this.estado=estado;
    }
    
    public int getNsessoes() {
        return nsessoes;
    }

    public void setNsessoes(int nsessoes) {
        this.nsessoes = nsessoes;
    }

    public int getNsessoesconc() {
        return nsessoesconc;
    }

    public void setNsessoesconc(int nsessoesconc) {
        this.nsessoesconc = nsessoesconc;
    }

    public int getNsessoespconc() {
        return nsessoespconc;
    }

    public void setNsessoespconc(int nsessoespconc) {
        this.nsessoespconc = nsessoespconc;
    }
    
    public ArrayList getmusicosassociados(){
        return musicosassociados;
    }
      
    public void transformareqemalbum(Requisicao r){
        nomealbum=r.getAlbumreq();
        tipodealbum=r.getTipo();
        oqueproduziu=r.getProdquefez();
        dataalbum=r.getDatarequisição();
        
    }
      
    public boolean getEstado(){
        return estado;
    }
    
    public String getEstadolegivel(){
        String ret="";
        if(estado==false) ret="Em edição";
        if(estado==true) ret="Concluido";
        return ret;
    }
    
    public String toString(){
        String mandar="";
        mandar = "Nome: "+nomealbum+" | Género: "+tipodealbum+" |  Data de lançamento: "+dataalbum+" | Estado: "+getEstadolegivel()+" | Produtor responsável: "+oqueproduziu.getNomeverdadeiro()+"("+oqueproduziu.getUserlogin()+")";
        return mandar;
    }
    
    public void adicionarAssociado (Musico mus){
        musicosassociados.add(mus);
    }
    
    public boolean encontraAssociado(Musico m){
        
        for(Musico mm : musicosassociados){
            if(mm.getUserlogin().equals(m.getUserlogin())) return true;
        }
        return false;
    }
    
    public void adicionaMusica(Musica mus)
    {
        album.add(mus);
    }
    
    public void removesessaoAlbum(int id){
        boolean z = false;
        for(Sessao s : sessoesgravacao){
            if(s.getIdsessao()==id && estado==false && s.getEstado()==false) {
                sessoesgravacao.remove(s);
                --nsessoes;
                --nsessoespconc;
                z=true;
            }
        }
        if(z==false) System.out.println("Impossível remover uma sessão que já aconteceu.");        
    }
   
   public void adicionassessaoAlbum(Sessao s)
   {
       sessoesgravacao.add(s);
       ++nsessoes;
       ++nsessoespconc;
   }
   
   public void adicionamusicoassociado(Musico m){
       musicosassociados.add(m);
   }
           
             
   public void retirasessaoAlbum(Sessao s){
       sessoesgravacao.remove(s);
       --nsessoes;
       --nsessoespconc;
   }
      
   public double calcpersessconcl(){                //percentagem de sessões concluidas para 1 album
       double persessconcl=0;
       if(nsessoes==0)  persessconcl=0;
       else persessconcl=(nsessoesconc*100)/nsessoes;
       return persessconcl;     
   }
   
    
    public double calcmedsessoesgravacaomes(int ano, int mes){
       double mediatotal=0;
       for(Sessao s: sessoesgravacao){
           if(s.getEstado()==true && (s.getDatasessao().getDayOfMonth()==mes) && (s.getDatasessao().getDayOfYear())==ano) ++mediatotal;
       }
       mediatotal=mediatotal/sessoesgravacao.size();
       return mediatotal;      
    }
}
