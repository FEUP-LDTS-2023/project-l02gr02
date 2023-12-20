package com.gr02.BomberMania.viewer.menu;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.model.menu.submenu.DrawMenu;
import com.gr02.BomberMania.model.menu.submenu.InstructionsMenu;
import com.gr02.BomberMania.model.menu.submenu.MapMenu;
import com.gr02.BomberMania.model.menu.submenu.WinMenu;
import com.gr02.BomberMania.viewer.menu.submenu.DrawMenuViewer;
import com.gr02.BomberMania.viewer.menu.submenu.InstructionsMenuViewer;
import com.gr02.BomberMania.viewer.menu.submenu.MapMenuViewer;
import com.gr02.BomberMania.viewer.menu.submenu.WinMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static com.gr02.BomberMania.Game.height;
import static com.gr02.BomberMania.Game.width;

public class MenusViewersTest {
    GUI gui;
    MainMenu menu;
    MainMenuViewer mainMenuViewer;
    WinMenu winMenu;
    WinMenuViewer winMenuViewer;
    InstructionsMenu instructionsMenu;
    InstructionsMenuViewer instructionsMenuViewer;
    MapMenu mapMenu;
    MapMenuViewer mapMenuViewer;
    DrawMenu drawMenu;
    DrawMenuViewer drawMenuViewer;

    @BeforeEach
    public void helper() {
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void MainMenuTest() throws IOException {
        menu = new MainMenu();
        mainMenuViewer = new MainMenuViewer(menu);
        mainMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(width/2 - 5, (int) (height * 0.2)), "B[mberMania", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 0), "Start", menu.isSelected(0) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 3), "Instructions", menu.isSelected(1) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 6), "Mute Music", menu.isSelected(2) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 9), "Exit", menu.isSelected(3) ? "#FFD700" : "#FFFFFF");
    }

    @Test
    public void WinMenuTest() throws IOException {
        winMenu = new WinMenu(1);
        winMenuViewer = new WinMenuViewer(winMenu);
        winMenuViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(width/2 - 7, (int) (height * 0.2)), "PLAYER " + winMenu.getPlayerNumber() + " WINS!", "#88DAD4");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 0), "Replay", winMenu.isSelected(0) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 3), "Main Menu", winMenu.isSelected(1) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 6), "Exit", winMenu.isSelected(2) ? "#FFD700" : "#FFFFFF");

        winMenu = new WinMenu(2);
        winMenuViewer = new WinMenuViewer(winMenu);
        winMenuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(width/2 - 7, (int) (height * 0.2)), "PLAYER " + winMenu.getPlayerNumber() + " WINS!", "#FCE97D");
    }

    @Test
    public void InstructionsMenuTest() throws IOException {
        instructionsMenu = new InstructionsMenu();
        instructionsMenuViewer = new InstructionsMenuViewer(instructionsMenu);
        instructionsMenuViewer.draw(gui);

        int heightShift = (int) (height * 0.1);
        int widthShift = (int) (width * 0.3);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(width/2 - 6, 1 + heightShift), "INSTRUCTIONS", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(2 + widthShift, 4 + heightShift), "Player 1:", "#88dad4");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3 + widthShift, 6 + heightShift), "Movement:", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(15 + widthShift, 6 + heightShift), "W", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(14 + widthShift, 7 + heightShift), "A", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(15 + widthShift, 7 + heightShift), "S", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(16 + widthShift, 7 + heightShift), "D", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3 + widthShift, 9 + heightShift), "Bomb: F", "#9F0000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3 + widthShift, 10 + heightShift), "Detonator: E", "#9F0000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(2 + widthShift, 12 + heightShift), "Player 2:", "#fce97d");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3 + widthShift, 14 + heightShift), "Movement:", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(15 + widthShift, 14 + heightShift), "@", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(14 + widthShift, 15 + heightShift), "<", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(15 + widthShift, 15 + heightShift), "=", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(16 + widthShift, 15 + heightShift), ">", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3 + widthShift, 17 + heightShift), "Bomb: P", "#9F0000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(3 + widthShift, 18 + heightShift), "Detonator: O", "#9F0000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(width/2 - 3, 20 + 0 + heightShift), "Go Back", instructionsMenu.isSelected(0) ? "#FFD700" : "#FFFFFF");
    }
    @Test
    public void DrawMenuTest() throws IOException {
        drawMenu = new DrawMenu("Time has ended");
        drawMenuViewer = new DrawMenuViewer(drawMenu);
        drawMenuViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(width/2 - 5, (int) (height * 0.2)), drawMenu.getDrawReason(), "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(width/2 - 2, (int) (height * 0.2)+1), "DRAW!", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 0), "Replay", drawMenu.isSelected(0) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 3), "Main Menu", drawMenu.isSelected(1) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, (int) (height * 0.5) + 6), "Exit", drawMenu.isSelected(2) ? "#FFD700" : "#FFFFFF");

    }
    @Test
    public void MapMenuTest() throws IOException {
        mapMenu = new MapMenu();
        mapMenuViewer = new MapMenuViewer(mapMenu);
        mapMenuViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(width/2 - 14, 2), "Please select the chosen map", "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position( (int) (width*0.1), 5 + 0 + (int) (height * 0.1)), "Map 1", mapMenu.isSelected(0) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position( (int) (width*0.1), 5 + 3 + (int) (height * 0.1)), "Map 2", mapMenu.isSelected(1) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position( (int) (width*0.1), 5 + 6 + (int) (height * 0.1)), "Map 3", mapMenu.isSelected(2) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position( (int) (width*0.1), 5 + 9 + (int) (height * 0.1)), "Random Map", mapMenu.isSelected(3) ? "#FFD700" : "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position( (int) (width*0.1), 5 + 12 + (int) (height * 0.1)), "Go Back", mapMenu.isSelected(4) ? "#FFD700" : "#FFFFFF");

    }
}
