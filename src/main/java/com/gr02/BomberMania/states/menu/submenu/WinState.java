package com.gr02.BomberMania.states.menu.submenu;

import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.model.menu.submenu.WinMenu;
import com.gr02.BomberMania.controller.menu.submenu.WinMenuController;
import com.gr02.BomberMania.states.State;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.menu.submenu.WinMenuViewer;

public class WinState extends State<WinMenu> {
    public WinState(WinMenu model) {
        super(model);
    }
    @Override
    protected Viewer<WinMenu> getViewer() {
        return new WinMenuViewer(getModel());
    }

    @Override
    protected Controller<WinMenu> getController() {
        return new WinMenuController(getModel());
    }
}
