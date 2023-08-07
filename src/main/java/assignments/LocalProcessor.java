package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    Scanner informationScanner;
    static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void iterateList(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateProcessorFullName(LinkedList<String> stringList) {
        StringBuilder builder = new StringBuilder(processorName);
        for (int i = 0; i < stringArrayList.size(); i++) {
            builder.append(stringList.get(i)).append(' ');
        }
        processorName = builder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try {
            informationScanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder(processorVersion);
            while (informationScanner.hasNext()) {
                stringBuilder.append(informationScanner.nextLine());
            }
            processorVersion = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } finally {
            informationScanner.close();
        }


    }
}
