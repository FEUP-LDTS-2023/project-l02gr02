package com.gr02.BomberMania.states;

import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.model.menu.WinMenu;
import com.gr02.BomberMania.controller.menu.WinMenuController;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.menu.WinMenuViewer;

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
