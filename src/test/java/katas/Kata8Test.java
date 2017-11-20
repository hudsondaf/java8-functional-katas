package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata8Test {

    public static final String VIDEO_ID = "videoId";
    public static final String BOOKMARK_ID = "bookmarkId";

    @Test
    public void testExecute() {
	Assert.assertThat(Kata8.execute().size(), equalTo(3));
    }

    @Test
    public void testExecute1() {
	Assert.assertThat(Kata8.execute(),
		equalTo(ImmutableList.of(ImmutableMap.of(VIDEO_ID, 70111470, BOOKMARK_ID, 470),
			ImmutableMap.of(VIDEO_ID, 654356453, BOOKMARK_ID, 453),
			ImmutableMap.of(VIDEO_ID, 65432445, BOOKMARK_ID, 445))));
    }
}
