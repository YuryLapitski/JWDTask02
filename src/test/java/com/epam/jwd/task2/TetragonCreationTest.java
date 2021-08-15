package com.epam.jwd.task2;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.epam.jwd.task2.creation.EntityCreator;
import com.epam.jwd.task2.entity.Point;
import com.epam.jwd.task2.exception.DataFileException;

import java.util.ArrayList;

import static org.testng.AssertJUnit.fail;

public class TetragonCreationTest
{
    EntityCreator creator;
    ArrayList<String> coordinatesArr;
    ArrayList<Double> validCoordinatesArr;
    ArrayList<Point> pointsArr;

    @BeforeClass
    public void setParam()
    {
        creator=new EntityCreator();
    }

    @AfterClass
    public void clearParam()
    {
        EntityCreator creator=null;
        ArrayList<String> coordinatesArr=null;
        ArrayList<Double> validCoordinatesArr=null;
        ArrayList<Point> pointsArr=null;
    }

    @Test
    public void noFileTest()
    {
        final String EXPECTED="No file found: abc";
        try
        {
            coordinatesArr=creator.getPoints("abc");
            fail("Should have thrown a DataFileException(No file found)");
        }
        catch (DataFileException ex)
        {
            Assert.assertEquals(EXPECTED,ex.getMessage());
        }
    }

    @Test
    public void noFileNameTest()
    {
        final String EXPECTED="Empty file name";
        try
        {
            coordinatesArr=creator.getPoints("");
            fail("Should have thrown a DataFileException(Empty file name)");
        }
        catch (DataFileException ex)
        {
            Assert.assertEquals(EXPECTED,ex.getMessage());
        }
    }

    @Test
    public void emptyFileTest()
    {
        final String EXPECTED="File is empty: empty.txt";
        try
        {
            coordinatesArr=creator.getPoints("empty.txt");
            fail("Should have thrown a DataFileException(File is empty)");
        }
        catch (DataFileException ex)
        {
            Assert.assertEquals(EXPECTED,ex.getMessage());
        }
    }

    @Test
    public void notEnoughtCoordinatesTest()
    {
        final String EXPECTED="Not enought coordinates to create a tetragon";
        try
        {
            coordinatesArr = creator.getPoints("3points.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            System.out.println(validCoordinatesArr.size());
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            fail("Should have thrown a DataFileException(Not enought coordinates to create a tetragon)");
        }
        catch (DataFileException ex)
        {
            Assert.assertEquals(EXPECTED,ex.getMessage());
        }
    }

    @Test
    public void pointsCreationTest()
    {
        final int EXPECTED=8;
        try
        {
            coordinatesArr = creator.getPoints("coordinates.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            Assert.assertEquals(EXPECTED, pointsArr.size());
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }

}
