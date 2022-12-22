package Negocio;

public class Sort {
	private Sentence parrafo;
	private Concatenador concatenador;
	private int terminar = 0;
	
	public Sort(Sentence parrafo) {
		this.concatenador = new Concatenador();
		this.parrafo = parrafo;
	}
	
	public String getParrafo() {
		return this.parrafo.getTexto();
	}
	
	
	

	public String ejecutar(){
		return burbujaSort();
	}

	public String ejecutar(Object s){
		return quicksort();
	}
	
	public String burbujaSort() {
		String texto = this.getParrafo();
		String [] palabraFragmentada = texto.split(" ");
		
		for(int i = 0 ; i < palabraFragmentada.length ; i++) {
			for(int j = 0 ; j < palabraFragmentada.length - 1 ; j++) {
				String actual = palabraFragmentada[j];
				String siguiente = palabraFragmentada[j + 1];
				if(actual.compareTo(siguiente) >0) {
					palabraFragmentada[j] = siguiente;
					palabraFragmentada[j+1] = actual;
				}
			}
		}
		
		String textoOrdenado = concatenador.concatenarPalabras(palabraFragmentada);
		this.terminar = 1;
		return textoOrdenado;
	}
	
	public void quickSort(String palabraFragmentada[],int primero,int ultimo) {
		String pivote = palabraFragmentada[primero];
		String auxiliar;
		int i = primero;
		int j = ultimo;
		
		 while(i < j){                                                            
		     while(palabraFragmentada[i].compareTo(pivote) <= 0 && i < j) i++; 
		     while(palabraFragmentada[j].compareTo(pivote) >0) j--;   
		     
		     if (i < j) {                                         
		         auxiliar= palabraFragmentada[i];                      
		         palabraFragmentada[i]=palabraFragmentada[j];
		         palabraFragmentada[j]=auxiliar;
		     }
		   }
		   
		 palabraFragmentada[primero]=palabraFragmentada[j];                                      
		 palabraFragmentada[j]=pivote;      
		   
		 if(primero < j-1) {
			 quickSort(palabraFragmentada,primero,j-1);        
		 }
	   
		 if(j+1 < ultimo) {
			 quickSort(palabraFragmentada,j+1,ultimo);  
		 }
	}
	
	public String quicksort() {
		String texto = this.getParrafo();
		String [] palabraFragmentada = texto.split(" ");
		quickSort(palabraFragmentada,0,palabraFragmentada.length-1);
		String textoOrdenado = concatenador.concatenarPalabras(palabraFragmentada);
		this.terminar = 1;
		return textoOrdenado;
	}

	public int getTerminar(){
		return terminar;
	}
}
