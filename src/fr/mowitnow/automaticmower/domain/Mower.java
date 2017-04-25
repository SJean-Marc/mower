package fr.mowitnow.automaticmower.domain;

import fr.mowitnow.automaticmower.domain.enums.CardinalNotationEnum;

/**
 * Representation objet d'une tondeuse
 * 
 * @author JM
 *
 */
public class Mower {
	/* ********************************************************* */
	/* ********************************************************* */
	/* Attributs */
	/* ********************************************************* */
	/* ********************************************************* */

	/**
	 * Chaque surface doit �tre unique
	 */
	private static int commonId = 1;

	/**
	 * Identifiant unique de la surface
	 */
	private Integer id;
	/**
	 * Position d'un tondeuse sur une surface (par rapport � l'axe horizontal).
	 */
	private int posX;
	/**
	 * Position d'un tondeuse sur une surface (par rapport � l'axe vertical).
	 */
	private int posY;
	/**
	 * Orientation de la tondeuse sur la surface.
	 */
	private CardinalNotationEnum orientation;

	/* ********************************************************* */
	/* ********************************************************* */
	/* M�thodes */
	/* ********************************************************* */
	/* ********************************************************* */
	/**
	 * Constructeur
	 */
	public Mower(int posX, int posY, CardinalNotationEnum orientation) {
		this.id = commonId;
		commonId++;
		
		//Mise en place des positions
		this.posX = posX;
		this.posY = posY;
		this.orientation = orientation;
	}

	/* ********************************************************* */
	/* ********************************************************* */
	/* Accesseurs */
	/* ********************************************************* */
	/* ********************************************************* */
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX
	 *            the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY
	 *            the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the orientation
	 */
	public CardinalNotationEnum getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation
	 *            the orientation to set
	 */
	public void setOrientation(CardinalNotationEnum orientation) {
		this.orientation = orientation;
	}

}