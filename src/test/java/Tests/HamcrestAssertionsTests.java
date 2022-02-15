package Tests;

import CustomMatchers.IsPositiveInteger;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestAssertionsTests {

    Employee employee1 = new Employee(1,"Katarzyna",2);
    Employee employee2 = new Employee(1,"KATARZYNA",2);
    Employee employee3 = new Employee(1,"Katarzyna",2);

    List<Employee> employees = Arrays.asList(
            employee1, employee2, employee3);

    //Object matcher
    @Test
    public void testEquals() {
        assertThat(employee1, equalTo(employee2));
    }

    @Test
    public void given2Strings_whenEqual_thenCorrect() {
        assertThat(employee1.getName(), equalToIgnoringCase(employee2.getName()));
    }

    //Bean matcher

    @Test
    public void givenBean_whenHasValue_thenCorrect() {
        assertThat(employee1, hasProperty("name"));
    }

    @Test
    public void givenBean_whenHasCorrectValue_thenCorrect() {
        assertThat(employee1, samePropertyValuesAs(employee3));
    }

    //Collection Matcher

    @Test
    public void givenCollection_whenEmpty_thenCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void givenAList_whenChecksSize_thenCorrect() {
        assertThat(employees, hasSize(3));
    }

    @Test
    public void givenAListAndValues_whenChecksListForGivenValues_thenCorrect() {
        assertThat(employees,
                containsInAnyOrder(employee2, employee1, employee3));
    }

    @Test
    public void givenAListAndValues_whenChecksListForGivenValuesWithOrder_thenCorrect() {
        assertThat(employees,
                contains(employee1, employee2, employee3));
    }

    @Test
    public void givenMapAndKey_whenKeyFoundInMap_thenCorrect() {

        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("Poland", "Warsaw");
        assertThat(capitalCities, hasKey("Poland"));
    }

    @Test
    public void givenMapAndValue_whenValueFoundInMap_thenCorrect() {
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("Poland", "Warsaw");
        assertThat(capitalCities, hasValue("Warsaw"));
    }

    @Test
    public void givenMapAndEntry_whenEntryFoundInMap_thenCorrect() {
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("Poland", "Warsaw");
        assertThat(capitalCities, hasEntry("Poland", "Warsaw"));
    }

    //Number Matcher

    @Test
    public void givenAnInteger_whenGreaterThan0_thenCorrect() {
        assertThat(1, greaterThan(0));
    }

    @Test
    public void givenAnInteger_whenGreaterThanOrEqTo5_thenCorrect() {
        assertThat(5, greaterThanOrEqualTo(5));
    }

    @Test
    public void givenAnInteger_whenLessThan0_thenCorrect() {
        assertThat(-1, lessThan(0));
    }

    @Test
    public void givenAnInteger_whenLessThanOrEqTo5_thenCorrect() {
        assertThat(-1, lessThanOrEqualTo(5));
    }

    @Test
    public void givenADouble_whenCloseTo_thenCorrect() {
        assertThat(1.2, closeTo(1, 0.5));
    }

    //Text Matcher

    @Test
    public void givenString_whenEmpty_thenCorrect() {
        String str = "";
        assertThat(str, is(emptyString()));
    }

    @Test
    public void givenString_whenEmptyOrNull_thenCorrect() {
        String str = null;
        assertThat(str, is(emptyOrNullString()));
    }

    @Test
    public void given2Strings_whenEqualRegardlessWhiteSpace_thenCorrect() {
        String str1 = "text";
        String str2 = " text ";
        assertThat(str1, equalToCompressingWhiteSpace(str2));
    }

    @Test
    public void givenString_whenContainsGivenSubstring_thenCorrect() {
        String str = "calligraphy";
        assertThat(str, stringContainsInOrder(Arrays.asList("call", "graph")));
    }

    @Test
    public void given2Strings_whenEqual_thenCorrect_IgnoreCase() {
        String a = "foo";
        String b = "FOO";
        assertThat(a, equalToIgnoringCase(b));
    }

    //Core API

    @Test
    public void given2Strings_whenIsEqualRegardlessWhiteSpace_thenCorrect() {
        String str1 = "text";
        String str2 = " text ";
        assertThat(str1, is(equalToCompressingWhiteSpace(str2)));
    }

    @Test
    public void given2Strings_whenIsEqual_thenCorrect() {
        String str1 = "text";
        String str2 = "text";
        assertThat(str1, is(str2));
    }

    @Test
    public void given2Strings_whenIsNotEqualRegardlessWhiteSpace_thenCorrect() {
        String str1 = "text";
        String str2 = " texts ";
        assertThat(str1, not(equalToCompressingWhiteSpace(str2)));
    }

    @Test
    public void given2Strings_whenNotEqual_thenCorrect() {
        String str1 = "text";
        String str2 = "texts";
        assertThat(str1, not(str2));
    }

    @Test
    public void givenAStrings_whenContainsAnotherGivenString_thenCorrect() {
        String str1 = "calligraphy";
        String str2 = "call";
        assertThat(str1, containsString(str2));
    }

    @Test
    public void givenAString_whenStartsWithAnotherGivenString_thenCorrect() {
        String str1 = "calligraphy";
        String str2 = "call";
        assertThat(str1, startsWith(str2));
    }

    @Test
    public void givenAString_whenEndsWithAnotherGivenString_thenCorrect() {
        String str1 = "calligraphy";
        String str2 = "phy";
        assertThat(str1, endsWith(str2));
    }

    @Test
    public void given2Objects_whenSameInstance_thenCorrect() {
        assertThat(employee1, sameInstance(employee1));
    }

    @Test
    public void givenAnObject_whenInstanceOfGivenClass_thenCorrect() {
        assertThat(employee1, instanceOf(Employee.class));
    }

    @Test
    public void givenList_whenEachElementGreaterThan0_thenCorrect() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int baseCase = 0;
        assertThat(list, everyItem(greaterThan(baseCase)));
    }

    @Test
    public void givenString_whenNotNull_thenCorrect() {
        String str = "notnull";
        assertThat(str, notNullValue());
    }

    @Test
    public void givenString_whenMeetsAnyOfGivenConditions_thenCorrect() {
        String str = "calligraphy";
        String start = "call";
        String end = "foo";
        assertThat(str, anyOf(startsWith(start), containsString(end)));
    }

    @Test
    public void givenString_whenMeetsAllOfGivenConditions_thenCorrect() {
        String str = "calligraphy";
        String start = "call";
        String end = "phy";
        assertThat(str, allOf(startsWith(start), endsWith(end)));
    }

    //Custom Matcher

    @Test
    public void givenInteger_whenAPositiveValue_thenCorrect() {
        int num = 1;
        assertThat(num, IsPositiveInteger.isAPositiveInteger());
    }
}
