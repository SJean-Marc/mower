package fr.mowitnow.automaticmower.controler;

import java.util.Queue;

import fr.mowitnow.automaticmower.domain.Surface;
import fr.mowitnow.automaticmower.tools.helper.CheckMowerFileHelper;
import fr.mowitnow.automaticmower.tools.helper.FileHelper;
import fr.mowitnow.automaticmower.tools.helper.MowerLogger;
import fr.mowitnow.automaticmower.tools.utils.ExtractMower;
import fr.mowitnow.automaticmower.view.Display;

/**
 * Controleur pour les fonctions métiers de l'application
 * 
 * @author JM
 *
 */
public class Application {

	/**
	 * Constructeur
	 */
	private Application() {
		// ne rien faire
	}

	/**
	 * Fonction qui à partir d'un fichier d'entré valide va executer des
	 * déplacements sur une surface avec des tondeuses
	 * 
	 * @param path
	 *            chemin vers le fichier.
	 */
	public static void startMowerApplication(String path) {

		try {
			// Ouverture du fichier
			FileHelper fileHelper = new FileHelper(path);

			/* Récuperation de la liste des lignes extraites */
			Queue<String> extractedLineList = fileHelper.getLineList();

			/* Vérification que les lignes soient valides */
			CheckMowerFileHelper checkFile = new CheckMowerFileHelper(extractedLineList);

			/* Construit la liste tondeuse depuis les lignes */
			if (checkFile.isValidFile()) {
				Surface surface = ExtractMower.getSurface(extractedLineList);
				Display.displayOnScreen(surface);
			}

		} catch (Exception e) {
			System.out.println("Une erreur a eu lieu dans l'extraction des tondeuses");
			MowerLogger.addTextLog(e.getMessage());
		}

	}
}
