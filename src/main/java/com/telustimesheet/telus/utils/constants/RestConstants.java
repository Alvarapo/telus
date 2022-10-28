package com.telustimesheet.telus.utils.constants;

public class RestConstants {

    public static final String APPLICATION_NAME = "/telus";
    public static final String API_VERSION_1 = "/v1";
    public static final String SUCCESS = "Success";




    public static final String RESOURCE_TASKS = "/tasks";
    public static final String RESOURCE_DATE= "/date/{date}";
    public static final String RESOURCE_ID= "/id/{id}";
    public static final String RESOURCE_DURATION= "/duration/{duration}";
    public static final String RESOURCE_BY_MONTH = "/month/{month}";
    public static final String RESOURCE_BETWEEN_DATE= "/date/{date1}/date/{date2}";




    public static final String RESOURCE_TOTAL_DURATION= "/total-duration";
    public static final String RESOURCE_YEAR_RESUME = "/year-resume";
    public static final String RESOURCE_TOTAL_PAYROLL = "/total-payroll";
    public static final String RESOURCE_TOTAL_IRPF = "/total-irpf";


    private RestConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
