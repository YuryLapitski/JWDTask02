package com.epam.jwd.task2;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.epam.jwd.task2.action.ParamOfTetragon;
import com.epam.jwd.task2.creation.EntityCreator;
import com.epam.jwd.task2.entity.Point;
import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.exception.DataFileException;
import com.epam.jwd.task2.exception.IncorrectDataException;

import java.util.ArrayList;

import static org.testng.AssertJUnit.fail;

public class TetragonActionTest
{
    EntityCreator creator;
    ParamOfTetragon action;
    ArrayList<String> coordinatesArr;
    ArrayList<Double> validCoordinatesArr;
    ArrayList<Point> pointsArr;
    Tetragon newTetr;

    @BeforeClass
    public void setParam()
    {
        creator=new EntityCreator();
        action=new ParamOfTetragon();
    }

    @AfterClass
    public void clearParam()
    {
        EntityCreator creator=null;
        ParamOfTetragon action=null;
        ArrayList<String> coordinatesArr=null;
        ArrayList<Double> validCoordinatesArr=null;
        ArrayList<Point> pointsArr=null;
        Tetragon newTetr=null;
    }

    @Test
    public void squareTest()
    {
        final boolean EXPECTED=true;
        final int ID=1;
        boolean actual;
        try
        {
            coordinatesArr = creator.getPoints("square.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            newTetr= creator.createTetragon(ID,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            actual=action.isSquare(newTetr);
            Assert.assertEquals(EXPECTED, actual);
        }
        catch (DataFileException ex)
        {
            fail();
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

    @Test
    public void notTetragonTest()
    {
        final boolean EXPECTED=false;
        final int ID=1;
        boolean actual;
        try
        {
            coordinatesArr = creator.getPoints("nonTetr.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            newTetr= creator.createTetragon(ID,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            actual=action.isTetragon(newTetr);
            Assert.assertEquals(EXPECTED, actual);
        }
        catch (DataFileException ex)
        {
            fail();
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

    @Test
    public void notConvexTest()
    {
        final boolean EXPECTED=false;
        final int ID=1;
        boolean actual;
        try
        {
            coordinatesArr = creator.getPoints("nonCon.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            newTetr= creator.createTetragon(ID,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            actual=action.isConvex(newTetr);
            Assert.assertEquals(EXPECTED, actual);
        }
        catch (DataFileException ex)
        {
            fail();
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

    @Test
    public void rhombTest()
    {
        final boolean EXPECTED=true;
        final int ID=1;
        boolean actual;
        try
        {
            coordinatesArr = creator.getPoints("square.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            newTetr= creator.createTetragon(ID,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            actual=action.isRhomb(newTetr);
            Assert.assertEquals(EXPECTED, actual);
        }
        catch (DataFileException ex)
        {
            fail();
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

    @Test
    public void areaTest()
    {
        final double EXPECTED=4;
        final int ID=1;
        double actual;
        try
        {
            coordinatesArr = creator.getPoints("trapeze.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            newTetr= creator.createTetragon(ID,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            actual=action.calcArea(newTetr);
            Assert.assertEquals(EXPECTED, actual);
        }
        catch (DataFileException ex)
        {
            fail()
            ;
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

    @Test
    public void perimeterTest()
    {
        final double EXPECTED=8.47213595499958;
        final int ID=1;
        double actual;
        try
        {
            coordinatesArr = creator.getPoints("trapeze.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            newTetr= creator.createTetragon(ID,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            actual=action.calcPerimeter(newTetr);
            Assert.assertEquals(EXPECTED, actual);
        }
        catch (DataFileException ex)
        {
            fail();
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

    @Test
    public void trapezeTest()
    {
        final boolean EXPECTED=true;
        final int ID=1;
        boolean actual;
        try
        {
            coordinatesArr = creator.getPoints("trapeze.txt");
            validCoordinatesArr=creator.pointsParser(coordinatesArr);
            pointsArr=creator.pointsCreator(validCoordinatesArr);
            newTetr= creator.createTetragon(ID,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            actual=action.isTrapeze(newTetr);
            Assert.assertEquals(EXPECTED, actual);
        }
        catch (DataFileException ex)
        {
            fail();
        }
        catch (IncorrectDataException ex)
        {
            fail();
        }
    }

}
