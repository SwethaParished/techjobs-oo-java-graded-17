package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void emptyTest(){
        assertEquals(true,  true);
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));;
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));;
        assertNotEquals(job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        //name

        String expected = "Product tester";
        String actual = job1.getName();
        assertEquals(expected,actual);

        //employer
        assertEquals("ACME",job1.getEmployer().getValue());

        //location
        assertEquals("Desert",job1.getLocation().getValue());

        //positionType
        assertEquals("Quality Control",job1.getPositionType().getValue());

        //core competency
        assertEquals("Persistence",job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        boolean expected = false;
        boolean actual = job1.equals(job2);
        assertEquals(actual,expected);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String newline = System.lineSeparator();
        Job job2 = new Job();
        String expected = newline + newline;
        String actual = job2.toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String newline = System.lineSeparator();
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = newline + "ID: 4" + newline +
                "Name: Product tester" + newline +
                "Employer: ACME" + newline +
                "Location: Desert" + newline +
                "Position Type: Quality control" + newline +
                "Core Competency: Persistence" + newline;
        String actual = job2.toString();
        assertEquals(expected,actual);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String newline = System.lineSeparator();
        Job job3 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = newline + "ID: 3" + newline +
                "Name: Product tester" + newline +
                "Employer: Data not available" + newline +
                "Location: Desert" + newline +
                "Position Type: Quality control" + newline +
                "Core Competency: Persistence"+newline;

        String actual = job3.toString();
        assertEquals(expected,actual);
    }

}
