package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shapes.Circle;
import shapes.Shape;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IOUtilTest {
    String pathFileInput;
    String pathFileInput2;
    String pathFileInput3;

    @BeforeEach
    void setUp() {
        pathFileInput = "src/test/resources/test1";
        pathFileInput2 = "src/test/resources/test2";
        pathFileInput3 = "src/test/resources/test3";
    }

    @Test
    void readShapesFromFile() {
        ArrayList<Shape> actual = new ArrayList<>();

        actual.add(new Circle(1));

        ArrayList<Shape> expected = new ArrayList<>();

        IOUtil.readShapesFromFile(pathFileInput, expected);


        assertEquals(expected, actual);
        assertNotNull(expected);
    }

    @Test
    void readShapesFromFileIfDataNull() {
        ArrayList<Shape> expected = new ArrayList<>();

        IOUtil.readShapesFromFile(pathFileInput2, expected);

        assertEquals(0, expected.size());
    }

    @Test
    void readShapesFromFileIfDataInvalid() {
        ArrayList<Shape> expected = new ArrayList<>();

        IOUtil.readShapesFromFile(pathFileInput3, expected);

        assertEquals(0, expected.size());
    }
}