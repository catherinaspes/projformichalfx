package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    SampleList sampleList = new SampleList() {
        @Override
        public void addSample(Sample sample) {

        }

        @Override
        public Sample getSample(int index) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    };

    public ReadFile(String filePath) throws IOException {
        readFile(filePath);
    }

    public void readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String textLine = bufferedReader.readLine();

            while ((textLine = bufferedReader.readLine()) != null) {
                if (textLine.contains("#") || textLine.isEmpty()) {
                    textLine = null;
                    System.out.println("plik zawiera znak hasz lub jest pusty");

                } else {

                    String divider[] = textLine.split(";");
                    Double firstParam = Double.parseDouble(divider[0]);
                    Double secondParam = Double.parseDouble(divider[1]);
                    Double thirdParam = Double.parseDouble(divider[2]);
                    Double fourthParam = Double.parseDouble(divider[3]);
                    Sample sample = new Sample(firstParam, secondParam, thirdParam, fourthParam);
                    sampleList.addSample(sample);
                }
            }

        } finally {
            bufferedReader.close();
        }


    }

    public SampleList getSampleList() {
        return sampleList;
    }
}
