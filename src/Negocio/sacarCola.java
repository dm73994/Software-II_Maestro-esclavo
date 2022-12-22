package Negocio;

public class sacarCola{
	private Sentence parrafo;
	
	public sacarCola(Sentence parrafo){
		this.parrafo = parrafo;
	}
	
	public String getTexto() {
		return parrafo.getTexto();
	}
	
	public void setTexto(String texto) {
		this.parrafo.setTexto(texto);
	}
    
    public String shift(){
        String nuevaPalabra = "";
        String palabra = this.getTexto();
        String [] palabraFragmentada = palabra.split(" ");
        for(int i = 0 ; i < palabraFragmentada.length-1 ; i++){
            nuevaPalabra = nuevaPalabra + palabraFragmentada[i] + " ";
        }
        return palabraFragmentada[palabraFragmentada.length - 1] +" "+ nuevaPalabra;
    }
}
