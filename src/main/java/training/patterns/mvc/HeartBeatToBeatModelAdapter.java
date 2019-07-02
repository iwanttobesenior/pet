package training.patterns.mvc;

public class HeartBeatToBeatModelAdapter implements IBeatModel, Observable {

    private final HeartBeat heartBeat;

    public HeartBeatToBeatModelAdapter(HeartBeat heartBeat) {
        this.heartBeat = heartBeat;
    }

    @Override
    public void initialize() {
        /*NOP*/
    }

    @Override
    public void on() {
        /*NOP*/
    }

    @Override
    public void off() {
        /*NOP*/
    }

    @Override
    public void setBPM(int bpm) {
        heartBeat.setHeartRate(bpm);
    }

    @Override
    public int getBPM() {
        return heartBeat.getHeartRate();
    }

    @Override
    public void registerObserver(BeatObserver beatObserver) {
        heartBeat.registerObserver(beatObserver);
    }

    @Override
    public void registerObserver(BPMObserver bpmObserver) {
        heartBeat.registerObserver(bpmObserver);
    }

    @Override
    public void removeObserver(BeatObserver beatObserver) {
        heartBeat.removeObserver(beatObserver);
    }

    @Override
    public void removeObserver(BPMObserver bpmObserver) {
        heartBeat.removeObserver(bpmObserver);
    }

    @Override
    public void notifyBPMObservers() {
        heartBeat.notifyBPMObservers();
    }

    @Override
    public void notifyBeatObservers() {
        heartBeat.notifyBeatObservers();
    }
}
