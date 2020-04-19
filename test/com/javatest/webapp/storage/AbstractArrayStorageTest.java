package com.javatest.webapp.storage;

import com.javatest.webapp.exception.NotExistStorageException;
import com.javatest.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {


    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp(){
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
    }

    @Test
    public void update() {
    }

    @Test
    public void size() {
    }

    @Test
    public void get() {
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

}