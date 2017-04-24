package fr.xebia.mowitnow.automaticmower.domain;

/**
 * Representation objet d'une surface.
 * 
 * @author JM
 *
 */
public class Surface {
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
	 * Position du coin haut supérieur droit
	 */
	private Integer maxPosX;
	private Integer maxPosY;
	
	/**
	 * Position du coin bas inférieur gauche
	 */
	public static final Integer MIN_POS_X = 0;
	public static final Integer MIN_POS_Y = 0;
	/* ********************************************************* */
	/* ********************************************************* */
	/* 						Méthodes							 */
	/* ********************************************************* */	
	/* ********************************************************* */	
	/**
	 * Constructeur
	 */
	public Surface() {
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
	 * @param maxPosX the maxPosX to set
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
	 * @param maxPosY the maxPosY to set
	 */
	public void setMaxPosY(Integer maxPosY) {
		this.maxPosY = maxPosY;
	}


}
