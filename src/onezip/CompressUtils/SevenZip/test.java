import java.io.File;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        /*ArrayList<String> arrayList = new ArrayList<>();
        viewUtils.fileView("C:\\Users\\kas shed\\Documents\\BKC4\\BKC4-main\\bkc4_64bit.7z",arrayList);
        ArrayList<String> arrayList1=viewUtils.getFileNameInPath(arrayList,"jre\\lib");//写法jre或jre\\lib
        for (int i=0;i<arrayList1.size();i++){
            System.out.println(arrayList1.get(i));
        }
         */
        long d1 = System.currentTimeMillis();
        //ExtractUtils.extract("C:\\Users\\kas shed\\Desktop\\bkc4.7z","C:\\Users\\kas shed\\Desktop\\test","1111");
        /*String[] argument={"C:\\Users\\kas shed\\Desktop\\bkc2.7z","C:\\Users\\kas shed\\Desktop\\bkc2.7z","android.txt","android os is also an operation system based on open-source system,linux,created by google llc."};//实现7z的自身更新
          String[] argument={"C:\\Users\\kas shed\\Desktop\\bkc2.7z","C:\\Users\\kas shed\\Desktop\\bkc2.7z","ios.txt"};//实测不可以，可以尝试的数组3
          String[] argument={"C:\\Users\\kas shed\\Desktop\\bkc2.7z","C:\\Users\\kas shed\\Desktop\\bkc2.7z","sir.txt","this txt file appear due to some technology limits,we're sorry for that","sorry.txt"};//实现7z的自身更新
          AddOrDeleteUtils.main(argument);
         */
        String[] argument={"compress.7z"};
        SevenZipJBindingJunitCompressNonGeneric7z.main(argument);
        long d2 = System.currentTimeMillis();
        System.out.println("using time:"+(d2-d1)+"ms");
    }
}
