package fr.mowitnow.automaticmower.tools.helper;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;

import fr.mowitnow.automaticmower.domain.enums.ExtensionEnum;

/**
 * Classe utilitaire centralisant l'ensemble des fonction pour r�aliser des
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
	 * V�rifie que le fichier peut �tre ouvert
	 * 
	 * @throws Exception
	 */
	private void canOpenFile() throws Exception {
		// Ouverture du fichier
		Path path = Paths.get(fileName);
		// Pour ne pas suivre les liens symboliques
		if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			throw new Exception("Le fichier n'est pas trouv�");
		}
	}

	/**
	 * V�rifie que le fichier a une extension autoris�.
	 * 
	 * @throws Exception
	 */
	private void hasValidExtension() throws Exception {
		/* R�cuperation de l'extension du fichier */
		String fileExtension = FilenameUtils.getExtension(fileName);

		/* V�rification que l'extension du fichier est autoris� */
		boolean isValidExtension = false;
		for (ExtensionEnum extension : ExtensionEnum.values()) {
			if (extension.getLabel().equals(fileExtension)) {
				isValidExtension = true;
			}
		}

		/* Si l'extension n'est pas autoris� on renvoie une exception */
		if (!isValidExtension) {
			throw new Exception("Le fichier dispose d'un extension non autoris�");
		}

	}

	/**
	 * V�rifie qu'un fichier est valid avant de faire des traitement dessus.
	 * 
	 * @throws Exception
	 */
	private void checkValidFile() throws Exception {
		// V�rifie que le fichier peut �tre ouvert
		canOpenFile();

		// V�rifie que l'extension est valide
		hasValidExtension();

	}

	/**
	 * R�cuperation de la liste des lignes dans le fichier.
	 * 
	 * @return retourne la liste des lignes contenu dans le fichier
	 * @throws Exception 
	 */
	public Queue<String> getLineList() throws Exception {
		/* V�rification sur le fichier transmis */
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
