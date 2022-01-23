package snake;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

/**
 * Initializes the game itself, processes user's input and also closes it
 */
public class Game {
    Screen screen;
    Board board;
    TextGraphics graphics;
    int speed;

    /**
     * Constructor of class
     * @param screen Game's frame
     * @param speed Snake's speed
     */
    public Game(Screen screen, int speed) {
        try {
            this.screen = screen;
            this.speed = speed;
            // configuring the screen
            screen.refresh();

            graphics = screen.newTextGraphics();
            board = new Board(40,20, speed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates board screen
     */
    public void draw() throws IOException {
        screen.clear();
        board.draw(graphics);
        screen.refresh();
    }

    /**
     * Initializes the game itself, makes snake move and also closes it
     */
    public void run() throws IOException {
        while(board.available) {
            draw();
            if (!board.moveSnake()) break;
        }
        gameOver();
        screen.close();
    }

    /**
     * Opens Game Over screen
     */
    private void gameOver() throws IOException {
        board.boardMenu = new BoardMenu();
        board.boardMenu.gameOverMenu(board.points);
    }
}
