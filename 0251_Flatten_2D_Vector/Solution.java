class Vector2D implements Iterator<Integer> {
    List<List<Integer>> vector;
    int i, j;

    public Vector2D(List<List<Integer>> vec2d) {
        vector = vec2d;
        i = 0;
        j = 0;
    }

    @Override
    public Integer next() {
        return vector.get(i).get(j++);
    }

    @Override
    public boolean hasNext() {
        while (i < vector.size()) {
            if (j < vector.get(i).size()) {
                return true;
            } else {
                i++;
                j = 0;
            }
        }
        return false;
    }
}
