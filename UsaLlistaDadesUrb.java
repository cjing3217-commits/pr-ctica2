import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UsaLlistaDadesUrb {
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		int liniaIni, liniaFi;

		System.out.println("Indica les línies a llegir del fitxer");
		System.out.println("Quina és la primera línia a llegir del fitxer (valor >=1)");
		liniaIni = Integer.parseInt(teclat.nextLine());
		System.out.println("Quina és l'última línia a llegir del fitxer (valor <=12324)");
		liniaFi = Integer.parseInt(teclat.nextLine());

		String[] dataset = llegirLiniesFitxer(liniaIni, liniaFi);

		// Creem una instància de LlistaCobertura amb la mida del dataset
		LlistaCobertura LlistaCob = new LlistaCobertura(dataset.length);
		// Recorrem el dataset
		for (int i = 0; i < dataset.length; i++) {
			// Utilitzem split per separar la informació de cada línia
			String[] dades = dataset[i].split(";");
			// Creem una instància de Cobertura amb les dades separades
			Cobertura Cob = new Cobertura(dades[0], dades[1], Integer.parseInt(dades[2]),
					Integer.parseInt(dades[3]), Integer.parseInt(dades[4]), dades[5],
					Integer.parseInt(dades[6]), dades[7]);
			// L'afegim a la llista de cobertures
			LlistaCob.afegirCobertura(Cob);
		}

		// MENÚ

		// 1. Mostrem el menú
		mostrarMenu();

		// 2. Mentre l'usuari no indiqui sortir del programa (amb el 8), anem mostrant el menú i demanant una opció
		int opcio = Integer.parseInt(teclat.nextLine());
		while (opcio != 8) {
			switch (opcio) {
				case 1:
					opcio1(LlistaCob);
					break;
				case 2:
					opcio2(LlistaCob);
					break;
				case 3:
					opcio3(LlistaCob);
					break;
				case 4:
					opcio4(LlistaCob);
					break;
				case 5:
					opcio5(LlistaCob);
					break;
				case 6:
					opcio6(LlistaCob);
					break;
				case 7:
					opcio7(LlistaCob);
					break;
				default:
					System.out.println("Opció no vàlida. Tria un número de l'1 al 8.");
			}

			// 3. Tornem a mostrar el menú i demanem una nova opció
			mostrarMenu();
			opcio = Integer.parseInt(teclat.nextLine());
		}
	}

	public static void mostrarMenu() {
		System.out.println("\n\nMENÚ");
		System.out.println("\t1. Mostrar el conjunt de dades de la llista de cobertures");
		System.out.println("\t2. Eliminar el conjunt de dades que són d’un cert codi postal");
		System.out.println("\t3. Comptar quants punts de cobertura tenen una velocitat superior a 100");
		System.out.println("\t4. Mostrar les dades de la instància que té menys precisió");
		System.out.println("\t5. Calcular el factor d’eficiència de la instància amb el tipus d’activitat indicat per paràmetre (TILTING o STILL), xarxa 4G i amb un nombre de satèl·lits captats superior a 13");
		System.out.println("\t6. Mostrar quants punts de cobertura tenen un factor d’eficiència per sobre de x (donat per l’usuari) en un municipi en concret (usuari indica el nom)");
		System.out.println("\t7. Mostrar les dades de tots els punts de cobertura d’un operador indicat per paràmetre");
		System.out.println("\t8. Sortir del programa");
	}

	public static void opcio1(LlistaCobertura LlistaCob) {
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 1: Mostrar el conjunt de dades de la llista de cobertures");
		// Mostrem per pantalla el contingut de la llista de cobertures
		System.out.println(LlistaCob.toString());
	}

	public static void opcio2(LlistaCobertura LlistaCob) {
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 2: Eliminar el conjunt de dades que són d’un cert codi postal");
		// Demanem a l'usuari el codi postal a eliminar
		System.out.println("Introdueix el codi postal a eliminar:");
		int codiPostal = Integer.parseInt(teclat.nextLine());
		// Eliminem les cobertures del codi postal i comptem quantes n'hem eliminat
		int abans = LlistaCob.getElement();
		LlistaCob.eliminar(codiPostal);
		int eliminades = abans - LlistaCob.getElement();
		if (eliminades > 0) {
			System.out.println("S'han eliminat " + eliminades + " cobertures amb el codi postal " + codiPostal + ".");
		} else {
			System.out.println("No hi ha cap cobertura amb el codi postal " + codiPostal + ".");
		}
	}

	public static void opcio3(LlistaCobertura LlistaCob) {
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 3: Comptar quants punts de cobertura tenen una velocitat superior a 100");
		// Mostrem el resultat cridant velocitatSuperior100() de la classe LlistaCobertura
		System.out.println("El nombre de punts de cobertura amb velocitat superior a 100 és: " + LlistaCob.velocitatSuperior100());
	}

	public static void opcio4(LlistaCobertura LlistaCob) {
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 4: Mostrar les dades de la instància que té menys precisió");
		// Cridem menysPrecisio() i comprovem que hi hagi resultat (la llista pot estar buida)
		Cobertura menysPrecisa = LlistaCob.menysPrecisio();
		if (menysPrecisa != null) {
			System.out.println("La cobertura amb menys precisió és: " + menysPrecisa.toString());
		} else {
			System.out.println("No hi ha cap cobertura a la llista.");
		}
	}

	public static void opcio5(LlistaCobertura LlistaCob) {
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 5: Calcular el factor d’eficiència de la instància amb el tipus d’activitat indicat per paràmetre (TILTING o STILL), xarxa 4G i amb un nombre de satèl·lits captats superior a 13");
		// Demanem a l'usuari el tipus d'activitat a buscar
		System.out.println("Introdueix el tipus d'activitat a buscar (TILTING o STILL):");
		String activitat = teclat.nextLine();
		// Comprovem amb equalsIgnoreCase (els Strings es comparen amb equals, mai amb ==)
		if (activitat.equalsIgnoreCase("TILTING") || activitat.equalsIgnoreCase("STILL")) {
			// Cridem duplicatXarxa4G() amb l'activitat indicada i 13 satèl·lits
			Cobertura cobertura = LlistaCob.duplicatXarxa4G(activitat, 13);
			// Si hem trobat una instància, mostrem el seu factor d'eficiència; si no, un missatge
			if (cobertura != null) {
				System.out.println("El factor d'eficiència de la cobertura amb activitat " + activitat + " és: " + cobertura.factorEficiencia());
			} else {
				System.out.println("No s'ha trobat cap cobertura amb activitat " + activitat + " i xarxa 4G amb més de 13 satèl·lits.");
			}
		} else {
			System.out.println("Error, el nom de l'activitat no és correcte.");
		}
	}

	public static void opcio6(LlistaCobertura LlistaCob) {
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 6: Mostrar quants punts de cobertura tenen un factor d’eficiència per sobre de x (donat per l’usuari) en un municipi en concret (usuari indica el nom)");
		// Demanem a l'usuari el factor d'eficiència x
		System.out.println("\nIntrodueix el factor d'eficiència x:");
		int eficienciaMin = Integer.parseInt(teclat.nextLine());
		// Demanem a l'usuari el municipi a buscar
		System.out.println("Introdueix el municipi a buscar:");
		String municipi = teclat.nextLine();
		// Obtenim la subllista del municipi i, si no és buida, comptem les que superen x
		LlistaCobertura delMunicipi = LlistaCob.dadesMunicipi(municipi);
		if (delMunicipi.getElement() == 0) {
			System.out.println("No hi ha cap punt de cobertura del municipi " + municipi + ".");
		} else {
			System.out.println(delMunicipi.Eficiencia(eficienciaMin) + " cobertures del municipi " + municipi + " superen el factor d'eficiència " + eficienciaMin + ".");
		}
	}

	public static void opcio7(LlistaCobertura LlistaCob) {
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 7: Mostrar les dades de tots els punts de cobertura d’un operador indicat per paràmetre");
		// Demanem a l'usuari l'operador
		System.out.println("\nIntrodueix l'operador:");
		String operador = teclat.nextLine();
		// Obtenim la subllista de l'operador i la mostrem si no és buida
		LlistaCobertura delOperador = LlistaCob.dadesCobertura(operador);
		if (delOperador.getElement() == 0) {
			System.out.println("No hi ha cap punt de cobertura de l'operador " + operador + ".");
		} else {
			System.out.println(delOperador.toString());
		}
	}

	private static String[] llegirLiniesFitxer(int liniaIni, int liniaFi) throws FileNotFoundException {
		String[] result;
		String dada;
		int nLinies;
		if (liniaIni < 1)
			liniaIni = 1;
		if (liniaFi > 1013)
			liniaFi = 1013;
		nLinies = liniaFi - liniaIni + 1;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("Dades_Cobertura_Mobil.csv"));

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada línia és el següent:\n" + capcalera);
		// ens saltem les línies fins a la liniaIni
		for (int i = 1; i < liniaIni; i++) {
			dada = f.nextLine();
		}
		// ara anirem guardant les nLinies que sí volem llegir
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}

}