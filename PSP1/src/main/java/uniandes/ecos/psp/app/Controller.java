package uniandes.ecos.psp.app;

import java.io.File;
import java.util.ArrayList;

public class Controller {

	/**
	 * Instancia que representa el modelo
	 */
	private Model model;

	/**
	 * Instancia que representa la vista
	 */
	private View view;

	/**
	 * Listado de elementos
	 */
	private ArrayList<FileInfo> list;

	/**
	 * Constructor por defecto
	 * 
	 * @param view
	 *            Vista para pintar el modelo
	 */
	public Controller(View view) {
		this.view = view;
		this.model = new Model();
	}

	/**
	 * Carga los datos desde un archivo de texto o directori
	 * 
	 * @param pathname
	 *            Ruta de la carpeta principal o de un archivo
	 */
	public void listFilesForFolder(String pathname) {

		list = new ArrayList<FileInfo>();

		try {
			File folder = new File(pathname);
			for (File file : folder.listFiles()) {
				if (file.isDirectory()) {
					listFilesForFolder(file.getPath());
				} else {
					list.add(model.evaluate(file));
				}
			}			
		} catch (Exception ex) {
			String error = String.format("Error reading files Exception: %1$s",
					ex.getMessage());
			view.printError(error);
		}

	}

	/**
	 * Organiza los datos para presentarlos en la vista
	 */
	public void processData() {
		if (list != null && list.size() > 0) {
			int totalItems = 0;
			int totalSize = 0;
			StringBuilder builder = new StringBuilder();
			for (FileInfo file : list) {
				builder.append(String.format(
						"Name: %1s Number of Item: %2s Size: %3s",
						file.getName(), file.getItems(), file.getSize()));
				builder.append("\n");

				totalItems += file.getItems();
				totalSize += file.getSize();
			}
			builder.append(String.format("Total Items: %1d Total Size: %2d\n",
					totalItems, totalSize));

			view.printMessage(builder.toString());
		} else {
			view.printError("No files");
		}

	}

}
