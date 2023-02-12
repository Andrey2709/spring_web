package ru.geekbrains.spring_less_web.excemption;





public class ExceptDescript {
    private String massage;
    private int statusCode;

    public ExceptDescript(String massage, int statusCode) {
        this.massage = massage;
        this.statusCode = statusCode;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
