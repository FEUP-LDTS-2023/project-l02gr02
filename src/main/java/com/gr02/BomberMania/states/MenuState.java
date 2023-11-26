package com.gr02.BomberMania.states;

import com.gr02.BomberMania.model.menu.Menu;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }
    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

}
