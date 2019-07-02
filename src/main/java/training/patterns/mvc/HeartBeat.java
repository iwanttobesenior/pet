package training.patterns.mvc;

import java.util.ArrayList;
import java.util.List;

class HeartBeat implements Observable {

    private int heartRate;

    private List<BPMObserver> bpmObservers;
    private List<BeatObserver> beatObservers;

    public HeartBeat() {
        bpmObservers = new ArrayList<>();
        beatObservers = new ArrayList<>();
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    @Override
    public void registerObserver(BeatObserver beatObserver) {
        beatObservers.add(beatObserver);
    }

    @Override
    public void registerObserver(BPMObserver bpmObserver) {
        bpmObservers.add(bpmObserver);
    }

    @Override
    public void removeObserver(BeatObserver beatObserver) {
        beatObservers.remove(beatObserver);
    }

    @Override
    public void removeObserver(BPMObserver bpmObserver) {
        bpmObservers.remove(bpmObserver);
    }

    @Override
    public void notifyBPMObservers() {
        for (BPMObserver bpmObserver : bpmObservers) {
            bpmObserver.updateBPM();
        }
    }

    @Override
    public void notifyBeatObservers() {
        for (BeatObserver beatObserver : beatObservers) {
            beatObserver.updateBeat();
        }
    }
}
