package com.javatest.webapp.storage;

import com.javatest.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int indexUuid) {
        int numMoved = size - indexUuid - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, indexUuid + 1, storage, indexUuid, numMoved);
        }
    }

    @Override
    protected void insertElement(Resume r, int index) {
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = r;

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
