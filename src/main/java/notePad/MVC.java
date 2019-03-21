package notePad;

import notePad.controller.NotePadController;
import notePad.model.DateNotePad;
import notePad.view.NotePadView;


public class MVC {
    public static void main(String args[]){
        NotePadView view = new NotePadView();
        DateNotePad model = new DateNotePad();
        NotePadController controller = new NotePadController(model, view);
        controller.start();
    }
}
