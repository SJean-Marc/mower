package fr.mowitnow.automaticmower.domain.enums;

/**
 * Ensemble des extensions autorisés dans l'application.
 * 
 * @author JM
 *
 */
public enum ExtensionEnum {
	TXT("txt"), CSV("csv");
	
	/**
	 * Chaque extension dispose d'un libellé qui définit 
	 */
	private final String label;

	private ExtensionEnum(String label) {
		this.label = label;
	}
	
	/**
	 * Récuperation du libellé associé à un enum
	 * @return
	 */
	public String getLabel(){
		return label;
	}
}
