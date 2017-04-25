package fr.mowitnow.automaticmower.tools.helper;

import java.util.Queue;

import org.apache.commons.lang.StringUtils;

/**
 * Classe utilitaire pour vérifier que le fichier est correctement formaté pour
 * l'extraction des tondeuses sur une surface.
 * 
 * @author JM
 *
 */
public final class CheckMowerFileHelper {

	/**
	 * Regex sur la vérification du fichier
	 */
	String IS_LETTER = "[a-zA-Z]+";
	String IS_NUMBER = "[0-9]";

	/**
	 * Boolean indiquant si le fichier est valide
	 */
	private boolean isValidFile;

	/**
	 * Constructeur
	 * 
	 * @param list
	 *            liste des lignes extraites du fichier
	 */
	public CheckMowerFileHelper(Queue<String> list) {
		// Vérifie que le fichier dispose bien d'une ligne pour définir le coin
		// supérieur droit d'une surface
		isValidFile = true;
		try {
			/* Vérifie que la premier ligne est valide */
			hasValidHeaderLine(list);

			/*
			 * Vérifie que les lignes sur les données des tondeuses est valides
			 */
			hasValidBodyLine(list);

		} catch (Exception e) {
			MowerLogger.addTextLog(e.getMessage());
			isValidFile = false;
		}

	}

	/**
	 * Fait une vérification sur la 1er ligne du fichier qui permet de définir
	 * les dimensions de la surface
	 * 
	 * @param list
	 *            liste des lignes extraites du fichier uploadé
	 * @throws Exception
	 */
	private void hasValidHeaderLine(Queue<String> list) throws Exception {
		// Variable pour faire le traitement
		boolean isValid = false;
		String element = list.peek();

		// Fait la vérification sur la ligne extraite du fichier
		if (StringUtils.isNotBlank(element)) {
			String[] tabs = element.split(" ");
			isValid = tabs[0].matches(IS_NUMBER) && tabs[1].matches(IS_NUMBER);
		}
		if (!isValid) {
			throw new Exception("Une erreur lors dans la 1er ligne du fichier");
		}

	}

	/**
	 * Vérifie que les lignes decrivant les informations des tondeuses soient
	 * valides
	 * 
	 * @param list
	 *            liste des lignes extraite du fichier.
	 * @throws Exception
	 */
	private void hasValidBodyLine(Queue<String> list) throws Exception {
		int cpt = 0;

		// Parcours la liste des lignes, on traite toute les lignes sauf la 1er
		// ligne
		// qui indique les dimensions de la surface
		for (String element : list) {
			// Traite toute les lignes sauf la 1er
			if (cpt > 0) {
				if (!checkBodyLineIsValid(cpt, element)) {
					throw new Exception("Une erreur dans une ligne de fichier");
				}
			}
			cpt++;
		}
	}

	/**
	 * Vérifie que la ligne est valide
	 * 
	 * @param cpt
	 *            compteur permettant de savoir si on a faire a ligne contenant
	 *            la position d'une tondeuse ou la liste des mouvements.
	 * @param element
	 *            la ligne extraite du fichier
	 * @return
	 */
	private boolean checkBodyLineIsValid(int cpt, String element) {
		boolean isValid = false;
		if ((cpt + 1) % 2 == 0) {
			String[] tabs = element.split(" ");
			if (tabs.length == 3) {
				// Le 1er, le 2e sont des numéros et le 3e est une
				// lettre
				isValid = tabs[0].matches(IS_NUMBER) && tabs[1].matches(IS_NUMBER) && tabs[2].matches(IS_LETTER);
			}

		} else {
			isValid = element.matches(IS_LETTER);
		}

		return isValid;
	}

	/**
	 * Renvoie la valeur du boolean indiquant si le fichier est valide
	 * 
	 * @return boolean indiquant si le fichier est valide
	 */
	public boolean isValidFile() {
		return isValidFile;
	}

}
