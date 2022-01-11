import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeTest {
    Snake snake;

    @BeforeEach
    public void createSnake() {
        snake = new Snake(0,0);
    }

    @Test
    public void testDown() {
        snake.moveDown();
        assertEquals(1, snake.getPosition().getY());
    }

    @Test
    public void testUp() {
        snake.moveUp();
        assertEquals(-1, snake.getPosition().getY());
    }

    @Test
    public void testLeft() {
        snake.moveLeft();
        assertEquals(-1, snake.getPosition().getX());
    }

    @Test
    public void testRight() {
        snake.moveRight();
        assertEquals(1, snake.getPosition().getX());
    }

}