package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata1Test {

    public static final String ID = "id";
    public static final String TITLE = "title";

    @Test
    public void testExecute() {
	Assert.assertThat(Kata1.execute().size(), equalTo(4));
    }

    @Test
    public void testExecute1() {
	Assert.assertThat(Kata1.execute(), equalTo(ImmutableList.of(ImmutableMap.of(ID, 70111470, TITLE, "Die Hard"),
		ImmutableMap.of(ID, 654356453, TITLE, "Bad Boys"), ImmutableMap.of(ID, 65432445, TITLE, "The Chamber"),
		ImmutableMap.of(ID, 675465, TITLE, "Fracture"))));
    }

}
