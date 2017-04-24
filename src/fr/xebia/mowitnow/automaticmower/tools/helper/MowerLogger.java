package fr.xebia.mowitnow.automaticmower.tools.helper;

import java.io.File;
import java.io.IOException;

/**
 * Classe qui gère les logs
 * 
 * @author JM
 *
 */
public final class MowerLogger {
	
	/**
	 * Instance du logger
	 */
	private static final MowerLogger instance = new MowerLogger();
	private static final File file = new File("log.txt");

	private MowerLogger(){
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Erreur lors de la création du log");
			}
		}
	}

	public static MowerLogger getInstance() {
		return instance;
	}
}
