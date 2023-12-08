package com.gr02.BomberMania.states.menu.submenu;

import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.controller.menu.submenu.MapMenuController;
import com.gr02.BomberMania.model.menu.submenu.MapMenu;
import com.gr02.BomberMania.states.State;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.menu.submenu.MapMenuViewer;

public class MapMenuState extends State<MapMenu> {

    public MapMenuState(MapMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MapMenu> getViewer() { return new MapMenuViewer(getModel()); }

    @Override
    protected Controller<MapMenu> getController() {
        return new MapMenuController(getModel());
    }
}