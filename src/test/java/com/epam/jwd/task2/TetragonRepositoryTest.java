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
import com.epam.jwd.task2.exception.DataFileException;
import com.epam.jwd.task2.repository.Repository;
import com.epam.jwd.task2.repository.impl.*;
import com.epam.jwd.task2.storage.SingletonTetragonList;
import java.util.ArrayList;
import java.util.List;
import static org.testng.AssertJUnit.fail;

public class TetragonRepositoryTest
{
    EntityCreator creator;
    ParamOfTetragon action;
    ArrayList<String> coordinatesArr;
    ArrayList<Double> validCoordinatesArr;
    ArrayList<Point> pointsArr;

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
    }

    @AfterMethod
    public void singletonClear()
    {
        SingletonTetragonList.getInstance().getList().clear();
    }

    @Test
    public void areaSpecificationTest()
    {
        List resultTetr;
        try
        {
            coordinatesArr = creator.getPoints("coordinates.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));
            SingletonTetragonList.getInstance().addToList(newTetr1);
            SingletonTetragonList.getInstance().addToList(newTetr2);

            Repository rep=new TetragonRepository();
            TetragonSpecificationByArea specification=new TetragonSpecificationByArea(10,200);
            resultTetr=rep.query(specification);
            Assert.assertEquals(resultTetr.size(), 1);
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }

    @Test
    public void perimeterSpecificationTest()
    {
        List<Tetragon> resultTetr;
        try
        {
            coordinatesArr = creator.getPoints("coordinates.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));
            SingletonTetragonList.getInstance().addToList(newTetr1);
            SingletonTetragonList.getInstance().addToList(newTetr2);
            TetragonRepository rep=new TetragonRepository();
            TetragonSpecificationByPerimeter specification=new TetragonSpecificationByPerimeter(8,50);
            resultTetr=rep.query(specification);
            Assert.assertEquals(resultTetr.size(), 2);
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }

    @Test
    public void trapezeSpecificationTest()
    {
        List<Tetragon> resultTetr;
        try
        {
            coordinatesArr = creator.getPoints("coordinates.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));
            SingletonTetragonList.getInstance().addToList(newTetr1);
            SingletonTetragonList.getInstance().addToList(newTetr2);
            TetragonRepository rep=new TetragonRepository();
            TetragonSpecificationTrapeze specification=new TetragonSpecificationTrapeze();
            resultTetr=rep.query(specification);
            Assert.assertEquals(resultTetr.size(), 1);
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }

    @Test
    public void comparatorByPerimeterTest()
    {
        List<Tetragon> resultTetr;
        try
        {
            coordinatesArr = creator.getPoints("coordinates.txt");
            validCoordinatesArr = creator.pointsParser(coordinatesArr);
            pointsArr = creator.pointsCreator(validCoordinatesArr);
            Tetragon newTetr1= creator.createTetragon(1,pointsArr.get(0),pointsArr.get(1),pointsArr.get(2),pointsArr.get(3));
            Tetragon newTetr2= creator.createTetragon(2,pointsArr.get(4),pointsArr.get(5),pointsArr.get(6),pointsArr.get(7));
            SingletonTetragonList.getInstance().addToList(newTetr1);
            SingletonTetragonList.getInstance().addToList(newTetr2);
            resultTetr= SingletonTetragonList.getInstance().getList();
        }
        catch (DataFileException ex)
        {
            fail();
        }
    }
}

