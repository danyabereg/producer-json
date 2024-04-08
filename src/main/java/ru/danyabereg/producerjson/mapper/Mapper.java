package ru.danyabereg.producerjson.mapper;

public interface Mapper <F, T>{
    T mapFrom(F dto);
    F mapTo(T entity);
}
