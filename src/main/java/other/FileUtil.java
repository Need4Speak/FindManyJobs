package other;

import java.io.*;

/**
 * 文件读写
 */
public class FileUtil {
    /**
     * 读取文件内容，并返回
     * @param fileName 文件名，需要带路径
     * @return 返回文件中的输入内容，如出现错误，返回 null
     */
    public static String readFile(String fileName) {
        String line = null;
        StringBuilder input = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                input.append(line).append("\n");
            }
            bufferedReader.close();
            return input.toString();
        } catch (FileNotFoundException ex) {
            System.out.println("无法打开文件 '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("读取文件 '" + fileName + "' 错误");
        }
        return null;
    }

    /**
     * 向文件中写入
     * @param content 要写入的内容
     * @param fileName 文件名
     */
    public static void writeFile(String content, String fileName) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"));
            writer.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }
}
