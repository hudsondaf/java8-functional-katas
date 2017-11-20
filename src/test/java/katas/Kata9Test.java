package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata9Test {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";
    public static final String TIME = "time";

    @Test
    public void testExecute() {
	Assert.assertThat(Kata9.execute().size(), equalTo(4));
    }

    // Tem a chance de não funcionar, pois a execução roda um new Date()
    @Test
    public void testExecute1() {
	Assert.assertThat(Kata9.execute(),
		equalTo(ImmutableList.of(
			ImmutableMap.of(ID, 70111470, TITLE, "Die Hard", TIME, new Date(), BOXART,
				"http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"),
			ImmutableMap.of(ID, 654356453, TITLE, "Bad Boys", TIME, new Date(), BOXART,
				"http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg"),
			ImmutableMap.of(ID, 65432445, TITLE, "The Chamber", TIME, new Date(), BOXART,
				"http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"),
			ImmutableMap.of(ID, 675465, TITLE, "Fracture", TIME, new Date(), BOXART,
				"http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"))));
    }
}
