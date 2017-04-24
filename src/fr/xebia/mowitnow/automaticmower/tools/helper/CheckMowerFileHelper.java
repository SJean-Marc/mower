package fr.xebia.mowitnow.automaticmower.tools.helper;

import java.util.Queue;

import org.apache.commons.lang.StringUtils;

public final class CheckMowerFileHelper {

	String ONLY_TWO_NUMBER = "[0-9]{2}";
	String IS_LETTER = "[a-zA-Z]+";
	String IS_NUMBER = "[0-9]";
	private boolean isValidFile;

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

	private void hasValidHeaderLine(Queue<String> list) throws Exception {
		boolean isValid = false;
		String element = list.peek();
		if (StringUtils.isNotBlank(element)) {
			isValid = element.matches(ONLY_TWO_NUMBER);
		}
		if (!isValid) {
			throw new Exception("Une erreur lors dans la 1er ligne du fichier");
		}

	}

	private void hasValidBodyLine(Queue<String> list) throws Exception {
		int cpt = 0;
		
		for (String element : list) {
			
			if (cpt > 0) {
				boolean isValid = false;
				
				if ((cpt + 1) % 2 == 0) {
					String[] tabs = element.split(" ");
					if (tabs.length == 3) {
						// Le 1er, le 2e sont des numéros et le 3e est une
						// lettre
						isValid = tabs[0].matches(IS_NUMBER) && tabs[1].matches(IS_NUMBER)
								&& tabs[2].matches(IS_LETTER);
					}

				} else {
					isValid = element.matches(IS_LETTER);
				}

				if (!isValid) {
					throw new Exception("Une erreur dans une ligne de fichier");
				}
			}
			cpt++;
		}
	}

	/**
	 * @return the isValidFile
	 */
	public boolean isValidFile() {
		return isValidFile;
	}


}
