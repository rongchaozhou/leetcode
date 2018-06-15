import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    class BuildingPoints implements Comparable<BuildingPoints> {
        int x;
        int height;
        boolean isStart;

        public BuildingPoints(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(BuildingPoints that) {
            if (this.x != that.x) return this.x - that.x;
            else if (this.isStart && that.isStart) {
                return that.height - this.height;
            } else if (!this.isStart && !that.isStart) {
                return this.height - that.height;
            } else if (this.isStart) {
                return -1;
            } else return 1;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoints[] buildingPoints = new BuildingPoints[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            buildingPoints[i * 2] = new BuildingPoints(buildings[i][0], buildings[i][2], true);
            buildingPoints[i * 2 + 1] = new BuildingPoints(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(buildingPoints);

        List<int[]> res = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int preMax = 0;
        for (BuildingPoints bp : buildingPoints) {
            int height = bp.height;
            if (bp.isStart) {
                map.put(height, map.getOrDefault(height, 0) + 1);
            } else {
                if (map.get(height) == 1) map.remove(height);
                else map.put(height, map.get(height) - 1);
            }
            int currMax = map.lastKey();
            if (currMax != preMax) {
                res.add(new int[]{bp.x, currMax});
            }
            preMax = currMax;
        }
        return res;
    }
}
