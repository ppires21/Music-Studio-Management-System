package backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Sessao implements java.io.Serializable{
    
    //ATRIBUTOS

    private String descrição;
    private LocalDate datasessao;
    private ArrayList <Instrumento> instrumentosnecessarios;
    private ArrayList <Musico> musicosassociados;
    private Album albumasergravado;
    private boolean estado;         //false- por concluir
    private Produtor donosessao;
    //private static int idsessaost;
    private int idsessao;
    
    //CONSTRUTOR
    
    public Sessao()
    {
        instrumentosnecessarios = new ArrayList<>();
        musicosassociados= new ArrayList<>();
    }
    
    //MÉTODO CONSTRUTOR
    
        public void construtorimprovisado(String descrição, LocalDate datasessao, Album albumasergravado, Produtor donosessao)
        {
        this.descrição = descrição;
        this.datasessao = datasessao;
        this.albumasergravado = albumasergravado;
        estado=false;       
        this.donosessao=donosessao;
        ++idsessao;
    }

        
    //MÉTODOS 
        
    public Produtor getDonosessao() {
        return donosessao;
    }

    public void setDonosessao(Produtor donosessao) {
        this.donosessao = donosessao;
    }
    
    public String toString(){
        String state="";
        String ret="";
        
        if(estado==true) {state="Realizada";}
        else if(estado==false) {state= "Por realizar";}
        
        ret = "Id: "+idsessao+" | Album: "+albumasergravado+" | Data: "+datasessao+" | Estado: "+state+"\nDescrição: "+descrição;
        return ret;
    }
    
    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public LocalDate getDatasessao() {
        return datasessao;
    }

    public void setDatasessao(LocalDate datasessao) {
        this.datasessao = datasessao;
    }

    public ArrayList getInstrumentosnecessarios() {
        return instrumentosnecessarios;
    }

    public void adicionaInstrumento(Instrumento i){
        instrumentosnecessarios.add(i);
    }
    
    public void setInstrumentosnecessarios(ArrayList instrumentosnecessarios) {
        this.instrumentosnecessarios = instrumentosnecessarios;
    }

    public Album getAlbumasergravado() {
        return albumasergravado;
    }

    public void setAlbumasergravado(Album albumasergravado) {
        this.albumasergravado = albumasergravado;
    }
    
    public boolean getEstado(){
        return estado;
    }
    
    
    public void setEstado(boolean estado){
        this.estado=estado;
    }
    
    public String getuserDonoSessao(){
        return donosessao.getUserlogin();
    }
    
    public ArrayList musassociados(){
        return albumasergravado.getMusicosassociados();
    }
    
    public void adicionaIdsessao (int idsessao){
        this.idsessao=idsessao;
    }
    
    public int getIdsessao(){
        return idsessao;
    }
    
    public void setIdsessao(int id){
        idsessao=id;
    }
    
    public void setMusicosAssociados(ArrayList l){
        musicosassociados.addAll(l);
    }
    
    public void adicionaMusicosAssociados(){     //coloca os músicos do album a ser gravado na sessão colocada
        for(int i=0; i<albumasergravado.getMusicosassociados().size(); i++){
            setMusicosAssociados(albumasergravado.getMusicosassociados());
        }
    }
    
    public void adicionamusico(Musico m){
        musicosassociados.add(m);
    }
    
    public ArrayList getMusicosassociados(){
        return musicosassociados;
    }
    
    //Depois comparo isto à lista de músicos e se o músico estiver na sessão, adiciona a sessão ao músico e o seu album 
    
    
    
    
    
}
