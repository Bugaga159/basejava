package com.javatest.webapp.storage;

import com.javatest.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    protected Resume[] storage = new Resume[10000];
    protected int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("ERROR! Resume" + r.getUuid() + "not exist!");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("ERROR! Resume" + r.getUuid() + "already exist!");
        } else if (size == storage.length) {
            System.out.println("Storage overflow!");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int indexUuid = getIndex(uuid);
        if (indexUuid == -1) {
            System.out.println("ERROR! Resume " + uuid + "not exist!");
            return null;
        }
        return storage[indexUuid];
    }

    public void delete(String uuid) {
        int indexUuid = getIndex(uuid);
        if (indexUuid == -1) {
            System.out.println("ERROR!");
        } else {
            storage[indexUuid] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] res = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            res[i] = storage[i];
        }
        return res;
    }

    public int size() {
        return size;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
