package onezip.CompressUtils;

import onezip.CompressUtils.zip.zipUtils;
import onezip.CompressUtils.zip.viewUtils;

import java.io.File;
import java.util.ArrayList;

import onezip.ProcessFrame;

import net.lingala.zip4j.*;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class test {
    public static void main(String[] args) throws Exception{
        /*ZipFile zipFile = new ZipFile("C:\\Users\\shed4329\\Desktop\\fx.zip");
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
        zipParameters.setCompressionLevel(CompressionLevel.NORMAL);
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
        zipFile.setPassword("six".toCharArray());
        zipFile.addFile(new File("C:\\Users\\shed4329\\Desktop\\lw.docx"),zipParameters);
         */
       //String[] array = zipUtils.list(new File("C:\\Users\\shed4329\\Desktop\\wallpaper__engine.zip"),"wallpaper__engine/wallpaper_engine/ui/dist",false);
       //for(int i=0;i<array.length;i++){
           //System.out.println("i "+array[i]);
       //}
        //ArrayList<String> arrayList=new ArrayList<String>();
        //viewUtils.fileView(new File("C:\\Users\\shed4329\\Desktop\\wallpaper__engine.zip"), arrayList );
        //System.out.println(viewUtils.getFileNameInPath(arrayList,"wallpaper__engine"));
        //System.out.println(zipUtils.getComment(new File("C:\\Users\\shed4329\\Desktop\\bilibili.zip")));//实测UTF-8不乱码
        ArrayList<String> arrayList = new ArrayList();
        viewUtils.fileView(new File("C:\\Users\\kas shed\\Downloads\\workupload-master.zip"),arrayList);
        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        //zipUtils.zip(new File("C:\\Users\\shed4329\\Desktop\\lw.docx"),new File("C:\\Users\\shed4329\\Desktop\\fx.zip"),0,0,true,1,256,"javafx");
        //zipUtils.zip((new File("C:\\Users\\shed4329\\Desktop\\lw.docx")),new File("C:\\Users\\shed4329\\Desktop\\fx.zip"),0,0,true,"six");
    }
}
