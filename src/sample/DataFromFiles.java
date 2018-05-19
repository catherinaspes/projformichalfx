package sample;

import java.util.ArrayList;
import java.util.List;

public class DataFromFiles {
    SampleList calibrationSampleList;
    SampleList measurementSampleList;
    SampleList zerolineSampleList;
    List<ProcessedSample> processedSamples = new ArrayList<ProcessedSample>();

    public DataFromFiles(SampleList calibrationSampleList, SampleList measurementSampleList, SampleList zerolineSampleList) {
        this.calibrationSampleList = calibrationSampleList;
        this.measurementSampleList = measurementSampleList;
        this.zerolineSampleList = zerolineSampleList;
    }

    public void setCalibrationSampleList(SampleList calibrationSampleList) {
        this.calibrationSampleList = calibrationSampleList;
    }

    public void setMeasurementSampleList(SampleList measurementSampleList) {
        this.measurementSampleList = measurementSampleList;
    }

    public void setZerolineSampleList(SampleList zerolineSampleList) {
        this.zerolineSampleList = zerolineSampleList;
    }

    public SampleList getCalibrationSampleList() {
        return calibrationSampleList;
    }

    public SampleList getMeasurementSampleList() {
        return measurementSampleList;
    }

    public SampleList getZerolineSampleList() {
        return zerolineSampleList;
    }

    public List<ProcessedSample> getProcessedSamples() {
        return processedSamples;
    }
}
