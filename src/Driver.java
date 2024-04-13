import java.util.ArrayList;
import java.util.List;

import controllers.SanctuaryController;
import controllers.SanctuaryControllerInterface;
import models.Sanctuary;
import views.JFrameView;

public class Driver {
  public static void main(String[] args) {
    SanctuaryControllerInterface controller = new SanctuaryController(new JFrameView(), new Sanctuary(20, 8));
    controller.go();
  }
}
