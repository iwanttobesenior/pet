package training.patterns.mvc;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequencer;
import java.util.ArrayList;
import java.util.List;

class Beat implements IBeatModel, MetaEventListener,Observable {

    private Sequencer sequencer;

    private List<BPMObserver> bpmObservers;
    private List<BeatObserver> beatObservers;

    int bpm = 90;

    public Beat() {
        bpmObservers = new ArrayList<>();
        beatObservers = new ArrayList<>();
    }

    @Override
    public void meta(MetaMessage meta) {

    }

    @Override
    public void initialize() {

    }


    @Override
    public void on() {
        sequencer.start();
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return bpm;
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

    void beatEvent() {
        notifyBeatObservers();
    }
}
