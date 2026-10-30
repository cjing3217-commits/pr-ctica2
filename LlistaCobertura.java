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
    * @return elements
    */
   public int getElement(){
        return elements;
    }

    /**
     * Mètode que retorna les dades d'una certa posició de la llista
     * @param pos posició de la cobertura a obtenir
     * @return les dades d'una llista d'una certa posició
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
        if (this.elements < llista.length){
            llista[this.elements] = c.copia();
            this.elements++;
        }
       
   }

   /**
    * Mètode que retorna el total de punts de la llista de cobertura
    * @return nombre de cobertures amb velocitat superior a 100
    */
   public int velocitatSuperior100(){
        int cont = 0;
        for (int i = 0; i < elements;i++){
          if (llista[i].getVelocitat()>100){
            cont++;
          }
          } 
          return cont;
    }

    /**
     * Mètode que retorna el valor de la cobertura amb menys precisió
     * @return la instància de cobertura amb menys precisió
     */
    public Cobertura menysPrecisio (){
        if (elements == 0){
                return null;
        }
        Cobertura menysprecis = llista[0];
        for (int i=1; i<elements; i++){
            if (menysprecis.getPrecisio() > llista[i].getPrecisio()){
                menysprecis = llista[i].copia();
            }
        }
        return menysprecis;
    }
    /**
     * Mètode que crea un duplicat de la cobertura amb menys precisió per un tipus de xarxa i un nombre de satèl·lits superior o igual a l'indicat
     * @param activitat tipus de xarxa a buscar
     * @param nsat nombre de satèl·lits a buscar
     * @return instáncia de cobertura trobada
     */
    public Cobertura duplicatXarxa4G (String activitat,int nsat){
        boolean trobat = false;
        int i = 0;
        while (i<elements && !trobat){
            if(llista[i].getTipusXarxa().equalsIgnoreCase("4G") && llista[i].getActivitat().equalsIgnoreCase(activitat) && llista[i].getSatelits() > nsat){
                trobat = true;
            }
            else{
                i++;
            }
        }
        if (trobat){
            return llista[i].copia();
        }
        else{
            return null;
        }
    }

    /**
     * Calcula el nombre de cobertures amb factor d'eficiència superior a un valor indicat
     * @param x valor mínim del factor d'eficiència 
     * @return nombre de cobertures que compleixen la condició donada
     */
    public int Eficiencia (int x){
        int cont = 0;
        for (int i=0;i<elements;i++){
            if (llista[i].factorEficiencia() > x ){
                cont++;
            }
        }
        return cont;
    }

    /**
     * Mètode que consulta les dades d'un municipi indicat
     * @param municipi nom del municipi a buscar
     * @return Llista de Cobertura amb els punts de cobertura del municipi
     */
    public LlistaCobertura dadesMunicipi(String municipi){
        LlistaCobertura resultat = new LlistaCobertura(elements);
        for(int i = 0; i < elements; i++){
            if(llista[i].getNomMunicipi().equalsIgnoreCase(municipi)){
                resultat.afegirCobertura(llista[i]);
            }
        }
        return resultat;
    }

       /**
     * Mètode que consulta les dades d'un operador indicat
     * @param nomOperador nom de l'operador indicat
     * @return Llista de Cobertura amb els punts de cobertura de l'operador
     */
    public LlistaCobertura dadesCobertura(String nomOperador){
        LlistaCobertura resultat = new LlistaCobertura(elements);
        for(int i = 0; i < elements; i++){
            if(llista[i].getOperador().equalsIgnoreCase(nomOperador)){
                resultat.afegirCobertura(llista[i]);
            }
        }
        return resultat;
    }

    /**
     * Mètode per eliminar un conjunt de dades d'un cert codi postal indicat 
     * @param codiPostal codi postal d'un cert municipi
     */
   public void eliminar(int codiPostal) {
    for (int i = 0; i < elements; i++) {
        if (llista[i].getCodiPostal() == codiPostal) {
            for (int j = i; j < elements - 1; j++) {
                llista[j] = llista[j + 1];
            }
            llista[elements - 1] = null;   // quita la copia repetida del final
            elements--;                    // un elemento menos
            i--;                           // vuelvo a mirar esta posición
        }
    }
}

}
