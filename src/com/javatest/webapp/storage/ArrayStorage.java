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
    }

    public void update(Resume r) {
        Resume res = get(r.uuid);
        if (res != null) {

        }

    }

    public void save(Resume r) {
        Resume res = get(r.uuid);
        if (res != null) {
            storage[size] = r;
            size++;
        }

    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        Resume res = get(uuid);
        if (res != null) {
            for (int i = 0; i < size; i++) {
                if (storage[i].toString().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
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
}
