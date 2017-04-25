package fr.mowitnow.automaticmower.tools.utils;

import java.util.Queue;

import org.apache.commons.lang.math.NumberUtils;

import fr.mowitnow.automaticmower.domain.Mower;
import fr.mowitnow.automaticmower.domain.Surface;
import fr.mowitnow.automaticmower.domain.enums.CardinalNotationEnum;
import fr.mowitnow.automaticmower.domain.enums.MovementEnum;

/**
 * Classe utilitaire pour extraire l'ensemble des tondeuses automatiques d�finit
 * dans les fichiers plats.
 **/
public final class ExtractMower {

	/**
	 * Constructeur
	 */
	private ExtractMower() {
		// ne rien faire
	}

	/**
	 * R�cuperation de la surface contenant la position de l'ensembldes
	 * tondeuses apr�s extraction
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static final Surface getSurface(Queue<String> list) throws Exception {
		Surface surface = new Surface();

		// R�cuperation des dimensions de la surface
		setSurfaceDimensions(list, surface);

		// R�cuperation des dimensions de la surface
		setMowerList(list, surface);

		return surface;

	}

	/**
	 * D�finit les dimensions de la surface.
	 * 
	 * @param list
	 *            liste des lignes extraites du fichier
	 * @param surface
	 *            surface qui contenir les dimensions
	 */
	private static void setSurfaceDimensions(Queue<String> list, Surface surface) {
		String dimension = list.poll();
		String[] dimensionArray = dimension.split(" ");
		int posX = NumberUtils.toInt(dimensionArray[0]);
		int posY = NumberUtils.toInt(dimensionArray[1]);
		surface.setMaxPosX(posX);
		surface.setMaxPosY(posY);
	}

	/**
	 * D�finit la liste des tondeuses sur la surface
	 * 
	 * @param list
	 *            liste des lignes extraites du fichier
	 * @param surface
	 *            surface qui contenir les dimensions
	 * @throws Exception
	 */
	private static void setMowerList(Queue<String> list, Surface surface) throws Exception {

		while (!list.isEmpty()) {
			/*
			 * R�cuperation des deux lignes qui d�finissent la position de la
			 * tondeuse, ainsi que la liste des mouvements
			 */

			String positionLine = list.poll();
			String movementLine = list.poll();

			/* R�cuperation de la position et de la liste des mouvement */
			String[] positionArray = positionLine.split(" ");
			String[] movementArray = movementLine.split("");

			/* Cr�ation de la tondeuse */
			int posX = NumberUtils.toInt(positionArray[0]);
			int posY = NumberUtils.toInt(positionArray[1]);
			CardinalNotationEnum orientation = CardinalNotationEnum.valueOf(positionArray[2]);
			Mower newMower = new Mower(posX, posY, orientation);

			/* Ajout des mouvemement de cette tondeuse */
			for (String movementStr : movementArray) {
				MovementEnum movement = MovementEnum.valueOf(movementStr);
				MoveMower.moveMower(surface, newMower, movement);
			}

			/* Ajout a la liste des tondeuse de */
			surface.addToMowerList(newMower);
		}

	}

}
