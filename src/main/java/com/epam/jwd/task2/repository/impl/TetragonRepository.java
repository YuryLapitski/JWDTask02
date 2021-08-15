package com.epam.jwd.task2.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.exception.IncorrectDataException;
import com.epam.jwd.task2.repository.Repository;
import com.epam.jwd.task2.repository.TetragonSpecification;
import com.epam.jwd.task2.storage.SingletonTetragonList;

import java.util.ArrayList;
import java.util.List;

public class TetragonRepository implements Repository {
    private static final Logger LOG = LogManager.getLogger(TetragonRepository.class);

    @Override
    public List<Tetragon> query(TetragonSpecification specification)
    {
        List<Tetragon> createdTetr= SingletonTetragonList.getInstance().getList();
        List<Tetragon> resultTetr=new ArrayList<>();
        try
        {
            for (Tetragon tetr : createdTetr)
            {
                if (specification.isSpecified(tetr))
                {
                    resultTetr.add(tetr);
                }
            }
            return resultTetr;
        }
        catch (IncorrectDataException ex)
        {
            LOG.error(ex.getMessage());
            return null;
        }
    }
}

