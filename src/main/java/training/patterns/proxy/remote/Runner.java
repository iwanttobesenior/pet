package training.patterns.proxy.remote;

import java.util.StringTokenizer;

class Runner {

    public static void main(String[] args) {
        String cp = System.getProperty("java.class.path");
        StringTokenizer stringTokenizer = new StringTokenizer(cp, "; ");

        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }

    }
}
