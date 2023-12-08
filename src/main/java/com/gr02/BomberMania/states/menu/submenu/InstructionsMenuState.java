package com.gr02.BomberMania.states.menu.submenu;


import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.controller.menu.submenu.InstructionsMenuController;
import com.gr02.BomberMania.model.menu.submenu.InstructionsMenu;
import com.gr02.BomberMania.states.State;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.menu.submenu.InstructionsMenuViewer;

public class InstructionsMenuState extends State<InstructionsMenu> {

    public InstructionsMenuState(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InstructionsMenu> getViewer() {
        return new InstructionsMenuViewer(getModel());
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsMenuController(getModel());
    }
}