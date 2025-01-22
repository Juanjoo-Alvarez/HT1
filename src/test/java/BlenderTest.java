import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class BlenderTest {
    private Blender blender;

    @BeforeEach
    public void setUp() {
        blender = new Blender();
    }

    @Test
    public void testIncreaseSpeed() {
        blender.switchPowerStatus(); // Enciende la licuadora
        blender.fillBlender("Fruit", 500); // Llena la licuadora

        blender.increaseSpeed();
        assertEquals(1, blender.checkSpeed());

        blender.increaseSpeed();
        assertEquals(2, blender.checkSpeed());

        // Prueba para no exceder la velocidad máxima
        for (int i = 0; i < 10; i++) {
            blender.increaseSpeed();
        }
        assertEquals(3, blender.checkSpeed());
    }

    @Test
    public void testDecreaseSpeed() {
        blender.switchPowerStatus(); // Enciende la licuadora
        blender.fillBlender("Fruit", 500); // Llena la licuadora

        blender.increaseSpeed();
        blender.increaseSpeed();
        assertEquals(2, blender.checkSpeed());

        blender.decreaseSpeed();
        assertEquals(1, blender.checkSpeed());

        blender.decreaseSpeed();
        assertEquals(0, blender.checkSpeed());

        // Prueba para no bajar de la velocidad mínima
        blender.decreaseSpeed();
        assertEquals(0, blender.checkSpeed());
    }

    @Test
    public void testCheckSpeed() {
        assertEquals(0, blender.checkSpeed()); // Velocidad inicial

        blender.switchPowerStatus(); // Enciende la licuadora
        blender.fillBlender("Fruit", 500); // Llena la licuadora

        blender.increaseSpeed();
        assertEquals(1, blender.checkSpeed());

        blender.increaseSpeed();
        assertEquals(2, blender.checkSpeed());
    }
}