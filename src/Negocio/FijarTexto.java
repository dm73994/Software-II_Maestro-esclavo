package Negocio;

public class FijarTexto {
	private sacarCola palabra;
	
	public FijarTexto(sacarCola palabra) {
		this.palabra = palabra;
	}
	
	public void fijarNuevoTexto(){
        this.palabra.setTexto(palabra.shift());
    }
}
