package com.epam.jwd.task2.repository;

import java.util.List;

public interface Repository
{
    List query(TetragonSpecification specification);
}
