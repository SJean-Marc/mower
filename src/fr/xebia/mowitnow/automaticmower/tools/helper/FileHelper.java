package fr.xebia.mowitnow.automaticmower.tools.helper;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;

import fr.xebia.mowitnow.automaticmower.domain.enums.ExtensionEnum;

/**
 * Classe utilitaire centralisant l'ensemble des fonction pour réaliser des
 * traitement sur un fichier.
 * 
 * @author JM
 *
 */
public final class FileHelper {

	/**
	 * Nom du fichier complet avec l
	 */
	private String fileName;

	public FileHelper(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Vérifie que le fichier peut être ouvert
	 * 
	 * @throws Exception
	 */
	private void canOpenFile() throws Exception {
		// Ouverture du fichier
		Path path = Paths.get(fileName);
		// Pour ne pas suivre les liens symboliques
		if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			throw new Exception("Le fichier n'est pas trouvé");
		}
	}

	/**
	 * Vérifie que le fichier a une extension autorisé.
	 * 
	 * @throws Exception
	 */
	private void hasValidExtension() throws Exception {
		/* Récuperation de l'extension du fichier */
		String fileExtension = FilenameUtils.getExtension(fileName);

		/* Vérification que l'extension du fichier est autorisé */
		boolean isValidExtension = false;
		for (ExtensionEnum extension : ExtensionEnum.values()) {
			if (extension.getLabel().equals(fileExtension)) {
				isValidExtension = true;
			}
		}

		/* Si l'extension n'est pas autorisé on renvoie une exception */
		if (!isValidExtension) {
			throw new Exception("Le fichier dispose d'un extension non autorisé");
		}

	}

	/**
	 * Vérifie qu'un fichier est valid avant de faire des traitement dessus.
	 * 
	 * @throws Exception
	 */
	private void checkValidFile() throws Exception {
		// Vérifie que le fichier peut être ouvert
		canOpenFile();

		// Vérifie que l'extension est valide
		hasValidExtension();

	}

	/**
	 * Récuperation de la liste des lignes dans le fichier.
	 * 
	 * @return retourne la liste des lignes contenu dans le fichier
	 * @throws Exception 
	 */
	public Queue<String> getLineList() throws Exception {
		/* Vérification sur le fichier transmis */
		checkValidFile();

		/* Liste des lignes */
		Queue<String> lineQueue = new LinkedList<>();

		/* Ouverture du fichier */
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(lineQueue::add);
		}

		return lineQueue;
	}
}
