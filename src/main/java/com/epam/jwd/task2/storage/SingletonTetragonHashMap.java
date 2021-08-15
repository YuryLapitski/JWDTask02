package com.epam.jwd.task2.storage;

import com.epam.jwd.task2.entity.TetragonRegistrator;

import java.util.HashMap;

public class SingletonTetragonHashMap
{
    private static SingletonTetragonHashMap singl;
    private final HashMap<Integer, TetragonRegistrator> hashMap = new HashMap<Integer, TetragonRegistrator>();

    public static SingletonTetragonHashMap getInstance()
    {
        if (singl == null)
        {
            singl = new SingletonTetragonHashMap();
        }
        return singl;
    }

    public HashMap<Integer, TetragonRegistrator> getMap()
    {
        return this.hashMap;
    }

    public void addToMap(Integer id, TetragonRegistrator tetrReg)
    {
        hashMap.put(id, tetrReg);
    }

}
