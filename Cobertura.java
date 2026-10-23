public class Cobertura {
	private String operador;
	private String tipusXarxa;
	private int velocitat;
	private int satelits;;
	private int precisio;
	private String activitat;
	private int codiPostal;
	private String nomMunicipi;

	/**
	 * Constructor de la classe Cobertura
	 * @param operador
	 * @param netType
	 * @param speed
	 * @param satellites
	 * @param precision
	 * @param activitat
	 * @param codiPostal
	 * @param nom
	 */

	public Cobertura(String operador, String netType, int speed, int satellites,
			int precision, String activitat, int codiPostal, String nom) {
		this.operador = operador;
		this.tipusXarxa = netType;
		this.velocitat = speed;
		this.satelits = satellites;
		this.precisio = precision;
		this.activitat = activitat;
		this.codiPostal = codiPostal;
		this.nomMunicipi = nom;
	}

	/**	(non-Javadoc)
	 * Mètode toString que retorna la informació de la Cobertura
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		String aux = "\n\tOperador:" + operador + "\n\tXarxa:" + tipusXarxa + "\n\tVelocitat:" +
				velocitat + "\n\tSatèl.lits:" + satelits + "\n\tPrecisió:" + precisio + "\n\tActivitat:" +
				activitat + "\n\tCodi Postal:" + codiPostal + "\n\tMunicipi:" + nomMunicipi;
		return aux;
	}

	/**
	 * Mètode que retorna una còpia de l'objecte Cobertura
	 * @return
	 */
	public Cobertura copia() {
		Cobertura duplicat = new Cobertura(operador, tipusXarxa, velocitat, satelits,
				precisio, activitat, codiPostal, nomMunicipi);
		return duplicat;
	}

	/**
	 * Mètode que retorna l'operador de la Cobertura
	 * @return
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * Mètode que retorna el tipus de xarxa de la cobertura
	 * @return
	 */
	public String getTipusXarxa() {
		return tipusXarxa;
	}

	/**
	 * Mètode que retorna la velocitat de la cobertura
	 * @return
	 */
	public int getVelocitat() {
		return velocitat;
	}

	/**
	 * Mètode que retorna el nombre de satèl·lits de la cobertura
	 * @return
	 */
	public int getSatelits() {
		return satelits;
	}

	/**
	 * Mètode que retorna la precisió de la cobertura
	 * @return
	 */
	public int getPrecisio() {
		return precisio;
	}

	/**
	 * Mètode que retorna l'activitat de la cobertura
	 * @return
	 */
	public String getActivitat() {
		return activitat;
	}

	/**
	 * Mètode que retorna el codi postal del municipi
	 * @return
	 */
	public int getCodiPostal() {
		return codiPostal;
	}

	/**
	 * Mètode que retorna el nom del municipi
	 * @return
	 */
	public String getNomMunicipi() {
		return nomMunicipi;
	}
	
	/**
 * Calcula el factor d'eficiència del punt de cobertura:
 * (velocitat * precisió) / satèl·lits, o 0 si no hi ha satèl·lits.
 * @return el factor d'eficiència
 */
public int factorEficiencia() {
    if (satelits == 0) {
        return 0;
    }
    return velocitat * precisio / satelits;
}
	
}
