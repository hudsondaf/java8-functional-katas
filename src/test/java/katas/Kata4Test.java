package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import model.BoxArt;

public class Kata4Test {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";

    @Test
    public void testExecute() {
	Assert.assertThat(Kata4.execute().size(), equalTo(4));
    }

    // Não vai funcionar porque não estamos comparando com objetos.
    @Test
    public void testExecute1() {
	Assert.assertThat(Kata4.execute(),
		equalTo(ImmutableList.of(
			ImmutableMap.of(ID, 70111470, TITLE, "Die Hard", BOXART,
				"http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"),
			ImmutableMap.of(ID, 654356453, TITLE, "Bad Boys", BOXART,
				"http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg"),
			ImmutableMap.of(ID, 65432445, TITLE, "The Chamber", BOXART,
				"http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"),
			ImmutableMap.of(ID, 675465, TITLE, "Fracture", BOXART,
				"http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"))));
    }
}
