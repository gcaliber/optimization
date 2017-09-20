
import java.util.*;

public class GreedyDynamicAlgorithms {

	/**
	 * Goal: find the smallest number of red intervals to select, such that
	 * every blue interval overlaps with at least one of the selected red intervals.
	 * Output this number
	 * 
	 * @param red - the list of red intervals
	 * @param blue - the list blue intervals
	 * @return
	 */
	public static int optimalIntervals(ArrayList<Interval> red, ArrayList<Interval> blue) {
//		System.out.println("Red");
//		for (Interval v : red) {
//			System.out.println(v.start + " -> " + v.finish);
//		}
//		System.out.println();
//		System.out.println("Blue");
//		for (Interval v : blue) {
//			System.out.println(v.start + " -> " + v.finish);
//		}
//		System.out.println("-----------------------------");
		
		if (blue.size() == 0)  return 0;
		
		Interval max = maxOverlaps(red, blue);
		
		removeOverlaps(max, blue);
		red.remove(max);
		
		return 1 + optimalIntervals(red, blue);
	}
	
	private static Interval maxOverlaps(ArrayList<Interval> red, ArrayList<Interval> blue) {
		Interval max = null;
		
		int maxOverlapCount = 0;
		for (Interval redInterval : red) {
			int overlapCount = 0;
			for (Interval blueInterval : blue) {
				if (redInterval.overlaps(blueInterval)) {
					overlapCount++;
				}
			}
			if (overlapCount > maxOverlapCount) {
				maxOverlapCount = overlapCount;
				max = redInterval;
			}
		}
		return max;
	}
	
	private static void removeOverlaps(Interval v, ArrayList<Interval> list) {
		ArrayList<Interval> toBeRemoved = new ArrayList<Interval>();
		for (Interval w : list) {
			if (v.overlaps(w)) {
				toBeRemoved.add(w);
			}
		}
		for (Interval x : toBeRemoved) {
			list.remove(x);
		}
	}
	
	
	
	/**
	 * Goal: find any path of lowest cost from the top-left of the grid (grid[0][0])
	 * to the bottom right of the grid (grid[m-1][n-1]).  Output this sequence of directions
	 * 
	 * @param grid - the 2d grid containing the cost of each location in the grid.
	 * @return
	 */
	public static List<Direction> optimalGridPath(int[][] grid) {
		
		return null;
	}
	
	/**
	 * A simple Direction enum
	 * directions can be either DOWN or RIGHT
	 * You will output a list of these in the grid-path problem
	 */
	public static enum Direction {
		DOWN, RIGHT
	}

	/**
	 * A private Interval class to help with the interval question
	 */
	public static class Interval {
		
		int start;
		int finish;
		
		public Interval(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
		
		public boolean overlaps(Interval that) {
			if (this.start > that.finish)  return false;
			if (this.finish < that.start)  return false;
			return true;
		}
		
		/**
		 * sorts a list of intervals by start time, you are free to use this on the first question
		 */
		public static void sortByStartTime(ArrayList<Interval> l) {
			Collections.sort(l, new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {
					Interval i1 = (Interval) o1;
					Interval i2 = (Interval) o2;
					return i1.start - i2.start;
				}
			});
		}
		
		/**
		 * sorts a list of intervals by finish time, you are free to use this on the first question
		 */
		public static void sortByFinishTime(ArrayList<Interval> l) {
			Collections.sort(l, new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {
					Interval i1 = (Interval) o1;
					Interval i2 = (Interval) o2;
					return i1.finish - i2.finish;
				}
			});
		}
	}
	
}
