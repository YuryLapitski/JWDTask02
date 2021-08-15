package com.epam.jwd.task2.repository.impl;

import com.epam.jwd.task2.action.ParamOfTetragon;
import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.exception.IncorrectDataException;
import com.epam.jwd.task2.repository.TetragonSpecification;

public class TetragonSpecificationByPerimeter implements TetragonSpecification
{
    private double minPerim,maxPerim;
    ParamOfTetragon tetrAct=new ParamOfTetragon();

    public TetragonSpecificationByPerimeter(double minPerim, double maxPerim)
    {
        this.minPerim=minPerim;
        this.maxPerim=maxPerim;
    }

    @Override
    public boolean isSpecified(Tetragon newTetr) throws IncorrectDataException
    {
        return ((tetrAct.calcPerimeter(newTetr)>=minPerim)&(tetrAct.calcPerimeter(newTetr)<=maxPerim));
    }
}
