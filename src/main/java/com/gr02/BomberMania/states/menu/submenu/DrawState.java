package com.gr02.BomberMania.states.menu.submenu;

import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.controller.menu.submenu.DrawMenuController;
import com.gr02.BomberMania.model.menu.submenu.DrawMenu;
import com.gr02.BomberMania.states.State;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.menu.submenu.DrawMenuViewer;

public class DrawState extends State<DrawMenu> {
    public DrawState(DrawMenu model) {
        super(model);
    }
    @Override
    protected Viewer<DrawMenu> getViewer() {
        return new DrawMenuViewer(getModel());
    }

    @Override
    protected Controller<DrawMenu> getController() {
        return new DrawMenuController(getModel());
    }
}
