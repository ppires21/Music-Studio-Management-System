package backend;

import java.util.ArrayList;


public class Instrumento implements java.io.Serializable{
    
    //atributos
    private String nomeinstrumento;
    private int quantidadeexistente;
    private int quantidadedisponivel;
    private ArrayList<Musico> musicosdoinstrumento;
    
   
    public Instrumento()
    {
        musicosdoinstrumento = new ArrayList<>();
    }
       
    //MÉTODOS

    public void construtorimprovisado(String nomeinstrumento){
        this.nomeinstrumento=nomeinstrumento;
        quantidadeexistente=1;
        quantidadedisponivel=quantidadeexistente;
    }
    
    public String getNomeinstrumento() {
        return nomeinstrumento;
    }

    public void setNomeinstrumento(String nomeinstrumento) {
        this.nomeinstrumento = nomeinstrumento;
    }

    public int getQuantidade() {
        return quantidadeexistente;
    }

    public void setQuantidade(int quantidadeexistente) {
        this.quantidadeexistente = quantidadeexistente;
    }    
    
    public int getQuantidadedisponivel() {
        return quantidadedisponivel;
    }

    public void setQuantidadedisponivel(int quantidadedisponivel) {
        this.quantidadedisponivel = quantidadedisponivel;
    }
    
    public void diminuiquantidadedisponivel(){
        --quantidadedisponivel;
    }
    
    public void adicionamusicosinstrumento(Musico m){
        diminuiquantidadedisponivel();
        musicosdoinstrumento.add(m);
    }
    
    public String toString(){
        String ret = "";
        ret = "Nome instrumento: "+nomeinstrumento+" | Quantidade existente: "+quantidadeexistente+" | Quantidade disponível: "+quantidadedisponivel;
        return ret;  
    }
}
