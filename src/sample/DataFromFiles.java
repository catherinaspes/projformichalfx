package sample;

import java.util.ArrayList;
import java.util.List;

public class DataFromFiles {
    CalibrationSampleList calibrationSampleList;
    MeasurementSampleList measurementSampleList;
    ZerolineSampleList zerolineSampleList;
    List<ProcessedSample> processedSamples = new ArrayList<ProcessedSample>();

    public DataFromFiles(CalibrationSampleList calibrationSampleList, MeasurementSampleList measurementSampleList, ZerolineSampleList zerolineSampleList) {
        this.calibrationSampleList = calibrationSampleList;
        this.measurementSampleList = measurementSampleList;
        this.zerolineSampleList = zerolineSampleList;
    }

    public void setCalibrationSampleList(CalibrationSampleList calibrationSampleList) {
        this.calibrationSampleList = calibrationSampleList;
    }

    public void setMeasurementSampleList(MeasurementSampleList measurementSampleList) {
        this.measurementSampleList = measurementSampleList;
    }

    public void setZerolineSampleList(ZerolineSampleList zerolineSampleList) {
        this.zerolineSampleList = zerolineSampleList;
    }

    public CalibrationSampleList getCalibrationSampleList() {
        return calibrationSampleList;
    }

    public MeasurementSampleList getMeasurementSampleList() {
        return measurementSampleList;
    }

    public ZerolineSampleList getZerolineSampleList() {
        return zerolineSampleList;
    }

    public List<ProcessedSample> getProcessedSamples() {
        return processedSamples;
    }
}
