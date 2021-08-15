package com.epam.jwd.task2;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.epam.jwd.task2.action.ParamOfTetragon;
import com.epam.jwd.task2.creation.EntityCreator;
import com.epam.jwd.task2.entity.Point;
import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.entity.TetragonRegistrator;
import com.epam.jwd.task2.exception.DataFileException;
import com.epam.jwd.task2.exception.IncorrectDataException;
import com.epam.jwd.task2.observer.TetragonHandler;
import com.epam.jwd.task2.storage.SingletonTetragonHashMap;
import java.util.ArrayList;
import static org.testng.AssertJUnit.fail;

public class TetragonObserverTest
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
        ArrayList<String> coordinatesArr=null;
        ArrayList<Double> validCoordinatesArr=null;
        ArrayList<Point> pointsArr=null;
        Tetragon newTetr=null;
    }

    @AfterMethod
    public void singletonClear()
    {
        SingletonTetragonHashMap.getInstance().getMap().clear();
    }

    @Test
    public void observerPositiveTest()
    {
        final double EXPECTED_AREA = 12;
        final double EXPECTED_PERIMETER = 14;
        final int ID=1;
        double actual_area, actual_perimeter;
        try
        {
            coordinatesArr = creator.getPoints("coordinates.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            newTetr = creator.createTetragon(ID,pointsArr.get(0), pointsArr.get(1), pointsArr.get(2), pointsArr.get(3));
            TetragonHandler tetrHand = new TetragonHandler();
            newTetr.addObserver(tetrHand);
            TetragonRegistrator tetrReg = new TetragonRegistrator(action.calcArea(newTetr),action.calcPerimeter(newTetr));
            SingletonTetragonHashMap.getInstance().addToMap(newTetr.getId(), tetrReg);
            newTetr.setPoint1(new Point(1, 2));
            actual_area=tetrReg.getArea();
            actual_perimeter=tetrReg.getPerimeter();
            Assert.assertTrue((actual_area==EXPECTED_AREA)&(actual_perimeter==EXPECTED_PERIMETER));
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
    public void observerNegativeTest()
    {
        final int ID=1;
        double old_area, old_perimeter;
        try
        {
            coordinatesArr = creator.getPoints("coordinates.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            newTetr = creator.createTetragon(ID,pointsArr.get(0), pointsArr.get(1), pointsArr.get(2), pointsArr.get(3));
            TetragonHandler tetrHand = new TetragonHandler();
            newTetr.addObserver(tetrHand);
            TetragonRegistrator tetrReg = new TetragonRegistrator(action.calcArea(newTetr),action.calcPerimeter(newTetr));
            SingletonTetragonHashMap.getInstance().addToMap(newTetr.getId(), tetrReg);
            old_area=tetrReg.getArea();
            old_perimeter=tetrReg.getPerimeter();
            newTetr.setPoint2(new Point(10, 10));
            Assert.assertFalse((old_area==tetrReg.getArea())&(old_perimeter==tetrReg.getPerimeter()));
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
