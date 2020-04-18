package com.javatest.webapp.storage;

import com.javatest.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


    public void clear() {
        Arrays.fill(storage, 0, size, null);
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
        return Arrays.copyOfRange(storage, 0, size);
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
