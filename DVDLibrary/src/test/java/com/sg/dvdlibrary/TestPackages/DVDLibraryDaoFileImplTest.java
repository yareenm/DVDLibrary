package com.sg.dvdlibrary.TestPackages;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.dto.DVDLibrary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DVDLibraryDaoFileImplTest {

    DVDLibraryDao testDao;

    @BeforeEach
    void setUp() throws Exception {
        String testFile = "testdvdlibrary.txt";
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetDVD()throws Exception{
        //create my method test inputs
        String title = "Start of Something New";
        DVDLibrary dvd = new DVDLibrary(title);
        dvd.setReleaseDate("2023");
        dvd.setDirectorName("Yaren Menemenci");
        dvd.setStudio("Tampa Studios");
        dvd.setMpaaRating("10");
        dvd.setNote("LET THE JOURNEY BEGIN");

        //add the dvd to the dao
        testDao.addDVD(title,dvd);
        //get the dvd from the dao
        DVDLibrary getDVD = testDao.getDVDByTitle(title);

        //check the data is equal
        assertEquals(dvd.getTitle(),getDVD.getTitle(),"Checking dvd title");
        assertEquals(dvd.getNote(),getDVD.getNote(),"Checking the note");
        assertEquals(dvd.getDirectorName(),getDVD.getDirectorName(),"Checking the director name");
        assertEquals(dvd.getStudio(),getDVD.getStudio(),"Checking the studio");
        assertEquals(dvd.getMpaaRating(),getDVD.getMpaaRating(),"Checking the mpaa rating");
        assertEquals(dvd.getReleaseDate(),getDVD.getReleaseDate(),"Checking the release date");

    }

    @Test
    public void testAddGetAllDVDs()throws Exception{
        String title1 = "Start of Something New";
        DVDLibrary dvd1 = new DVDLibrary(title1);
        dvd1.setReleaseDate("2023");
        dvd1.setDirectorName("Yaren Menemenci");
        dvd1.setStudio("Tampa Studios");
        dvd1.setMpaaRating("10");
        dvd1.setNote("LET THE JOURNEY BEGIN");

        String title2 = "Start of Something New2";
        DVDLibrary dvd2 = new DVDLibrary(title2);
        dvd2.setReleaseDate("2023");
        dvd2.setDirectorName("Yaren");
        dvd2.setStudio("Tampa");
        dvd2.setMpaaRating("9");
        dvd2.setNote("LET THE JOURNEY BEGINS");


        testDao.addDVD(dvd1.getTitle(),dvd1);
        testDao.addDVD(dvd2.getTitle(),dvd2);

        List<DVDLibrary> allDvds = testDao.getAllDVDs();

        assertNotNull(allDvds,"The list of dvds must not null");
        assertEquals(2,allDvds.size(),"List of dvds should have 2 dvd");

        assertTrue(testDao.getAllDVDs().contains(dvd1),"The list of dvds should include DVD1");
        assertTrue(testDao.getAllDVDs().contains(dvd2),"The list of dvds should include DVD2");

    }

    @Test
    public void testRemoveDVD() throws Exception{
        String title1 = "Start of Something New";
        DVDLibrary dvd1 = new DVDLibrary(title1);
        dvd1.setReleaseDate("2023");
        dvd1.setDirectorName("Yaren Menemenci");
        dvd1.setStudio("Tampa Studios");
        dvd1.setMpaaRating("10");
        dvd1.setNote("LET THE JOURNEY BEGIN");

        String title2 = "Start of Something New2";
        DVDLibrary dvd2 = new DVDLibrary(title2);
        dvd2.setReleaseDate("2023");
        dvd2.setDirectorName("Yaren");
        dvd2.setStudio("Tampa");
        dvd2.setMpaaRating("9");
        dvd2.setNote("LET THE JOURNEY BEGINS");


        testDao.addDVD(dvd1.getTitle(),dvd1);
        testDao.addDVD(dvd2.getTitle(),dvd2);

        DVDLibrary removedDVD = testDao.removeDVD(dvd1.getTitle());
        List<DVDLibrary> allDvds = testDao.getAllDVDs();

        assertNotNull(allDvds,"The list of dvds must not null");
        assertEquals(1,allDvds.size(),"List of dvds should have 1 dvd");

        assertFalse(testDao.getAllDVDs().contains(dvd1),"The list of dvds should not include DVD1");
        assertTrue(testDao.getAllDVDs().contains(dvd2),"The list of dvds should include DVD2");

    }
}

