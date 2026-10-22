public class LlistaCobertura {
   private Cobertura[] llista; 
   private int elements;

   /**
    * Constructor de la classe LlistaCobertura
    * @param elements
    */
   public LlistaCobertura(int capacitat){
        this.llista = new Cobertura[capacitat];
        this.elements = 0;
   }
   /**
    * Mètode que retorna el número d'elements de la llista
    * @return
    */
   public int getElement(){
        return elements;
    }

    /**
     * Mètode que retorna les dades d'una certa posició de la llista
     * @param pos
     * @return
     */
    public Cobertura getDada (int pos){
        return llista[pos];
    }
    
    /**    (non-Javadoc)
     * Mètode toString que retorna la informació de la llista de cobertura
     * @see java.lang.Object#toString()
     */
    public String toString(){
        String aux ="";
        aux = llista[0].toString();
        for (int i=0;i<elements;i++){

            aux += llista[i].toString();
        }
        return "La llista de cobertura:" + aux;
    }

    /**
     * Mètode que afegeix una cobertura a la llista
     * @param c
     */
    public void afegirCobertura (Cobertura c){
        if (this.elements < elements){
             llista[this.elements] = c.copia();
            this.elements++;
        }
       
   }

   /**
    * Mètode que retorna el total de punts de la llista de cobertura
    * @param c
    * @return
    */
   public int Puntstotals(Cobertura c){
        int totalpunts = 0;
        for (int i = 0; i < elements;i++){
          if (c.getVelocitat()>100){
            totalpunts += 1;
          }
          } 
          return totalpunts;
    }

    /**
     * Mètode que retorna el valor de la cobertura amb menys precisió
     * @return
     */
    public Cobertura menysPrecisio (){
        Cobertura menysprecis = llista[0];
        for (int i=1; i<elements; i++){
            if (menysprecis.getPrecisio() < llista[i].getPrecisio()){
                menysprecis = llista[i].copia();
            }
            if (elements == 0){
                menysprecis = null;
            }
        }
        return menysprecis;
    }
/**
     * Mètode que retorna quants elemetns de la llista tenen una velocitat major a 100
     * @return
     */
    public int majorA100(){
        int contador = 0;
        for (int i=0; i<elements; i++){
            if(llista[i].getVelocitat() > 100){
                contador++;
            }
        }
        
        return contador;

    }
/**
 * Metode que retorna una llista amb les dades d'un municipi concret
 * @param municipi
 * @return
 */

    public LlistaCobertura dadesMunicipi(String municipi){
        LlistaCobertura resultat = new LlistaCobertura(llista.length);
        for(int i = 0; i < elements; i++){
            if(llista[i].getNomMunicipi().equals(municipi)){
                resultat.afegirCobertura(llista[i]);

            }
        }
        return resultat;
    }
    /**
     * Metode que retorna una llista amb les dades d'un operador concret
     * @param nomOperador
     * @return
     */
    public LlistaCobertura dadesCobertura(String nomOperador){
        LlistaCobertura resultat = new LlistaCobertura(llista.length);
        for(int i = 0; i < elements; i++){
            if(llista[i].getOperador().equals(nomOperador)){
                resultat.afegirCobertura(llista[i]);
            }
        }
        return resultat;
    }

    public void eliminarCobertura (int codiPostal){
        int i = 0;
        while (i < elements){
            if (llista[i].getCodiPostal() == codiPostal){
                for (int j = i; j < elements -1; j++){
                    llista[j] = llista[j+1];
                    llista[elements -1] = null;
                    elements--;
                }
            }
            else {
                i++;
            }
            

        }
    }

   
        

    public Cobertura duplicat(String tipus, int numSatelits) {
        for (int i = 0; i < elements; i++) {
            if(llista[i].getSatelits() > numSatelits && llista[i].getActivitat().equals(tipus) && llista[i].getTipusXarxa().equals("4G")){
                return llista[i].copia();
            }
        }
        return null;
    }

}
