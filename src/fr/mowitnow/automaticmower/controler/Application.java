package fr.mowitnow.automaticmower.controler;

import java.util.Queue;

import fr.mowitnow.automaticmower.tools.helper.CheckMowerFileHelper;
import fr.mowitnow.automaticmower.tools.helper.FileHelper;
import fr.mowitnow.automaticmower.tools.helper.MowerLogger;

/**
 * Controleur pour les fonctions m�tiers de l'application
 * 
 * @author JM
 *
 */
public class Application {

	/**
	 * Fonction qui � partir d'un fichier d'entr� valide va executer des
	 * d�placements sur une surface avec des tondeuses
	 * 
	 * @param path
	 *            chemin vers le fichier.
	 */
	public static void startMowerApplication(String path) {
		
		try {
			// Ouverture du fichier
			FileHelper fileHelper = new FileHelper(path);
			
			/*R�cuperation de la liste des lignes extraites*/
			Queue<String> extractedLineList = fileHelper.getLineList();
	
			/*V�rification que les lignes soient valides*/
			CheckMowerFileHelper checkFile = new CheckMowerFileHelper(extractedLineList);
			
			/*Construit la liste tondeuse depuis les lignes*/
			if(checkFile.isValidFile()){
				
			}
			
		} catch (Exception e) {
			MowerLogger.addTextLog(e.getMessage());
		}

	}
}
