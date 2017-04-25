package fr.mowitnow.automaticmower.tools.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	private static File file;

	/**
	 * Constructeur
	 */
	private MowerLogger() {
		file = new File("log.txt");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Erreur lors de la création du log");
			}
		}
	}

	/**
	 * Récuperation de l'unique instance du fichier
	 * 
	 * @return
	 */
	public static MowerLogger getInstance() {
		return instance;
	}

	/**
	 * Ajout du texte dans le log
	 * 
	 * @param text
	 *            le texte à ajouter
	 */
	public static void addTextLog(String text) {
		try (FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(text);
		} catch (IOException e) {
			System.out.println("Une erreur dans le systeme de log");
		}
	}
}
