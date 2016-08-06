import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by abu on 2016/8/6 10:12.
 */
public class MakeChannel {
    private static final String CHANNEL_FILE_NAME_KEY = "test_";
    private static final String CHANNELS_FILE_NAME = "test_channel.txt";
    private static final String CHANNELS_FILE_OUT_DIR_NAME = "test_channel";
    private static final int BUFFER_LENGTH = 2 * 1024;
    private static final byte[] BUFFER = new byte[BUFFER_LENGTH];

    public MakeChannel() {
    }

    public static void copy(InputStream input, OutputStream output) throws IOException {
        int bytesRead;
        while((bytesRead = input.read(BUFFER, 0, BUFFER_LENGTH)) != -1) {
            output.write(BUFFER, 0, bytesRead);
        }

    }

    public static void main(String[] args) {
        File userDir = new File("");
        String path = userDir.getAbsolutePath();
        System.out.println("--" + path);
        List channels = getChannels(path + File.separator + "test_channel.txt");
        if(channels != null && channels.size() != 0) {
            File apkFile = getApk(userDir.getAbsoluteFile());
            if(apkFile != null && apkFile.exists()) {
                File outDir = new File(path, "test_channel");
                outDir.mkdir();
                genneryAllChannelsApk(apkFile, channels, outDir);
            } else {
                System.out.println("loss apk");
            }

        } else {
            System.out.println(" read channel failed");
        }
    }

    public static void genneryAllChannelsApk(File apkFile, List<String> channels, File outDir) {
        if(apkFile != null && channels != null && outDir != null) {
            for(int i = 0; i < channels.size(); ++i) {
                int end = apkFile.getName().indexOf(".apk");
                File channelItemName = new File(outDir, apkFile.getName().substring(0, end) + "_" + (String)channels.get(i) + ".apk");

                try {
                    ZipFile e = new ZipFile(apkFile);
//                    ZipOutputStream append = new ZipOutputStream(new FileOutputStream(channelItemName.getAbsolutePath()));
                    //Adler32与CRC32相反
//                    ZipOutputStream append = new ZipOutputStream(new CheckedOutputStream(new FileOutputStream(channelItemName.getAbsolutePath()), new Adler32()));
                    //CRC32算法复杂但是数据完整性验证更强
                    ZipOutputStream append = new ZipOutputStream(new CheckedOutputStream(new FileOutputStream(channelItemName.getAbsolutePath()), new CRC32()));
                    Enumeration entries = e.entries();

                    while(entries.hasMoreElements()) {
                        ZipEntry channel = (ZipEntry)entries.nextElement();//这里的Elements指改文件夹下所有的包括子的子
                        System.out.println("copy: " + channel.getName());
                        append.putNextEntry(new ZipEntry(channel.getName()));
                        if(!channel.isDirectory()) {
                            copy(e.getInputStream(channel), append);
                            append.closeEntry();
                        }
                    }

                    String var12 = "META-INF/test_" + (String)channels.get(i);
                    ZipEntry channelAppend = new ZipEntry(var12);
                    System.out.println("append: " + channelAppend.getName());
                    append.putNextEntry(channelAppend);
                    append.write("\n".getBytes());
                    append.closeEntry();
                    e.close();
                    append.close();
                } catch (IOException var11) {
                    var11.printStackTrace();
                }
            }

        }
    }

    public static List<String> getChannels(String channelsFileName) {
        File file = new File(channelsFileName);
        ArrayList channels = new ArrayList();
        if(file != null && file.exists() && file.length() > 0L) {
            FileReader reader = null;
            BufferedReader br = null;

            try {
                reader = new FileReader(channelsFileName);
                br = new BufferedReader(reader);
                String e = null;

                while((e = br.readLine()) != null) {
                    channels.add(e.trim());
                    System.out.println(e);
                }

                br.close();
                reader.close();
            } catch (FileNotFoundException var16) {
                var16.printStackTrace();
            } catch (IOException var17) {
                var17.printStackTrace();
            } finally {
                try {
                    if(br != null) {
                        br.close();
                    }

                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException var15) {
                    var15.printStackTrace();
                }

            }

            return channels;
        } else {
            System.out.println("channels is not availabletest_channel.txt");
            return null;
        }
    }

    /**
     * 获取文件目录下第一个.apk文件
     * @param dir
     * @return
     */
    public static File getApk(File dir) {
        String[] files = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".apk");
            }
        });
        if(files != null && files.length > 0) {
            File apkFile = new File(dir, files[0]);
            return apkFile;
        } else {
            return null;
        }
    }
}
