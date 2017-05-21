package com.cristea.andrei.adneomlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void partition_badParameters1() {
	ListUtils.partition(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void partition_badParameters2() {
	ListUtils.partition(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void partition_badParameters3() {
	ListUtils.partition(new ArrayList<Object>(), 0);
    }

    @Test
    public void partition_emptyList() {
	List<List<Object>> result = ListUtils.partition(new ArrayList<Object>(), 1);
	Assert.assertEquals(0, result.size());
    }

    @Test
    public void partition_1() {
	List<List<Object>> result = ListUtils.partition(Arrays.asList("1", "2", "3", "4", "5"), 1);
	Assert.assertEquals(5, result.size());
	Assert.assertEquals(Arrays.asList("1"), result.get(0));
	Assert.assertEquals(Arrays.asList("2"), result.get(1));
	Assert.assertEquals(Arrays.asList("3"), result.get(2));
	Assert.assertEquals(Arrays.asList("4"), result.get(3));
	Assert.assertEquals(Arrays.asList("5"), result.get(4));
    }

    @Test
    public void partition_2() {
	List<List<Object>> result = ListUtils.partition(Arrays.asList("1", "2", "3", "4", "5"), 2);
	Assert.assertEquals(3, result.size());
	Assert.assertEquals(Arrays.asList("1", "2"), result.get(0));
	Assert.assertEquals(Arrays.asList("3", "4"), result.get(1));
	Assert.assertEquals(Arrays.asList("5"), result.get(2));
    }

    @Test
    public void partition_3() {
	List<List<Object>> result = ListUtils.partition(Arrays.asList("1", "2", "3", "4", "5"), 3);
	Assert.assertEquals(2, result.size());
	Assert.assertEquals(Arrays.asList("1", "2", "3"), result.get(0));
	Assert.assertEquals(Arrays.asList("4", "5"), result.get(1));
    }

    @Test
    public void partition_immutable() {
	List<String> list = Arrays.asList("1", "2", "3", "4", "5");
	List<List<Object>> result = ListUtils.partition(list, 3);
	Assert.assertEquals(2, result.size());
	Assert.assertEquals(Arrays.asList("1", "2", "3"), result.get(0));
	Assert.assertEquals(Arrays.asList("4", "5"), result.get(1));
	list.set(1, "X"); // <<----
	Assert.assertEquals(Arrays.asList("1", "2", "3"), result.get(0));
    }

    @Test
    public void partition_mutable() {
	List<Date> list = Arrays.asList(new Date(0), new Date(1));
	List<List<Object>> result = ListUtils.partition(list, 2);
	Assert.assertEquals(1, result.size());
	Assert.assertEquals(Arrays.asList(new Date(0), new Date(1)), result.get(0));
	list.get(1).setTime(2); // <<----
	Assert.assertEquals(Arrays.asList(new Date(0), new Date(2)), result.get(0));
    }
}
