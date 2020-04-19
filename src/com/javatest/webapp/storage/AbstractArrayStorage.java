package com.javatest.webapp.storage;

import com.javatest.webapp.exception.ExistStorageException;
import com.javatest.webapp.exception.NotExistStorageException;
import com.javatest.webapp.exception.StorageException;
import com.javatest.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int indexUuid = getIndex(uuid);
        if (indexUuid < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[indexUuid];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else if (size == storage.length) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int indexUuid = getIndex(uuid);
        if (indexUuid < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            fillDeletedElement(indexUuid);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void fillDeletedElement(int indexUuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract int getIndex(String uuid);
}
