package sample;

public class KFunction {
    ConstValues cv;
    DataFromFiles dff;

    Double cpodT;
    Double beta;

    Double fiIsoStS;
    Double fiIsoEndS;
    Double tend;
    Double tst;
    Double fiZero;
    Double fiIsoStZero;
    Double fiIsoEndZero;
    Double t;


    public Double getCpodT(double temp) {
        SaphireCp saphireCp = new SaphireCp(temp);
        double result = saphireCp.cpOdJprzezmgK(temp);
        return result;
    }

    public Double getBeta() {
        return cv.getBeta();
    }

    public Double getFiIsoStS() {
        return cv.getFisoStS();
    }

    public Double getFiIsoEndS() {
        return cv.getFisoEndS();
    }

    public Double getTend() {
        return  cv.getTend();
    }

    public Double getTst() {
        return cv.getTst();
    }

    public Double getFiIsoStZero() {
        return cv.getFisoStZero();
    }

    public Double getFiIsoEndZero() {
        return cv.getFisoEndZero();
    }


    Double term1(Sample sample){
        Double termOne =
                sample.getDsc() - (getFiIsoStS()+(getFiIsoEndS()-getFiIsoStS())*(sample.getTime()-getTst())/(getTend() - getTst()));
        return termOne;
    }

    Double term2(Sample sample){
        Double termTwo =
                sample.getDsc() - (getFiIsoStZero()+(getFiIsoEndZero()-getFiIsoStZero())*(sample.getTime()-getTst())/(getTend() - getTst()));
        return termTwo;
    }

    ProcessedSample process(Double temp, Sample sampleCal, Sample sampleZero){

        ProcessedSample result = new ProcessedSample();

        result.temp = temp;
        result.tempCal = sampleCal.getTemperature();
        result.tempZero = sampleZero.getTemperature();
        result.term1 = term1(sampleCal);
        result.term2 = term2(sampleZero);
        result.kodT=  getCpodT(temp)*getBeta()/result.term1-result.term2;
        return result;
    }
}
