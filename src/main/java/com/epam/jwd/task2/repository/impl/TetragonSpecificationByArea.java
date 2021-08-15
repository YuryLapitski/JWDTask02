package com.epam.jwd.task2.repository.impl;

import com.epam.jwd.task2.action.ParamOfTetragon;
import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.exception.IncorrectDataException;
import com.epam.jwd.task2.repository.TetragonSpecification;

public class TetragonSpecificationByArea implements TetragonSpecification
{
    private double minArea,maxArea;
    ParamOfTetragon tetrAct=new ParamOfTetragon();

    public TetragonSpecificationByArea(double minArea, double maxArea)
    {
        this.minArea=minArea;
        this.maxArea=maxArea;
    }

    @Override
    public boolean isSpecified(Tetragon newTetr) throws IncorrectDataException
    {
        return ((tetrAct.calcArea(newTetr)>=minArea&(tetrAct.calcArea(newTetr)<=maxArea)));
    }
}
