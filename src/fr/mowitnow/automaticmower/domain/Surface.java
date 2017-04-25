package fr.mowitnow.automaticmower.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation objet d'une surface.
 * 
 * @author JM
 *
 */
public class Surface {
	/* ********************************************************* */
	/* ********************************************************* */
	/* Attributs */
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
	 * Position du coin haut supérieur droit
	 */
	private Integer maxPosX;
	private Integer maxPosY;

	/**
	 * Position du coin bas inférieur gauche
	 */
	public static final Integer MIN_POS_X = 0;
	public static final Integer MIN_POS_Y = 0;

	/**
	 * Liste des tondeuses
	 */
	private List<Mower> mowerList;

	/* ********************************************************* */
	/* ********************************************************* */
	/* Méthodes */
	/* ********************************************************* */
	/* ********************************************************* */
	/**
	 * Constructeur
	 */
	public Surface() {
		this.id = commonId;
		commonId++;
		mowerList = new ArrayList<>();
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
	 * @return the maxPosX
	 */
	public Integer getMaxPosX() {
		return maxPosX;
	}

	/**
	 * @param maxPosX
	 *            the maxPosX to set
	 */
	public void setMaxPosX(Integer maxPosX) {
		this.maxPosX = maxPosX;
	}

	/**
	 * @return the maxPosY
	 */
	public Integer getMaxPosY() {
		return maxPosY;
	}

	/**
	 * @param maxPosY
	 *            the maxPosY to set
	 */
	public void setMaxPosY(Integer maxPosY) {
		this.maxPosY = maxPosY;
	}

	/**
	 * @return the mowerList
	 */
	public List<Mower> getMowerList() {
		return mowerList;
	}

	/**
	 * @param mowerList
	 *            the mowerList to set
	 */
	public void setMowerList(List<Mower> mowerList) {
		this.mowerList = mowerList;
	}

	/**
	 * Ajout d'une tondeuse à la liste des tondeuse de la surface
	 * 
	 * @param mower
	 *            tondeuse à ajouter
	 */
	public void addToMowerList(Mower mower) {
		this.mowerList.add(mower);
	}

}
