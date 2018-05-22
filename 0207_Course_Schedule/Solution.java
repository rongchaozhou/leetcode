class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preNum = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>(); //key for pre, value for courses that need pre

        for (int[] pair : prerequisites) {
            int course = pair[0], pre = pair[1];
            preNum[course]++;
            if (map.containsKey(pre)) {
                map.get(pre).add(course);
            } else {
                List<Integer> temp = new LinkedList<>();
                temp.add(course);
                map.put(pre, temp);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preNum[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int finished = queue.poll();
            if (map.containsKey(finished)) {
                for (int course : map.get(finished)) {
                    preNum[course]--;
                    if (preNum[course] == 0) {
                        queue.offer(course);
                    }
                }
                map.remove(finished);
            }
        }

        return map.isEmpty();
    }
}
