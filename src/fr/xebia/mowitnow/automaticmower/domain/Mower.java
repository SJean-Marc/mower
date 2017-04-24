package fr.xebia.mowitnow.automaticmower.domain;

import fr.xebia.mowitnow.automaticmower.domain.enums.CardinalNotationEnum;

/**
 * Representation objet d'une tondeuse
 * @author JM
 *
 */
public class Mower {
	/* ********************************************************* */
	/* ********************************************************* */
	/* 						Attributs							 */
	/* ********************************************************* */	
	/* ********************************************************* */	
	
	/**
	 * Chaque surface doit être unique
	 */
	private static int commonId = 1;

	/**
	 * Identifiant unique de la surface
	 */
	private Integer id;
	/**
	 * Position d'un tondeuse sur une surface (par rapport à l'axe horizontal).
	 */
	private int posX;
	/**
	 * Position d'un tondeuse sur une surface (par rapport à l'axe vertical).
	 */
	private int posY;
	/**
	 * Orientation de la tondeuse sur la surface.
	 */
	private CardinalNotationEnum orientation;
	
	/* ********************************************************* */
	/* ********************************************************* */
	/* 						Méthodes							 */
	/* ********************************************************* */	
	/* ********************************************************* */	
	/**
	 * Constructeur
	 */
	public Mower() {
		this.id = commonId;
		commonId++;
	}
	
	/* ********************************************************* */
	/* ********************************************************* */
	/* 						Accesseurs							 */
	/* ********************************************************* */	
	/* ********************************************************* */	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param posX the posX to set
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
	 * @param posY the posY to set
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
	 * @param orientation the orientation to set
	 */
	public void setOrientation(CardinalNotationEnum orientation) {
		this.orientation = orientation;
	}
	
	

}