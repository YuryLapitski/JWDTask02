package com.epam.jwd.task2.creation;

import com.epam.jwd.task2.action.ParamOfTetragon;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.jwd.task2.entity.Point;
import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.exception.DataFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EntityCreator
{
    private static final Logger LOG = LogManager.getLogger(EntityCreator.class);

    public ArrayList<String> getPoints(String filePath) throws DataFileException
    {
        Scanner in = null;
        ArrayList<String> coordinatesArr = new ArrayList<>();
        File file = new File(filePath);
        if ((filePath.isEmpty()) | (filePath == null)) {throw new DataFileException("Empty file name");}
        if (!file.exists()) {throw new DataFileException("No file found: ", filePath);}
        if(file.length() == 0) {throw new DataFileException("File is empty: ", filePath);}
        try
        {
            in = new Scanner(file);
            while (in.hasNextLine())
            {
                coordinatesArr.add(in.nextLine());
        }
        }
        catch (FileNotFoundException e)
        {
            throw new DataFileException("No file found: ", filePath);
        }
        finally
        {
            if (in != null)
            {
                in.close();
            }
        }
        return coordinatesArr;
    }

    public ArrayList<Double> pointsParser(ArrayList<String> coordinatessArr)throws DataFileException
    {
        double x, y;
        String str;
        ArrayList<Double> validCoordinatesArr = new ArrayList<>();
        for (int i = 0; i < coordinatessArr.size(); i++)
        {
            str=coordinatessArr.get(i);
            String[] tempStr = str.trim().split("\\s+");
            if (tempStr.length!=2)
            {
                continue;
            }
            try
            {
                x = Double.parseDouble(tempStr[0]);
                y = Double.parseDouble(tempStr[1]);
            }
            catch (NumberFormatException e)
            {
                continue;
            }
            validCoordinatesArr.add(x);
            validCoordinatesArr.add(y);
        }
        return validCoordinatesArr;
    }

    public ArrayList<Point> pointsCreator(ArrayList<Double> validCoordinatesArr)throws DataFileException
    {
        if (validCoordinatesArr.size()<8) {throw new DataFileException("Not enought coordinates to create a tetragon");}
        ArrayList<Point> pointsArr = new ArrayList<>();
        for (int i = 0; i < validCoordinatesArr.size(); i += 2)
        {
            pointsArr.add(new Point(validCoordinatesArr.get(i),validCoordinatesArr.get(i + 1)));
        }
        LOG.info(pointsArr.size()+" Points are created");
        return pointsArr;
    }

    public Tetragon createTetragon(int id, Point point1, Point point2, Point point3, Point point4)
    {
        Tetragon newTetr= new Tetragon(id, point1,point2,point3,point4);
        LOG.info("Tetragon is created");
        return newTetr;
    }
}
