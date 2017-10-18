package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.ModeDirector;

import java.net.URL;
import java.util.ResourceBundle;

public class WrongViewController extends AbstractController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private Label answerLbl;
    @FXML
    private Label lbl;

    private static ModeDirector _modeDirector = ModeDirector.instance();

    public void btnAction() {
        if (_modeDirector.getIteration() > (_modeDirector.getNumQuestions() - 1)) {
            _modeDirector.setIteration(0);
            popChild();
            pushChild("SummaryView");
        }
        else {
            popChild();
        }
        //other logic
    }

    public void mainMenu() {
        pushChild("MenuView");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String attempt = _modeDirector.getCurrentAttempt();
        String answer = _modeDirector.getCurrentAnswer();

        if (attempt.indexOf("whaa") != -1) {
            attempt = attempt.replaceAll("whaa", "whā");
        } else if (answer.indexOf("whaa") != -1) {
            answer = answer.replaceAll("whaa", "whā");
        } else if (attempt.indexOf("maa") != -1) {
            attempt = attempt.replaceAll("maa", "mā");
        } else if (answer.indexOf("maa") != -1) {
            answer = answer.replaceAll("maa", "mā");
        }

        answerLbl.setText("You said " + attempt);
        if ((getSuperAttempts() > 1) && _modeDirector.getIteration() > (_modeDirector.getNumQuestions() - 2)) {
            lbl.setText("Finish");
            answerLbl.setText("You said " + attempt + ", the answer was " + answer);
        }
        else if ((getSuperAttempts() > 1)) {
            lbl.setText("Next Question");
            answerLbl.setText("You said " + attempt + ", the answer was " + answer);
        }
        else {
            lbl.setText("Try Again!");
        }

        setFonts(lbl, 65, answerLbl, 30, null, -1, null, -1, 2);
    }
}
