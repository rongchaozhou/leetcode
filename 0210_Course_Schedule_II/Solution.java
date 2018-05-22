class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
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
        
        int i = 0;
        while (!queue.isEmpty()) {
            int finished = queue.poll();
            res[i] = finished;
            i++;
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

        return i == numCourses ? res : new int[0];
    }
}
