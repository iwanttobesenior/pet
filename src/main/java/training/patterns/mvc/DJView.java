package training.patterns.mvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DJView implements ActionListener, BeatObserver, BPMObserver {

    private IBeatModel beatModel;
    private IBeatController beatController;

    JFrame viewFrame;
    JFrame viewPanel;
    JLabel bpmOutputLabel;

    public DJView(IBeatModel beatModel, IBeatController beatController) {
        this.beatModel = beatModel;
        this.beatController = beatController;

//        beatModel.registerObserver((BPMObserver) this);
//        beatModel.registerObserver((BeatObserver) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void updateBPM() {
        beatModel.getBPM();
    }

    @Override
    public void updateBeat() {
        /*set beat bar value*/
    }
}
