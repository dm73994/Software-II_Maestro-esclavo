package Negocio;

public class Sentence {
    private String texto;
   
    public Sentence(String texto){
        this.texto = texto;
    }
    
    public String getTexto(){
        return this.texto;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public int cantidadPalabras() {
    	String[] palabras = texto.split(" ");
    	return palabras.length - 1;
    }
}