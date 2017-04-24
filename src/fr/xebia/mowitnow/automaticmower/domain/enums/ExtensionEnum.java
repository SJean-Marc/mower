package fr.xebia.mowitnow.automaticmower.domain.enums;

/**
 * Ensemble des extensions autoris�s dans l'application.
 * 
 * @author JM
 *
 */
public enum ExtensionEnum {
	TXT("txt"), CSV("csv");
	
	/**
	 * Chaque extension dispose d'un libell� qui d�finit 
	 */
	private final String label;

	private ExtensionEnum(String label) {
		this.label = label;
	}
	
	/**
	 * R�cuperation du libell� associ� � un enum
	 * @return
	 */
	public String getLabel(){
		return label;
	}
}
