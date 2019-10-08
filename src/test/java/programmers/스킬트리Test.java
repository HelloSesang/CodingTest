package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 스킬트리Test {

	@Test
	public void solution() {
		스킬트리 obj = new 스킬트리();
		assertEquals(2, obj.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
	}
}