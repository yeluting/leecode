import java.io.*;

/**
 * Created by YLT on 2017/12/26.
 */
public class test {
    public static void readTxtFile(String filePath) {
        try {
            //String encoding = "GBK";
            File file = new File(filePath);
            File outfile = new File("C:\\Users\\YLT\\Desktop\\out13.txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(outfile));

            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file));//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                bufferedReader.readLine();
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                    if(lineTxt.equals("")){
                        out.write("\r\t");
                    }else {
                        System.out.println(lineTxt.lastIndexOf("_"));
                        String outstr = lineTxt.substring(lineTxt.lastIndexOf("_")+1);
                        // String strs[] = lineTxt.split("_");
                        out.write(outstr + "\r\t");
                    }
                }
                out.close();
                read.close();
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        test model = new test();
        model.readTxtFile("C:\\Users\\YLT\\Desktop\\res13.txt");
    }

}
