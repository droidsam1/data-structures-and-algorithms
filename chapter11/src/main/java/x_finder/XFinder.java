package x_finder;

public class XFinder {

    private XFinder() {
    }

    public static int indexOfXIn(String input) {
        return indexOfXIn(input, 0);
    }

    private static int indexOfXIn(String input, int index) {
        if (input.equals("x")) {
            return index;
        }
        index++;
        return indexOfXIn(input.substring(1), index);
    }


}
