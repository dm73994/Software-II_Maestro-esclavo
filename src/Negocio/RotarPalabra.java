package Negocio;

public class RotarPalabra {
	private sacarCola palabra;
	private FijarTexto fijador;
	int terminar = 0;
	
	public RotarPalabra(sacarCola palabra,FijarTexto fijador) {
		this.palabra = palabra;
		this.fijador = fijador;
	}

	public void ejecutar(int tamanio){
		aplicarRotacion(tamanio);
	}
	
	public void aplicarRotacion(int tamanio) {
    	for(int i = 0 ; i < tamanio ; i++) {
    		System.out.println(palabra.shift());
    		fijador.fijarNuevoTexto();
    	}
		this.terminar = 1;
    }
    
    public void aplicarRotacion(Sentence palabra) {
    	aplicarRotacion(palabra.cantidadPalabras());
    }

	public int getTerminar(){
		return terminar;
	}
}
