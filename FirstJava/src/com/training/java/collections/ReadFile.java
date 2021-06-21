package com.training.java.collections;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReadFile {

    public static void main(final String[] args) {
        Path pathLoc = Paths.get("./employee.txt");
        try {
            List<String> readAllLinesLoc = Files.readAllLines(pathLoc,
                                                              Charset.forName("UTF-8"));

            Map<EGender, List<Employee>> collect2Loc = readAllLinesLoc.stream()
                                                                      .map(d -> d.split(";"))
                                                                      .filter(a -> a.length == 5)
                                                                      .map(d -> new Employee(d[0],
                                                                                             d[1],
                                                                                             EGender.getGender(d[2]),
                                                                                             Integer.parseInt(d[3]),
                                                                                             Integer.parseInt(d[4])))
                                                                      .collect(Collectors.groupingBy(h -> h.getGender()));

            Set<EGender> keySetLoc = collect2Loc.keySet();
            for (EGender eGenderLoc : keySetLoc) {
                System.out.println("Gender : " + eGenderLoc);
                List<Employee> listLoc = collect2Loc.get(eGenderLoc);
                for (Employee emp : listLoc) {
                    System.out.println(emp);
                }
                System.out.println("------------------------");
            }


            List<Employee> collectLoc = readAllLinesLoc.stream()
                                                       .map(d -> d.split(";"))
                                                       .filter(a -> a.length == 5)
                                                       .map(d -> new Employee(d[0],
                                                                              d[1],
                                                                              EGender.getGender(d[2]),
                                                                              Integer.parseInt(d[3]),
                                                                              Integer.parseInt(d[4])))
                                                       .collect(Collectors.toList());
            collectLoc.forEach(System.out::println);

            //            List<Employee> collectLoc = readAllLinesLoc.stream()
            //                    .filter(s -> s.length() > 10)
            //                    .map(d -> {
            //                        String[] splitLoc = d.split(";");
            //                        return new Employee(splitLoc[0],
            //                                            splitLoc[1],
            //                                            EGender.getGender(splitLoc[2]),
            //                                            Integer.parseInt(splitLoc[3]),
            //                                            Integer.parseInt(splitLoc[4]));
            //                    })
            //                    // .forEach(System.out::println);
            //                    .collect(Collectors.toList());
            //
            //collectLoc.forEach(System.out::println);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
