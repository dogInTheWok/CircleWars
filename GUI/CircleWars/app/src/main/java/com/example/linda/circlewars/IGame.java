package com.example.linda.circlewars;

/**
 * Created by Linda on 04.10.2014.
 */
public interface IGame {
    public enum FIELD{
        FIELD1,
        FIELD2,
        FIELD3,
        FIELD4,
        FIELD5,
        FIELD6,
        FIELD7,
        FIELD8,
        FIELD9,
        FIELD10,
        FIELD11,
        FIELD12
    }

    void dispatchForce(FIELD fieldId);
}
