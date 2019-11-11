package experience.bcompany;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Problem1Test {

	@Test
	void braces() {
		String[] input = new String[] {"{{}}"};
		assertThat(Problem1.braces(input)).containsExactly("YES");
	}
}