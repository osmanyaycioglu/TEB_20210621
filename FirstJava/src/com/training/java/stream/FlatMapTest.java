package com.training.java.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {

    public static void main(final String[] args) {
        List<String> asListLoc = Arrays.asList("osman",
                                               "ali",
                                               "veli",
                                               "ayse",
                                               "mehmet");
        List<Character> collectLoc = asListLoc.stream()
                                              .map(s -> s.toCharArray())
                                              .map(ca -> {
                                                  Character[] char1 = new Character[ca.length];
                                                  for (int iLoc = 0; iLoc < char1.length; iLoc++) {
                                                      char1[iLoc] = ca[iLoc];
                                                  }
                                                  return char1;
                                              })
                                              .flatMap(ch -> Arrays.stream(ch))
                                              .distinct()
                                              .sorted()
                                              .collect(Collectors.toList());
        System.out.println(collectLoc);

        IntSummaryStatistics summaryStatisticsLoc = asListLoc.stream()
                                                             .mapToInt(s -> s.length())
                                                             .summaryStatistics();
        System.out.println(summaryStatisticsLoc);

        // char[] Character[]
        // Data 1= {'o','s','m','a','n'}, Data 2={'a','l','i'}...
        // Data 1='o' Data 2= 's' Data 3='m'
    }
}
