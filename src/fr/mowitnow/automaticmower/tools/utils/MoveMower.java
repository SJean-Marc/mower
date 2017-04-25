package fr.mowitnow.automaticmower.tools.utils;

import java.util.Arrays;

import fr.mowitnow.automaticmower.domain.Mower;
import fr.mowitnow.automaticmower.domain.Surface;
import fr.mowitnow.automaticmower.domain.enums.CardinalNotationEnum;
import fr.mowitnow.automaticmower.domain.enums.MovementEnum;

/**
 * Classe utilitaire pour deplacer une tondeuse sur la surface.
 * 
 * @author JM
 *
 */
public final class MoveMower {

	/**
	 * Constructeur
	 */
	private MoveMower() {
		// ne rien faire
	}

	/**
	 * Déplace une tondeuse sur une surface.
	 * 
	 * @param surface
	 *            surface contenant liste des tondeuses
	 * @param mower
	 *            la tondeuse que l'on souhaite deplacer
	 * @param movement
	 *            rotation que l'on souhaite réaliser
	 * @throws Exception
	 */
	public static void moveMower(Surface surface, Mower mower, MovementEnum movement) throws Exception {
		// Vérification de l'existence du terrain
		if (surface == null) {
			throw new Exception("Le terrain sur lequel la tondeuse doit être déplacé est non renseigné");
		}
		// Vérification de l'existence de la tondeuse
		if (mower == null) {
			throw new Exception("La tondeuse qui doit être déplacé est non renseigné");
		}

		// Récuperation de la position actuelle de la tondeuse

		if (Arrays.asList(MovementEnum.G, MovementEnum.D).contains(movement)) {
			applyRotation(mower, movement);
		} else if (MovementEnum.A.equals(movement)) {
			applyMovement(surface, mower);
		}

	}

	/**
	 * Applique une rotation.
	 * 
	 * @param mower
	 *            la tondeuse que l'on souhaite deplacer
	 * @param movement
	 *            rotation que l'on souhaite réaliser
	 * @throws Exception
	 */
	private static void applyRotation(Mower mower, MovementEnum movement) throws Exception {
		/* Vérification sur le mouvement demandé */
		if (movement == null) {
			throw new Exception("Le mouvement demandé n'est pas reconnu");
		}
		int newMovement = MovementEnum.G.equals(movement) ? -1 : 1;
		CardinalNotationEnum newOrientation = mower.getOrientation();

		// Application de la rotation
		if (CardinalNotationEnum.N.equals(mower.getOrientation())) {
			newOrientation = newMovement > 0 ? CardinalNotationEnum.E : CardinalNotationEnum.W;
		} else if (CardinalNotationEnum.S.equals(mower.getOrientation())) {
			newOrientation = newMovement > 0 ? CardinalNotationEnum.W : CardinalNotationEnum.E;
		} else if (CardinalNotationEnum.W.equals(mower.getOrientation())) {
			newOrientation = newMovement > 0 ? CardinalNotationEnum.N : CardinalNotationEnum.S;
		} else if (CardinalNotationEnum.E.equals(mower.getOrientation())) {
			newOrientation = newMovement > 0 ? CardinalNotationEnum.S : CardinalNotationEnum.N;
		}

		// Mise à jour de la nouvelle orientation
		mower.setOrientation(newOrientation);
	}

	/**
	 * Applique un mouvement en fonction de l'orientation de la tondeuse.
	 * 
	 * @param surface
	 *            surface contenant les tondeuses
	 * @param mower
	 *            la tondeuse que l'on souhaite deplacer
	 */
	private static void applyMovement(Surface surface, Mower mower) {

		if (CardinalNotationEnum.N.equals(mower.getOrientation())) {
			moveUp(surface, mower);
		} else if (CardinalNotationEnum.S.equals(mower.getOrientation())) {
			moveDown(mower);
		} else if (CardinalNotationEnum.W.equals(mower.getOrientation())) {
			moveLeft(mower);
		} else if (CardinalNotationEnum.E.equals(mower.getOrientation())) {
			moveRight(surface, mower);
		}
	}

	/**
	 * Déplacer une tondeuse vers l sur une surface.
	 * 
	 * @param surface
	 *            surface contenant les tondeuses
	 * @param mower
	 *            la tondeuse que l'on souhaite deplacer
	 */
	private static void moveUp(Surface surface, Mower mower) {
		int posY = mower.getPosY();

		if (posY == surface.getMaxPosY()) {
			// Ne rien faire
		} else {
			mower.setPosY(posY + 1);
		}
	}

	/**
	 * Déplacer une tondeuse vers le bas sur une surface.
	 * 
	 * @param mower
	 *            la tondeuse que l'on souhaite deplacer
	 */
	private static void moveDown(Mower mower) {
		int posY = mower.getPosY();

		if (posY == Surface.MIN_POS_Y) {
			// Ne rien faire
		} else {
			mower.setPosY(posY - 1);
		}
	}

	/**
	 * Déplacer une tondeuse vers la gauche sur une surface.
	 * 
	 * @param mower
	 *            la tondeuse que l'on souhaite deplacer
	 */
	private static void moveLeft(Mower mower) {
		int posX = mower.getPosX();

		if (posX == Surface.MIN_POS_X) {
			// Ne rien faire
		} else {
			mower.setPosX(posX - 1);
		}
	}

	/**
	 * Déplacer une tondeuse vers la droite sur une surface.
	 * 
	 * @param surface
	 *            surface contenant les tondeuses
	 * @param mower
	 *            la tondeuse que l'on souhaite deplacer
	 */
	private static void moveRight(Surface surface, Mower mower) {
		int posX = mower.getPosX();

		if (posX == surface.getMaxPosX()) {
			// Ne rien faire
		} else {
			mower.setPosX(posX + 1);
		}
	}
}
