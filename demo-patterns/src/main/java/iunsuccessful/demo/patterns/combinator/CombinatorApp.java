package iunsuccessful.demo.patterns.combinator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 依韵 2020/3/4
 */
public class CombinatorApp {

    public static void main(String[] args) {
        var queriesOr = new String[] {"my", "Annabel"};

//        Finder finder = Finder.contains("Many");
//        List<String> strs = finder.find(text());
//
//        System.out.println(strs);

        Finder finder = filteredFinder("my", new String[]{ "2", "3" });
        List<String> strs = finder.find(text());

        System.out.println(strs);


    }

    public static Finder filteredFinder(String query, String... excludeQueries) {
        var finder = Finder.contains(query);

        for (String q : excludeQueries) {
            finder = finder.not(Finder.contains(q));
        }
        return finder;

    }

    public static Finder specializedFinder(String... queries) {

        var finder = identMult();

        for (String query : queries) {
            finder = finder.and(Finder.contains(query));
        }
        return finder;
    }

    private static Finder identMult() {
        return new Finder() {
            @Override
            public List<String> find(String txt) {
                return Stream.of(txt.split("\n")).collect(Collectors.toList());
            }
        };
    }

    private static String text() {
        return
                "It was many and many a year ago,\n"
                        + "In a kingdom by the sea,\n"
                        + "That a maiden there lived whom you may know\n"
                        + "By the name of ANNABEL LEE;\n"
                        + "And this maiden she lived with no other thought\n"
                        + "Than to love and be loved by me.\n"
                        + "I was a child and she was a child,\n"
                        + "In this kingdom by the sea;\n"
                        + "But we loved with a love that was more than love-\n"
                        + "I and my Annabel Lee;\n"
                        + "I and my Annabel2 Lee;\n"
                        + "I and my Annabel3 Lee;\n"
                        + "I and my Annabel4 Lee;\n"
                        + "With a love that the winged seraphs of heaven\n"
                        + "Coveted her and me.";
    }

}
