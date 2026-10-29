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

		// Mostrem el contingut que hem llegit.
		for (int i = 0; i < dataset.length; i++) {
			System.out.println("Linia " + (i + 1) + " conté " + dataset[i]);
		}

		
		// Creem una instància de LlistaCobertura amb la mida del dataset
		LlistaCobertura LlistaCob = new LlistaCobertura (dataset.length);
		// recorrem el dataset
		for (int i = 0; i < dataset.length; i++){
			// Utlitzem la funció split per a que separe la informació en cada línia del dataset 
			String[] dades = dataset[i].split(";");
			// Creem una altra instància de Cobertura amb les dades separades
			Cobertura Cob = new Cobertura(dades[0], dades[1], Integer.parseInt(dades[2]), Integer.parseInt(dades[3]), Integer.parseInt(dades[4]), dades[5], Integer.parseInt(dades[6]), dades[7]);
			// Afegim la anterior instància de cobertura a la llistaCobertura
			LlistaCob.afegirCobertura(Cob);
		}
		

		// MENÚ


		// 1. Mostrar el menú amb el contingut de la llista de cobertures

		mostrarMenu();

		// 2. Mentre l'usuari no indiqui sortir del programa (amb el 8), anirem mostrant el menú i demanant una opció

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

	public static void opcio2 (LlistaCobertura LlistaCob) {
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 2: Eliminar el conjunt de dades que són d’un cert codi postal");
		// Demanem a l'usuari el codi postal a eliminar
		System.out.println("Introdueix el codi postal a eliminar:");
		int codiPostal = Integer.parseInt(teclat.nextLine());
		// Eliminem les cobertures amb el codi postal indicat anteriorment
		LlistaCob.eliminar(codiPostal);
	}

	public static void opcio3 (LlistaCobertura LlistaCob){
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 3: Comptar quants punts de cobertura tenen una velocitat superior a 100");
		// Mostrem el resultat a l'usuari cridant la funció velocitatSuperior100() de la classe LlistaCobertura
		System.out.println("El nombre de punts de cobertura amb velocitat superior a 100 és: " + LlistaCob.velocitatSuperior100());
	}

	public static void opcio4 (LlistaCobertura LlistaCob){
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 4: Mostrar les dades de la instància que té menys precisió");
		// Mostrem el resultat a l'usuari cridant la funció menysPrecisio() de la classe LlistaCobertura i cridem també al toString perquè mostri per pantalla les dades de la instància trobada
		System.out.println("La cobertura amb menys precisió és: " + LlistaCob.menysPrecisio().toString());
	}

	public static void opcio5 (LlistaCobertura LlistaCob){
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 5: Calcular el factor d’eficiència de la instància amb el tipus d’activitat indicat per paràmetre (TILTING o STILL), xarxa 4G i amb un nombre de satèl·lits captats superior a 13");
		// Demanem a l'usuari el tipus d'activitat a buscar
		System.out.println("Introdueix el tipus d'activitat a buscar (TILTING o STILL):");
		String activitat = teclat.nextLine();
		// Comprovem que l'usuari ha introduït bé el tipus d'activitat que busca
		if (activitat == "TILTING" || activitat == "STILL"){
			// Cridem la funció duplicatXarxa4G() de la classe LlistaCobertura amb els paràmetres indicats i guardem el resultat en una variable
			Cobertura cobertura = LlistaCob.duplicatXarxa4G(activitat, 13);
			// Mostrem el resultat a l'usuari cridant la funció factorEficiencia() de la classe Cobertura sobre la instància trobada. Si no s'ha trobat cap instància, mostrem un missatge indicant-ho
			if (cobertura != null){
				System.out.println("El factor d'eficiència de la cobertura amb activitat " + activitat + " és: " + cobertura.factorEficiencia());
			} else {
				System.out.println("No s'ha trobat cap cobertura amb activitat " + activitat + " i xarxa 4G amb més de 13 satèl·lits.");
			}
		}
		else{
			System.out.println("Error, el nom de l'activitat no és correcte.");
		}
		
	}

	public static void opcio6 (LlistaCobertura LlistaCob){
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 6: Mostrar quants punts de cobertura tenen un factor d’eficiència per sobre de x (donat per l’usuari) en un municipi en concret (usuari indica el nom)");
		// Demanem a l'usuari el factor d'eficiència a buscar
		System.out.println("\nIntrodueix el factor d'eficiència a buscar:");
		int eficienciaMin = Integer.parseInt(teclat.nextLine());
		// Demanem a l'usuari el municipi a buscar
		System.out.println("Introdueix el municipi a buscar:");
		String municipi = teclat.nextLine();// Mostrem el número de instàncies que compleixen les condicions donades
		//Cridem la funció que retorna una subllista de les cobetures d'un cert municipi, i cridem des d'aquesta subllsita a la funció que calcula el nombre d'instàncies que superen o igualen una eficiència mínima 
		System.out.println(LlistaCob.dadesMunicipi(municipi).Eficiencia(eficienciaMin) + " cobertures superen l'eficiència mínima indicada i pertanyen al municipi indicat");
	}

	public static void opcio7 (LlistaCobertura LlistaCob){
		// Informem a l'usuari quina opció ha triat
		System.out.println("\n\nOpció 7: Mostrar les dades de tots els punts de cobertura d’un operador indicat per paràmetre");
		// Demanem a l'usuari l'operador que es passarà per paràmetre
		System.out.println("\nIntrodueix l'operador:");
		String operador = teclat.nextLine();
		// Mostrem les dades de les instàncies amb la funció toString, de la llista que retorna la funció dadesCobertura (llista amb les instàncies d'una certa cobertura)
		System.out.println(LlistaCob.dadesCobertura(operador).toString());
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