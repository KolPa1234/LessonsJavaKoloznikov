package Zadachki.CopyFile;

public class Main {
    public static final String FILE_PATH = "C:\\Users\\admin\\Desktop\\new_folder\\DZ_5.jpg"; //Прописываем путь к файлу
    public static final String DESTINATION_FOLDER_PATH = "C:\\Users\\admin\\Desktop\\TestFileCoper"; // Путь экспортируемой папки

    public static void main(String[] args) {
        Copier copier = new ControlableCopierImpl();
        CopyManager copyManager = new CopyManager(copier, 2000);

        copyManager.copy(FILE_PATH, DESTINATION_FOLDER_PATH);
    }
}
