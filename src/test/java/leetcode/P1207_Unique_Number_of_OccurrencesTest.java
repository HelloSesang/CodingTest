package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class P1207_Unique_Number_of_OccurrencesTest {

    @Test
    public void uniqueOccurrences() {
        P1207_Unique_Number_of_Occurrences obj = new P1207_Unique_Number_of_Occurrences();
        boolean result = obj.uniqueOccurrences(new int[]{1, 2});
        assertEquals(false, result);
    }
}