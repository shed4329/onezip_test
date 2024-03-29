package onezip.component;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import onezip.CompressUtils.RAR.UnCompressUtil;
import onezip.Service.RARExtractService;
import onezip.testOne;

import java.io.File;

import static onezip.component.oneAlert.*;


public class RARPane extends Application {
    static String RARFile;
    public static void main(String[] args) {
        if (args.length==1){
            RARFile=args[0];
        }else if (args.length==2){
            RARFile=args[0];
        }else{
            return;
        }
        //launch(args);//Application launch must not be called more than once
       myStart(new Stage());
    }

    @Override
    public void start(Stage stage) {
        //Application launch must not be called more than once
    }
    public static void myStart(Stage stage){
        Text rarName= new Text("\n"+RARFile.substring(RARFile.lastIndexOf("\\")+1));
        rarName.setFont(new Font(20));
        Text rarPath = new Text(RARFile);
        Group group = new Group();
        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(300);
        group.getChildren().add(progressBar);
        Text status = new Text("状态:还未开始解压");
        HBox hBox = new HBox();
        Button extract = new Button("解压至");
        Button cancel = new Button("取消");
        hBox.getChildren().addAll(extract,cancel);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(rarName,rarPath,group,status,hBox);
        vBox.setSpacing(10.0);
        Scene scene = new Scene(vBox);
        if (testOne.isCursorAble()){
            scene.setCursor(new ImageCursor(testOne.getCursorImage()));
        }
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setWidth(350);
        stage.setHeight(200);
        stage.show();

        extract.setOnAction(actionEvent -> {
            String password;
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("解压至");
            File directory = directoryChooser.showDialog(stage);
            status.setText("服务加载中");
            group.getChildren().clear();
            ProgressBar progressBar1 = new ProgressBar();
            progressBar1.setPrefWidth(300);
            group.getChildren().add(progressBar1);
            File[] files = directory.listFiles();
            RARExtractService rarExtractService = new RARExtractService(RARFile,directory.getPath());
                status.setText("正在解压");
                rarExtractService.start();
            try {
                Thread.sleep(3000);//3000ms等待服务
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            File[] files2 = directory.listFiles();
            assert files2 != null;
            assert files != null;
            System.out.println(files.length+" "+files2.length);
            if (files.length==files2.length) {//好像加密RAR没有密码打开的话不会报错，什么也不做，只有曲线救国
                alertWarning("如果您认为该压缩包没有加密，请点击取消");
                password=textInputDialog();
                RARExtractService rarExtractService2 = new RARExtractService(RARFile, directory.getPath(), password);
                rarExtractService2.start();
            }
            try {
                Thread.sleep(100);//3000ms等待服务
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (UnCompressUtil.isIsSuccessful()) {
                progressBar1.setProgress(1);
                status.setText("解压成功");
                alertSuccess();
            }else{
                progressBar1.setStyle("-fx-accent:#FF4500");


                progressBar1.setProgress(0.5);
                status.setText("解压失败");
            }


        });
        cancel.setOnAction(actionEvent -> stage.close());
    }

}