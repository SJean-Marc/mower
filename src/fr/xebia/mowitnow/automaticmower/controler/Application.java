package fr.xebia.mowitnow.automaticmower.controler;

import java.util.Queue;

import fr.xebia.mowitnow.automaticmower.tools.helper.CheckMowerFileHelper;
import fr.xebia.mowitnow.automaticmower.tools.helper.FileHelper;
import fr.xebia.mowitnow.automaticmower.tools.helper.MowerLogger;

/**
 * Controleur pour les fonctions métiers de l'application
 * 
 * @author JM
 *
 */
public class Application {

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
			
			/*Récuperation de la liste des lignes extraites*/
			Queue<String> extractedLineList = fileHelper.getLineList();
	
			/*Vérification que les lignes soient valides*/
			CheckMowerFileHelper checkFile = new CheckMowerFileHelper(extractedLineList);
			
			/*Construit la liste tondeuse depuis les lignes*/
			if(checkFile.isValidFile()){
				
			}
			
		} catch (Exception e) {
			MowerLogger.addTextLog(e.getMessage());
		}

	}
}
