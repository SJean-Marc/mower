package fr.mowitnow.automaticmower.domain.enums;

/**
 * Ensemble des mouvements possible par la tondeuse.
 * 
 * "D" et "G" font pivoter la tondeuse de 90� � droite ou � gauche
 * respectivement, sans la d�placer. "A" signifie que l'on avance la tondeuse
 * d'une case dans la direction � laquelle elle fait face.
 * 
 * @author JM
 *
 */
public enum MovementEnum {
	D, G, A;
}
