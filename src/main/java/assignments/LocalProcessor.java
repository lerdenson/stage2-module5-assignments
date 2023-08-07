package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName = "";
    private Long period = 10_000_000_000_000L;
    private String processorVersion = "";
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringList = stringList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void iterateList(LinkedList<String> stringList) {
        this.stringList = new LinkedList<>(stringList);
        for (String str: stringList) {
            System.out.println(str.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateProcessorFullName(LinkedList<String> stringList) {
        StringBuilder builder = new StringBuilder(processorName);
        for (String str: stringList) {
            builder.append(str).append(' ');
        }
        processorName = builder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(file)) {
            this.informationScanner = scanner;
            StringBuilder stringBuilder = new StringBuilder(processorVersion);
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
            processorVersion = stringBuilder.toString();
        }


    }
}
