package training.patterns.mvc;

interface Observable {

    void registerObserver(BeatObserver beatObserver);

    void registerObserver(BPMObserver bpmObserver);

    void removeObserver(BeatObserver beatObserver);

    void removeObserver(BPMObserver bpmObserver);

    void notifyBPMObservers();

    void notifyBeatObservers();
}
