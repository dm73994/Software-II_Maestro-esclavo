package Negocio;

public class Concatenador {
    public Concatenador(){

    }

    public String concatenarPalabras(String palabras[]) {
		String texto = "";
		for(int i = 0 ; i < palabras.length ; i++) {
			texto = texto + " " + palabras[i];
		}
		return texto;
	}
}
