package com.epam.jwd.task2.observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.jwd.task2.action.ParamOfTetragon;
import com.epam.jwd.task2.entity.Tetragon;
import com.epam.jwd.task2.entity.TetragonRegistrator;
import com.epam.jwd.task2.exception.IncorrectDataException;
import com.epam.jwd.task2.storage.SingletonTetragonHashMap;

import java.util.HashMap;

public class TetragonHandler implements OperationObserver {

    private static final Logger LOG = LogManager.getLogger(TetragonHandler.class);

    @Override
    public void pointChangeHandle(Tetragon newTetr)
    {
        HashMap<Integer, TetragonRegistrator> hashMap= SingletonTetragonHashMap.getInstance().getMap();
        TetragonRegistrator tetrReg=hashMap.get(newTetr.getId());
        ParamOfTetragon tetragonAct=new ParamOfTetragon();
        try
        {
            tetrReg.setArea(tetragonAct.calcArea(newTetr));
            tetrReg.setPerimeter(tetragonAct.calcPerimeter(newTetr));
        }
        catch (IncorrectDataException ex)
        {
           LOG.error(ex.getMessage());
        }
    }
}


