package com.gr02.BomberMania.states.menu.submenu;


import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.controller.menu.MainMenuController;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.states.State;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.menu.submenu.InstructionsMenuViewer;

public class InstructionsMenuState extends State<MainMenu> {

    public InstructionsMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new InstructionsMenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}