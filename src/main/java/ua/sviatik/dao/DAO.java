package ua.sviatik.dao;

import java.util.Set;

public interface DAO <T>{
    void saveBatch(Set<T> objects);
//    Set<T> get(String query);

}
