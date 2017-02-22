package uniandes.ecos.psp.app;

/**
 * Representa los atributos de un archivo sobre el cual se cuentan lineas de
 * codigo
 * 
 * @author afmape
 * 
 */
public class FileInfo {
	/**
	 * Nombre del archivo
	 */
	private String name;
	/**
	 * Cantidad de metodos en el archivo
	 */
	private int items;
	/**
	 * Numero de lineas funcionales
	 */
	private int size;

	/**
	 * Constructor por defecto
	 * 
	 * @param name
	 *            Nombre del archivo
	 * @param items
	 *            Numero de metodos
	 * @param size
	 *            Numero de lineas funcionales
	 */
	public FileInfo(String name, int items, int size) {
		this.name = name;
		this.items = items;
		this.size = size;
	}

	/**
	 * Retorna el nombre
	 * 
	 * @return Nombre del archivo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retorna el numero de metodos
	 * 
	 * @return Numero de metodos
	 */
	public int getItems() {
		return items;
	}

	/**
	 * Retorna el numero de lineas funcionales
	 * 
	 * @return Numero de lineas funcionales
	 */
	public int getSize() {
		return size;
	}

}
