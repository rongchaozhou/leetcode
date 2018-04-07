class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int start = 0, end = 0, cnt = words[0].length();
        while (end < words.length) {
            if (end == words.length - 1) {
                res.add(generateLastLine(words, start, end, cnt, maxWidth));
                break;
            } else if (words[end + 1].length() + 1 + cnt <= maxWidth) {
                end += 1;
                cnt += words[end].length() + 1;
            } else {
                res.add(generateNotLastLine(words, start, end, cnt, maxWidth));
                start = end + 1;
                end = end + 1;
                cnt = words[start].length();
            }
        }
        return res;
    }

    private String generateNotLastLine(String[] words, int start, int end, int cnt, int maxWidth) {
        if (start == end) {
            return generateLastLine(words, start, end, cnt, maxWidth);
        }
        int goodSlot, goodSpace;
        if ((maxWidth - cnt) % (end - start) == 0) {
            goodSlot = end - start;
            goodSpace = (maxWidth - cnt) / (end - start);
        } else {
            goodSlot = (maxWidth - cnt) % (end - start);
            goodSpace = (maxWidth - cnt) / (end - start) + 1;
        }

        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < goodSpace; i++) {
            spaces.append(" ");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < end - start; i++) {
            sb.append(words[start + i]);
            sb.append(spaces.toString());
            if (i + 1 <= goodSlot) {
                sb.append(" ");
            }
        }
        sb.append(words[end]);
        return sb.toString();
    }

    private String generateLastLine(String[] words, int start, int end, int cnt, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[end]);
        for (int i = cnt; i < maxWidth; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
