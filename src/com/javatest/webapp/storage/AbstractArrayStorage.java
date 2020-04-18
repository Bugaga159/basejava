package com.javatest.webapp.storage;

import com.javatest.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }
    public Resume get(String uuid) {
        int indexUuid = getIndex(uuid);
        if (indexUuid == -1) {
            System.out.println("ERROR! Resume " + uuid + "not exist!");
            return null;
        }
        return storage[indexUuid];
    }

    protected abstract int getIndex(String uuid);
}
