import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyTests {
	
	/*TODO: Add your own test cases here!
	 * We've provided a sample test case for each problem below
	 * You can use these as building blocks to write your own test cases
	 */
	
	@Test
	public void HuffmanSampleTest() {
		String input = "abc";
		Huffman h = new Huffman(input);
		String encoding = h.encode();
		assertEquals(input, h.decode(encoding));
		assertEquals("huffman abc compression", Huffman.compressionRatio(input), 0.20833, 0.01);
	}
	
	@Test
	public void IntervalSimpleTest() {
		GreedyDynamicAlgorithms.Interval red1  = new GreedyDynamicAlgorithms.Interval(1, 7);
		GreedyDynamicAlgorithms.Interval red2  = new GreedyDynamicAlgorithms.Interval(7, 14);
		GreedyDynamicAlgorithms.Interval red3  = new GreedyDynamicAlgorithms.Interval(1, 2);
				
		GreedyDynamicAlgorithms.Interval blue1 = new GreedyDynamicAlgorithms.Interval(0, 5);
		GreedyDynamicAlgorithms.Interval blue2 = new GreedyDynamicAlgorithms.Interval(6, 10);
		GreedyDynamicAlgorithms.Interval blue3 = new GreedyDynamicAlgorithms.Interval(11, 15);
		
		ArrayList<GreedyDynamicAlgorithms.Interval> reds  = new ArrayList<>();
		ArrayList<GreedyDynamicAlgorithms.Interval> blues = new ArrayList<>();
		
		reds.add(red1);
		reds.add(red2);
		reds.add(red3);
		
		blues.add(blue1);
		blues.add(blue2);
		blues.add(blue3);
		
		int expectedOptimal = 2;
		int actualOptimal = GreedyDynamicAlgorithms.optimalIntervals(reds, blues);
		assertEquals(expectedOptimal, actualOptimal);
	}
	
	@Test
	public void OptimalGridPathSimpleTest() {
		int[][] grid = new int[][] { { 0, 0, 9, 9 },
									 { 9, 0, 0, 9 },
									 { 9, 9, 0, 0 },
									 { 9, 9, 9, 0 } };

		List<GreedyDynamicAlgorithms.Direction> expected = new ArrayList<GreedyDynamicAlgorithms.Direction>();
		expected.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expected.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expected.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expected.add(GreedyDynamicAlgorithms.Direction.DOWN);
		expected.add(GreedyDynamicAlgorithms.Direction.RIGHT);
		expected.add(GreedyDynamicAlgorithms.Direction.DOWN);
		
		List<GreedyDynamicAlgorithms.Direction> actual = GreedyDynamicAlgorithms.optimalGridPath(grid);
		assertEquals(expected.size(), actual.size());
		
		for (int i = 0; i < actual.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}
}

