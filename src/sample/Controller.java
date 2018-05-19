package sample;

import com.sun.istack.internal.NotNull;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class Controller {

    @FXML
    private Button add1;

    @FXML
    private Button add2;

    @FXML
    private Button add3;

    @FXML
    private Button upload;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    @NotNull
    private TextField fiisostzero;

    @FXML
    @NotNull
    private TextField fiisoendzero;

    @FXML
    @NotNull
    private TextField fiisosts;

    @FXML
    @NotNull
    private TextField fiisoends;

    @FXML
    @NotNull
    private TextField tend;

    @FXML
    @NotNull
    private TextField tst;

    @FXML
    @NotNull
    private TextField beta;

    private Window window;


    private CalibrationSampleList calibrationSampleList;
    private MeasurementSampleList measurementSampleList;
    private ZerolineSampleList zerolineSampleList;
    DataFromFiles dff = new DataFromFiles(calibrationSampleList, measurementSampleList, zerolineSampleList);

    public void initialize(Window window) {
        this.window = window;
        add1.setOnAction(event -> openFirstFileDialog());
        add2.setOnAction(event -> openSecondFileDialog());
        add3.setOnAction(event -> openThirdFileDialog());
        upload.setOnAction(event -> getTextFromTextfields());

    }

    private void openFirstFileDialog() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        if(file != null) {
            textField1.setText(file.getAbsolutePath());
        }
    }
    private void openSecondFileDialog() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        if(file != null) {
            textField2.setText(file.getAbsolutePath());
        }
    }
    private void openThirdFileDialog() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        if(file != null) {
            textField3.setText(file.getAbsolutePath());
        }
    }

    private void getTextFromTextfields(){
        double param1 = Double.parseDouble(fiisostzero.getText());
        double param2 = Double.parseDouble(fiisoendzero.getText());
        double param3 = Double.parseDouble(fiisosts.getText());
        double param4 = Double.parseDouble(fiisoends.getText());
        double param5 = Double.parseDouble(tend.getText());
        double param6 = Double.parseDouble(tst.getText());
        double param7 = Double.parseDouble(beta.getText());

        ConstValues cv = new ConstValues(param1, param2,param3,param4,param5,param6,param7);

        System.out.println(fiisostzero.getText()+" "+ fiisoendzero.getText());


        ProcessedSample ps = new ProcessedSample();
        KFunction kf = new KFunction();
        for(int i = 0; i<dff.getCalibrationSampleList().size()-1; i++) {

            ps = kf.process(dff.getCalibrationSampleList().getSample(i).getTemperature(),
                    dff.getCalibrationSampleList().getSample(i), dff.getZerolineSampleList().getSample(i));


            dff.processedSamples.add(ps);
            System.out.println(dff.processedSamples.get(i).getTemp()
                    + " "+dff.processedSamples.get(i).getTerm1()+" "+
                    dff.processedSamples.get(i).getTerm2()+
                    " " + dff.processedSamples.get(i).getKodT());
        }
        System.out.println("Lista uzupelniona");
        System.out.println();


    }


}
