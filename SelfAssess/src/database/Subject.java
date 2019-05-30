package database;

import controller.Observer;

public interface Subject {

    void register(Observer o);
    void remove(Observer o);
    void notifyObserver();

}
