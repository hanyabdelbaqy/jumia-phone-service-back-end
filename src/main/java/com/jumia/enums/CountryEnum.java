package com.jumia.enums;

public enum CountryEnum {
    Cameroon("+237","\\(237\\)\\ ?[2368]\\d{7,8}$"),
    Ethiopia("+251", "\\(251\\)\\ ?[1-59]\\d{8}$"),
    Morocco("+212","\\(212\\)\\ ?[5-9]\\d{8}$"),
    Mozambique("+258","\\(258\\)\\ ?[28]\\d{7,8}$"),
    Uganda("+256","\\(256\\)\\ ?\\d{9}$");
    private final String code;
    private final String regex;

    private CountryEnum( String code, String regex){
        this.code = code;
        this.regex = regex;
    }

    public String getCode() {
        return code;
    }

    public String getRegex() {
        return regex;
    }

    public static CountryEnum findByCode(String code){
        for(CountryEnum c : values()){
            if( c.code.equals(code)){
                return c;
            }
        }
        return null;
    }
}
