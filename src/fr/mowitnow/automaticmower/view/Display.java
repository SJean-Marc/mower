package fr.mowitnow.automaticmower.view;

import java.util.List;

import fr.mowitnow.automaticmower.domain.Mower;
import fr.mowitnow.automaticmower.domain.Surface;

/**
 * Classe pour l'affichage des données.
 * 
 * @author JM
 *
 */
public final class Display {

	/**
	 * Constructeur
	 */
	private Display() {
		// ne rien faire 
	}
	
	/**
	 * Fonction pour afficher la position des tondeuses sur la surface.
	 * 
	 * @param surface
	 *            surface contenant une liste de tondeuse que l'on souhaite
	 *            afficher
	 */
	public static void displayOnScreen(Surface surface) {
		// Affichage de la delimitation avec le précédant message
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("Positions finales");

		// Récuperation de la liste des tondeuses
		List<Mower> mowerList = surface.getMowerList();

		// Affichage de la liste des tondeuses
		for (Mower mower : mowerList) {
			System.out.println(mower);
		}
	}

}
