package core.basesyntax;

import java.time.LocalDate;

public record SalaryData(LocalDate date, String name, int hoursWorked, int paymentPerHour) {
    private static final int PARSE_DATE_INDEX = 0;
    private static final int PARSE_NAME_INDEX = 1;
    private static final int PARSE_HOURS_INDEX = 2;
    private static final int PARSE_PAYMENT_INDEX = 3;
    private static final String PARSE_DELIMITER_REGEX = " ";

    public static SalaryData parse(String data) {
        String[] dataSplit = data.split(PARSE_DELIMITER_REGEX);
        LocalDate date = DateParser.parseDate(dataSplit[PARSE_DATE_INDEX]);
        String name = dataSplit[PARSE_NAME_INDEX];
        int hoursWorked = Integer.parseInt(dataSplit[PARSE_HOURS_INDEX]);
        int paymentPerHour = Integer.parseInt(dataSplit[PARSE_PAYMENT_INDEX]);
        return new SalaryData(date, name, hoursWorked, paymentPerHour);
    }
}
