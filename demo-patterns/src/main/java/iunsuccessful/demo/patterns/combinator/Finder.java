package iunsuccessful.demo.patterns.combinator;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 依韵 2020/3/4
 */
public interface Finder {

    List<String> find(String text);

    static Finder contains(String word) {
        return text -> Stream.of(text.split("\n"))
                .filter(line -> line.toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    default Finder or(Finder orFinder) {
        return text -> {
            List<String> results = this.find(text);
            results.addAll(orFinder.find(text));
            return results;
        };
    }

    default Finder and(Finder andFinder) {
        // this finder 是那个 list
        // and finder 是 contains
        return text -> this
                .find(text)
                .stream()
                .flatMap(line -> andFinder.find(line).stream())
                .collect(Collectors.toList());
    }

    default Finder not(Finder notFinder) {
        return text -> {
            return this.find(text)
                    .stream()
                    .filter(s -> !notFinder.find(text).contains(s))
                    .collect(Collectors.toList());
        };
    }


}
