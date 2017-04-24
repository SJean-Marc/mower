package fr.xebia.mowitnow.automaticmower.domain.enums;

/**
 * Ensemble des mouvements possible par la tondeuse.
 * 
 * "D" et "G" font pivoter la tondeuse de 90° à droite ou à gauche
 * respectivement, sans la déplacer. "A" signifie que l'on avance la tondeuse
 * d'une case dans la direction à laquelle elle fait face.
 * 
 * @author JM
 *
 */
public enum MovementEnum {
	D, G, A;
}
