package chap6;

import chap11.Symbols;

public interface Environment {
    void put(String name, Object value);
    Object get(String name);
    void putNew(String name, Object value);
    Environment where(String name);
    void setOuter(Environment e);
}
