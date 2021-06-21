package com.training.java.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionRun {

    public static void main(final String[] args) {
        List<String> asListLoc = Arrays.asList("osman",
                                               "osman",
                                               "osman",
                                               "aliveli",
                                               "aliveli",
                                               "aliveli",
                                               "aliveli",
                                               "ayşegül",
                                               "ayşegül",
                                               "ayşegül",
                                               "ayşegül",
                                               "mehmet");
        //        for (String stringLoc : asListLoc) {
        //            System.out.println("Str : " + stringLoc);
        //            System.out.println(Thread.currentThread()
        //                                     .getName());
        //        }
        // Burası şunu yapıyor
        Optional<String> ofLoc = Optional.ofNullable(null);
        ofLoc.isPresent();
        String orElseLoc = ofLoc.orElse("mehemer");
        System.out.println(orElseLoc);
        // Burası şunu yapıyor
        System.out.println("--------------------------------------");
        asListLoc.stream()
                 //                 .skip(7)
                 //                 .limit(5)
                 .filter(r -> {
                     boolean xyz = true;
                     xyz = xyz && (r.length() > 4);
                     xyz = xyz && (r.length() < 8);
                     System.out.println("Filter1 : " + r);
                     return xyz;
                 })
                 .filter(r -> {
                     System.out.println("Filter2 : " + r);
                     return !r.startsWith("prefix");
                 })
                 .filter(r -> {
                     System.out.println("Filter3 : " + r);
                     return !r.startsWith("ps:");
                 })
                 .distinct()
                 .sorted((a,
                          b) -> {
                     System.out.println("Str1 : " + a + " Str2 : " + b);
                     return a.compareTo(b);
                 })
                 // .anyMatch(a-> a.length() > 4);
                 // .allMatch(a-> a.length() > 4);
                 // .findAny().orElse(null);
                 .forEach(System.out::println);

        List<String> collectLoc = asListLoc.stream()
                                           .filter(r -> {
                                               System.out.println("Filter1 : " + r);
                                               return r.length() > 4;
                                           })
                                           .filter(r -> {
                                               System.out.println("Filter2 : " + r);
                                               return !r.startsWith("prefix");
                                           })
                                           .filter(r -> {
                                               System.out.println("Filter3 : " + r);
                                               return !r.startsWith("ps:");
                                           })
                                           .distinct()
                                           .sorted((a,
                                                    b) -> {
                                               System.out.println("Str1 : " + a + " Str2 : " + b);
                                               return a.compareTo(b);
                                           })
                                           .collect(Collectors.toList());
    }
}
