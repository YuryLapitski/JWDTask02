package com.epam.jwd.task2.repository.impl;

import com.epam.jwd.task2.action.ParamOfTetragon;
import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.exception.IncorrectDataException;
import com.epam.jwd.task2.repository.TetragonSpecification;

public class TetragonSpecificationTrapeze implements TetragonSpecification
{
    ParamOfTetragon tetrAct=new ParamOfTetragon();

    @Override
    public boolean isSpecified(Tetragon newTetr) throws IncorrectDataException
    {
        return (tetrAct.isTrapeze(newTetr));
    }
}
