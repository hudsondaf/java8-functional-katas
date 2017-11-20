package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata10Test {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";
    public static final String NAME = "name";
    public static final String VIDEOS = "videos";
    public static final String LIST_ID = "listId";

    @Test
    public void testExecute() {
	Assert.assertThat(Kata10.execute().size(), equalTo(2));
    }

    @Test
    public void testExecute1() {
	Assert.assertThat(Kata10.execute(),
		equalTo(ImmutableList.of(
			ImmutableMap.of(NAME, "New Releases", VIDEOS,
				ImmutableList.of(ImmutableMap.of(ID, 65432445, TITLE, "The Chamber"),
					ImmutableMap.of(ID, 675465, TITLE, "Fracture"))),
			ImmutableMap.of(NAME, "Thrillers", VIDEOS,
				ImmutableList.of(ImmutableMap.of(ID, 70111470, TITLE, "Die Hard"),
					ImmutableMap.of(ID, 654356453, TITLE, "Bad Boys"))))));
    }
}
