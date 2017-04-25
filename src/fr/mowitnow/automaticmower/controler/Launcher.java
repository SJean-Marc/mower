package fr.mowitnow.automaticmower.controler;

import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

/**
 * Classe qui demarre l'application et réalise l'ensemble des appels pour le
 * traitement.
 * 
 * @author JM
 *
 */
public class Launcher {

	/**
	 * Fonction main qui demarre le programme
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		start();
	}

	public static void start() {
		/* Récuperation du fichier par lecture */
		Scanner sc = new Scanner(System.in);
		System.out.println("Merci de saisir le chemin vers le fichier:");
		String path = null;
		while (sc.hasNextLine()) {
			path = sc.nextLine();
		}

		/* Vérifie que le fichier est correcte,si oui demarre le processus */
		if (StringUtils.isNotBlank(path)) {

		}
	}

}
