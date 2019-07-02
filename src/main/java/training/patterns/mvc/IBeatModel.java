package training.patterns.mvc;

/**
 * as model
 * <p>
 * rhythm generator API
 * <p>
 * observable the same way
 */
interface IBeatModel {

    void initialize();


    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();
}
