package fr.mowitnow.automaticmower.tools.utils;

import java.util.Arrays;

import fr.mowitnow.automaticmower.domain.Mower;
import fr.mowitnow.automaticmower.domain.Surface;
import fr.mowitnow.automaticmower.domain.enums.CardinalNotationEnum;
import fr.mowitnow.automaticmower.domain.enums.MovementEnum;

public final class MoveMower {

	public static void moveMower(Surface surface, Mower mower, MovementEnum movement) throws Exception {
		// V�rification de l'existence du terrain
		if (surface == null) {
			throw new Exception("Le terrain sur lequel la tondeuse doit �tre d�plac� est non renseign�");
		}
		// V�rification de l'existence de la tondeuse
		if (mower == null) {
			throw new Exception("La tondeuse qui doit �tre d�plac� est non renseign�");
		}

		// R�cuperation de la position actuelle de la tondeuse

		if (Arrays.asList(MovementEnum.G, MovementEnum.D).contains(movement)) {
			applyRotation(mower, movement);
		} else if (MovementEnum.A.equals(movement)) {
			applyMovement(surface, mower);
		}

	}

	private static void applyRotation(Mower mower, MovementEnum movement) throws Exception {
		/* V�rification sur le mouvement demand� */
		if (movement == null) {
			throw new Exception("Le mouvement demand� n'est pas reconnu");
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

		// Mise � jour de la nouvelle orientation
		mower.setOrientation(newOrientation);
	}

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

	private static void moveUp(Surface surface, Mower mower) {
		int posY = mower.getPosY();

		if (posY == surface.getMaxPosY()) {
			// Ne rien faire
		} else {
			mower.setPosY(posY + 1);
		}
	}

	private static void moveDown(Mower mower) {
		int posY = mower.getPosY();

		if (posY == Surface.MIN_POS_Y) {
			// Ne rien faire
		} else {
			mower.setPosY(posY - 1);
		}
	}

	private static void moveLeft(Mower mower) {
		int posX = mower.getPosX();

		if (posX == Surface.MIN_POS_X) {
			// Ne rien faire
		} else {
			mower.setPosX(posX - 1);
		}
	}

	private static void moveRight(Surface surface, Mower mower) {
		int posX = mower.getPosX();

		if (posX == surface.getMaxPosX()) {
			// Ne rien faire
		} else {
			mower.setPosX(posX + 1);
		}
	}
}
