package com.epam.jwd.task2.repository;

import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.exception.IncorrectDataException;

public interface TetragonSpecification
{
    boolean isSpecified(Tetragon newTetr) throws IncorrectDataException;
}
