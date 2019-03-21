package notePad.controller;

import notePad.model.DateNotePad;
import notePad.view.NotePadView;

public class NotePadController {

    private DateNotePad model;
    private NotePadView view;
    public NotePadController(DateNotePad model, NotePadView view){
        this.model = model;
        this.view = view;
    }

    public void start(){
        view.ShowNotePad(model.getFrame());
    }

}
