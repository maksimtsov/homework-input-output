import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {

//        Первое задание


//        StringBuilder sb = new StringBuilder();
//
//        File games = new File("C://Games");
//        File src = new File("C://Games/src");
//        File main = new File("C://Games/src/main");
//        File test = new File("C://Games/src/test");
//        File res = new File("C://Games/res");
//        File drawbles = new File("C://Games/res/drawbles");
//        File vectors = new File("C://Games/res/vectors");
//        File icons = new File("C://Games/res/icons");
//        File savegames = new File("C://Games/savegames");
//        File temp = new File("C://Games/temp");
//
//        File mainJava = new File(main + "/Main.java");
//        File utils = new File(main + "/Utils.java");
//        File tempTxt = new File(temp + "/temp.txt");
//
//        if (games.mkdir()) sb.append("Директория " + games + " была создана\n");
//        if (src.mkdir()) sb.append("Директория " + src + " была создана\n");
//        if (main.mkdir()) sb.append("Директория " + main + " была создана\n");
//        if (test.mkdir()) sb.append("Директория " + test + " была создана\n");
//        if (res.mkdir()) sb.append("Директория " + res + " была создана\n");
//        if (drawbles.mkdir()) sb.append("Директория " + drawbles + " была создана\n");
//        if (vectors.mkdir()) sb.append("Директория " + vectors + " была создана\n");
//        if (icons.mkdir()) sb.append("Директория " + icons + " была создана\n");
//        if (savegames.mkdir()) sb.append("Директория " + savegames + " была создана\n");
//        if (temp.mkdir()) sb.append("Директория " + temp + " была создана\n");
//
//        try {
//            mainJava.createNewFile();
//            utils.createNewFile();
//            tempTxt.createNewFile();
//
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//
//        try (FileWriter writer = new FileWriter(tempTxt)) {
//            writer.write(sb.toString());
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }


//        Второе задание


//
//        GameProgress gp1 = new GameProgress(100, 3, 1, 41.1);
//        GameProgress gp2 = new GameProgress(94, 1, 13, 1.1154);
//        GameProgress gp3 = new GameProgress(10, 18, 8, 201.4);
//
//        List<String> saves = List.of("C://Games/savegames/save1.dat", "C://Games/savegames/save2.dat", "C://Games/savegames/save3.dat");
//
//        saveGame(saves.get(0), gp1);
//        saveGame(saves.get(1), gp2);
//        saveGame(saves.get(2), gp3);
//
//        zipFiles("C://Games/savegames/zipsaves.zip", saves);

//        Третье задание
//
//        openZip("C://Games/savegames/zipsaves.zip", "C://Games/savegames/");
//
        GameProgress gp = openProgress("C:/Games/savegames/save1.dat");
        System.out.println(gp);
//
//
    }
    public static void saveGame(String path, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
//
    public static void zipFiles(String path, List<String> files) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            for (int i = 0; i < files.size(); i++) {
                FileInputStream fis = new FileInputStream(files.get(i));
                ZipEntry entry = new ZipEntry("save" + i + ".dat");
                zos.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
                fis.close();
                Files.delete(Path.of(files.get(i)));
            }
            zos.closeEntry();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void openZip(String fileInputPath, String fileOutputPath){
        try (FileInputStream fis = new FileInputStream(fileInputPath);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry entry;
            String name;
            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fos = new FileOutputStream(fileOutputPath + name);
                for (int i = 0; i != -1 ; i = zis.read()) {
                    fos.write(i);
                }
                fos.flush();
                zis.closeEntry();
                fos.close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static GameProgress openProgress(String path) {
        GameProgress gp = null;
        try(FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            gp = (GameProgress) ois.readObject();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return gp;
    }

    }

