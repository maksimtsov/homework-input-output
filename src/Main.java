import java.io.*;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        File games = new File("C://Games");
        File src = new File("C://Games/src");
        File main = new File("C://Games/src/main");
        File test = new File("C://Games/src/test");
        File res = new File("C://Games/res");
        File drawbles = new File("C://Games/res/drawbles");
        File vectors = new File("C://Games/res/vectors");
        File icons = new File("C://Games/res/icons");
        File savegames = new File("C://Games/savegames");
        File temp = new File("C://Games/temp");

        File mainJava = new File(main + "/Main.java");
        File utils = new File(main + "/Utils.java");
        File tempTxt = new File(temp + "/temp.txt");

        if (games.mkdir()) sb.append("Директория " + games + " была создана\n");
        if (src.mkdir()) sb.append("Директория " + src + " была создана\n");
        if (main.mkdir()) sb.append("Директория " + main + " была создана\n");
        if (test.mkdir()) sb.append("Директория " + test + " была создана\n");
        if (res.mkdir()) sb.append("Директория " + res + " была создана\n");
        if (drawbles.mkdir()) sb.append("Директория " + drawbles + " была создана\n");
        if (vectors.mkdir()) sb.append("Директория " + vectors + " была создана\n");
        if (icons.mkdir()) sb.append("Директория " + icons + " была создана\n");
        if (savegames.mkdir()) sb.append("Директория " + savegames + " была создана\n");
        if (temp.mkdir()) sb.append("Директория " + temp + " была создана\n");

        try {
            mainJava.createNewFile();
            utils.createNewFile();
            tempTxt.createNewFile();

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(sb.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
