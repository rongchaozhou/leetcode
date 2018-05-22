class Solution {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new LinkedList<>();
    backtracking(res, new LinkedList<>(), n, k);
    return res;
  }

  private void backtracking(List<List<Integer>> res, LinkedList<Integer> curr, int leftSum,
      int leftNum) {
    if (leftSum < 0) {
      return;
    }
    if (leftNum == 0) {
      if (leftSum == 0) {
        res.add(new LinkedList<>(curr));
      }
      return;
    }
    int last = curr.isEmpty() ? 0 : curr.getLast();
    for (int i = last + 1; i <= 9; i++) {
      curr.add(i);
      backtracking(res, curr, leftSum - i, leftNum - 1);
      curr.removeLast();
    }
  }
}
