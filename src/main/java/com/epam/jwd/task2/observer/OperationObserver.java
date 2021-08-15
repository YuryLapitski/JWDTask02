package com.epam.jwd.task2.observer;

import com.epam.jwd.task2.entity.Tetragon;

public interface OperationObserver
{
    void pointChangeHandle(Tetragon tetragon);
}
